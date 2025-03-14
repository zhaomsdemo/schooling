package com.zhaomsdemo.research.schooling.vo;

import com.zhaomsdemo.research.schooling.enumeration.StaffType;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class StaffVo {

    String id;
    String schoolId;
    String schoolName;
    String fullName;
    String email;
    String phone;
    StaffType type;
}
