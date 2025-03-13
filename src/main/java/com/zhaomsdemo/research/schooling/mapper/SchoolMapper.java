package com.zhaomsdemo.research.schooling.mapper;

import com.zhaomsdemo.research.schooling.domain.School;
import com.zhaomsdemo.research.schooling.dto.SchoolDto;
import com.zhaomsdemo.research.schooling.enumeration.SchoolStatus;
import com.zhaomsdemo.research.schooling.vo.AdministratorVo;
import com.zhaomsdemo.research.schooling.vo.SchoolVo;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class SchoolMapper {

    public static School toNewEntity(SchoolDto schoolDto) {
        return School.builder()
                .schoolName(schoolDto.getSchoolName())
                .schoolCode(schoolDto.getSchoolCode())
                .address(schoolDto.getAddress())
                .grades(schoolDto.getGrades())
                .schoolType(schoolDto.getSchoolType())
                .status(SchoolStatus.DRAFT)
                .description(schoolDto.getDescription())
                .build();
    }

    public static SchoolVo toVo(School school) {
        SchoolVo vo = SchoolVo.builder()
                .id(school.getId())
                .schoolName(school.getSchoolName())
                .schoolCode(school.getSchoolCode())
                .address(school.getAddress())
                .grades(school.getGrades())
                .schoolType(school.getSchoolType())
                .status(school.getStatus())
                .description(school.getDescription())
                .approvers(school.getApprovers().stream()
                        .map(administrator -> AdministratorVo.builder()
                                .id(administrator.getId())
                                .email(administrator.getEmail())
                                .loginId(administrator.getLoginId())
                                .fullName(administrator.getFullName())
                                .build())
                        .toList())
                .build();
        return vo;
    }
}
