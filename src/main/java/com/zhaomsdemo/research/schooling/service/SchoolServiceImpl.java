package com.zhaomsdemo.research.schooling.service;

import com.zhaomsdemo.research.schooling.domain.Administrator;
import com.zhaomsdemo.research.schooling.domain.School;
import com.zhaomsdemo.research.schooling.dto.SchoolDto;
import com.zhaomsdemo.research.schooling.enumeration.SchoolStatus;
import com.zhaomsdemo.research.schooling.exception.DataNotFoundException;
import com.zhaomsdemo.research.schooling.repository.AdministratorRepository;
import com.zhaomsdemo.research.schooling.repository.SchoolRepository;
import com.zhaomsdemo.research.schooling.vo.SchoolVo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

import static com.zhaomsdemo.research.schooling.mapper.SchoolMapper.toNewEntity;
import static com.zhaomsdemo.research.schooling.mapper.SchoolMapper.toVo;
import static java.util.Optional.ofNullable;

@Service
@RequiredArgsConstructor
@Slf4j
public class SchoolServiceImpl implements SchoolService {

    private final SchoolRepository schoolRepository;
    private final AdministratorRepository administratorRepository;

    @Override
    public SchoolVo registerNewSchool(SchoolDto schoolDto) {
        School school = toNewEntity(schoolDto);
        return toVo(schoolRepository.save(school));
    }

    @Override
    public SchoolVo update(String id, SchoolDto schoolDto) {
        School school = schoolRepository.findById(id)
                .orElseThrow(() -> new DataNotFoundException("School not found : " + id));
        ofNullable(schoolDto.getSchoolName()).ifPresent(school::setSchoolName);
        ofNullable(schoolDto.getSchoolCode()).ifPresent(school::setSchoolCode);
        ofNullable(schoolDto.getAddress()).ifPresent(school::setAddress);
        ofNullable(schoolDto.getGrades()).ifPresent(school::setGrades);
        ofNullable(schoolDto.getSchoolType()).ifPresent(school::setSchoolType);
        ofNullable(schoolDto.getDescription()).ifPresent(school::setDescription);
        return toVo(schoolRepository.save(school));
    }

    @Override
    public SchoolVo unregisterSchool(String id) {
        School school = schoolRepository.findById(id)
                .orElseThrow(() -> new DataNotFoundException("School not found : " + id));
        school.setStatus(SchoolStatus.ARCHIVED);
        return toVo(schoolRepository.save(school));
    }

    @Override
    public SchoolVo findSchoolById(String id) {
        School school = schoolRepository.findById(id)
                .orElseThrow(() -> new DataNotFoundException("School not found : " + id));
        return toVo(school);
    }

    @Override
    public SchoolVo findSchoolByName(String schoolName) {
        School school = schoolRepository.findFirstBySchoolName(schoolName)
                .orElseThrow(() -> new DataNotFoundException("School not found : " + schoolName));
        return toVo(school);
    }

    @Override
    public List<SchoolVo> findAllSchools(Pageable pageable) {
        List<School> schools = schoolRepository.findAll(pageable).getContent();
        return schools.stream().map(school -> toVo(school)).collect(Collectors.toList());
    }

    @Override
    public SchoolVo addApprover(String schoolId, List<String> administratorIds) {
        School school = schoolRepository.findById(schoolId)
                .orElseThrow(() -> new DataNotFoundException("School not found : " + schoolId));
        List<Administrator> administrators = administratorRepository.findAllById(administratorIds);
        ofNullable(school.getApprovers()).ifPresentOrElse(set -> set.addAll(administrators),
                () -> {
                    school.setApprovers(new HashSet<>());
                    school.getApprovers().addAll(administrators);
                });
        return toVo(schoolRepository.save(school));
    }
}
