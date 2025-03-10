package com.zhaomsdemo.research.schooling.dto;

import com.zhaomsdemo.research.schooling.enumeration.SchoolStatus;
import com.zhaomsdemo.research.schooling.enumeration.SchoolType;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SchoolDto {

    String schoolName;
    String schoolCode;
    String address;
    String grades;
    SchoolType schoolType;
    SchoolStatus status;
    String description;
}
