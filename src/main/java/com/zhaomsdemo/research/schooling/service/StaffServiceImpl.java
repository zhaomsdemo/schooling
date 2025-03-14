package com.zhaomsdemo.research.schooling.service;

import com.zhaomsdemo.research.schooling.domain.School;
import com.zhaomsdemo.research.schooling.domain.Staff;
import com.zhaomsdemo.research.schooling.dto.StaffDto;
import com.zhaomsdemo.research.schooling.exception.DataNotFoundException;
import com.zhaomsdemo.research.schooling.repository.SchoolRepository;
import com.zhaomsdemo.research.schooling.repository.StaffRepository;
import com.zhaomsdemo.research.schooling.vo.StaffVo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.zhaomsdemo.research.schooling.mapper.StaffMapper.toEntity;
import static com.zhaomsdemo.research.schooling.mapper.StaffMapper.toVo;
import static com.zhaomsdemo.research.schooling.mapper.StaffMapper.updateEntity;

@Service
@RequiredArgsConstructor
@Slf4j
public class StaffServiceImpl implements StaffService {

    private final StaffRepository staffRepository;
    private final SchoolRepository schoolRepository;

    @Override
    public StaffVo findById(String id) {
        Staff staff = staffRepository.findById(id)
                .orElseThrow(() -> new DataNotFoundException("Staff not found : " + id));
        return toVo(staff);
    }

    @Override
    public List<StaffVo> findByName(String name) {
        List<Staff> staffs = staffRepository.findByFullNameContaining(name);
        return staffs.stream().map(staff -> toVo(staff)).collect(Collectors.toList());
    }

    @Override
    public List<StaffVo> findByEmail(String email) {
        List<Staff> staffs = staffRepository.findByEmailContaining(email);
        return staffs.stream().map(staff -> toVo(staff)).collect(Collectors.toList());
    }

    @Override
    public StaffVo create(StaffDto staffDto) {
        Staff staff = toEntity(staffDto);
        School school = schoolRepository.findById(staffDto.getSchoolId())
                .orElseThrow(() -> new DataNotFoundException("School not found : " + staffDto.getSchoolId()));
        staff.setSchool(school);
        staffRepository.save(staff);
        return toVo(staff);
    }

    @Override
    public StaffVo update(String id, StaffDto staffDto) {
        Staff staff = staffRepository.findById(id)
                .orElseThrow(() -> new DataNotFoundException("Staff not found : " + id));
        updateEntity(staff, staffDto);
        staffRepository.save(staff);
        return toVo(staff);
    }

    /**
     * What it looks like in school after staff is deleted?
     * @param id
     * @return
     */
    @Override
    public StaffVo delete(String id) {
        Staff staff = staffRepository.findById(id)
                .orElseThrow(() -> new DataNotFoundException("Staff not found : " + id));
        staffRepository.delete(staff);
        return toVo(staff);
    }
}
