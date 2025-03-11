package com.zhaomsdemo.research.schooling.service;

import com.zhaomsdemo.research.schooling.domain.Administrator;
import com.zhaomsdemo.research.schooling.domain.School;
import com.zhaomsdemo.research.schooling.dto.SchoolDto;
import com.zhaomsdemo.research.schooling.enumeration.SchoolStatus;
import com.zhaomsdemo.research.schooling.exception.DataNotFoundException;
import com.zhaomsdemo.research.schooling.repository.AdministratorRepository;
import com.zhaomsdemo.research.schooling.repository.SchoolRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;

import static com.zhaomsdemo.research.schooling.mapper.SchoolMapper.toNewEntity;
import static java.util.Optional.ofNullable;

@Service
@RequiredArgsConstructor
@Slf4j
public class SchoolServiceImpl implements SchoolService {

    private final SchoolRepository schoolRepository;
    private final AdministratorRepository administratorRepository;

    @Override
    public School registerNewSchool(SchoolDto schoolDto) {
        School school = toNewEntity(schoolDto);
        return schoolRepository.save(school);
    }

    @Override
    public School update(String id, SchoolDto schoolDto) {
        School school = schoolRepository.findById(id)
                .orElseThrow(() -> new DataNotFoundException("School not found : " + id));
        ofNullable(schoolDto.getSchoolName()).ifPresent(school::setSchoolName);
        ofNullable(schoolDto.getSchoolCode()).ifPresent(school::setSchoolCode);
        ofNullable(schoolDto.getAddress()).ifPresent(school::setAddress);
        ofNullable(schoolDto.getGrades()).ifPresent(school::setGrades);
        ofNullable(schoolDto.getSchoolType()).ifPresent(school::setSchoolType);
        ofNullable(schoolDto.getDescription()).ifPresent(school::setDescription);
        return schoolRepository.save(school);
    }

    @Override
    public School unregisterSchool(String id) {
        School school = schoolRepository.findById(id)
                .orElseThrow(() -> new DataNotFoundException("School not found : " + id));
        school.setStatus(SchoolStatus.ARCHIVED);
        return schoolRepository.save(school);
    }

    @Override
    public School findSchoolById(String id) {
        School school = schoolRepository.findById(id)
                .orElseThrow(() -> new DataNotFoundException("School not found : " + id));
        return school;
    }

    @Override
    public School findSchoolByName(String schoolName) {
        School school = schoolRepository.findFirstBySchoolName(schoolName)
                .orElseThrow(() -> new DataNotFoundException("School not found : " + schoolName));
        return school;
    }

    @Override
    public List<School> findAllSchools(Pageable pageable) {
        return schoolRepository.findAll(pageable).getContent();
    }

    @Override
    public School addApprover(String schoolId, String administratorId) {
        School school = schoolRepository.findById(schoolId)
                .orElseThrow(() -> new DataNotFoundException("School not found : " + schoolId));
        Administrator administrator = administratorRepository.findById(administratorId)
                .orElseThrow(() -> new DataNotFoundException("Administrator not found : " + administratorId));
        ofNullable(school.getApprovers()).ifPresentOrElse(set -> set.add(administrator),
                () -> {
                    school.setApprovers(new HashSet<>());
                    school.getApprovers().add(administrator);
                });
        return schoolRepository.save(school);
    }
}
