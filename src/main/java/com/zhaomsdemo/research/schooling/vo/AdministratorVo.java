package com.zhaomsdemo.research.schooling.vo;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AdministratorVo {

    String id;
    String fullName;
    String loginId;
    String email;
}
