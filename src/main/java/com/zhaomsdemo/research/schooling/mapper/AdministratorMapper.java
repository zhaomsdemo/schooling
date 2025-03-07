package com.zhaomsdemo.research.schooling.mapper;

import com.zhaomsdemo.research.schooling.domain.Administrator;
import com.zhaomsdemo.research.schooling.dto.AdministratorDto;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class AdministratorMapper {

    public static Administrator toEntity(AdministratorDto dto) {
        return Administrator.builder()
                .email(dto.getEmail())
                .loginId(dto.getLoginId())
                .password(dto.getPassword())
                .fullName(dto.getFullName())
                .build();
    }
}
