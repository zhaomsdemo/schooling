package com.zhaomsdemo.research.schooling.mapper;

import com.zhaomsdemo.research.schooling.domain.Staff;
import com.zhaomsdemo.research.schooling.dto.StaffDto;
import com.zhaomsdemo.research.schooling.vo.StaffVo;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import static java.util.Optional.ofNullable;

@NoArgsConstructor(access = AccessLevel.PACKAGE)
public class StaffMapper {

    public static Staff toEntity(StaffDto staffDto) {
        return Staff.builder()
                .fullName(staffDto.getFullName())
                .email(staffDto.getEmail())
                .phone(staffDto.getPhone())
                .type(staffDto.getType())
                .build();
    }

    public static void updateEntity(Staff staff, StaffDto staffDto) {
        ofNullable(staffDto.getFullName()).ifPresent(staff::setFullName);
        ofNullable(staffDto.getEmail()).ifPresent(staff::setEmail);
        ofNullable(staffDto.getPhone()).ifPresent(staff::setPhone);
        ofNullable(staffDto.getType()).ifPresent(staff::setType);
    }

    public static StaffVo toVo(Staff staff) {
        return StaffVo.builder()
                .id(staff.getId())
                .fullName(staff.getFullName())
                .email(staff.getEmail())
                .phone(staff.getPhone())
                .type(staff.getType())
                .schoolId(staff.getSchool().getId())
                .schoolName(staff.getSchool().getSchoolName())
                .build();
    }
}
