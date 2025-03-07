package com.zhaomsdemo.research.schooling.dto;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AdministratorDto {

    String fullName;
    String loginId;
    String password;
    String email;
}
