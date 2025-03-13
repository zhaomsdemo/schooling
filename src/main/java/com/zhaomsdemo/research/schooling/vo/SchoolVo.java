package com.zhaomsdemo.research.schooling.vo;

import com.zhaomsdemo.research.schooling.enumeration.SchoolStatus;
import com.zhaomsdemo.research.schooling.enumeration.SchoolType;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SchoolVo {
    String id;
    String schoolName;
    String schoolCode;
    String address;
    String grades;
    SchoolType schoolType;
    SchoolStatus status;
    String description;
    List<AdministratorVo> approvers;
}
