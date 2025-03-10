package com.zhaomsdemo.research.schooling.mapper;

import com.zhaomsdemo.research.schooling.domain.School;
import com.zhaomsdemo.research.schooling.dto.SchoolDto;
import com.zhaomsdemo.research.schooling.enumeration.SchoolStatus;
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
}
