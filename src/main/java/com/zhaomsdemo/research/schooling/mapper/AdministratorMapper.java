package com.zhaomsdemo.research.schooling.mapper;

import com.zhaomsdemo.research.schooling.domain.Administrator;
import com.zhaomsdemo.research.schooling.dto.AdministratorDto;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import static java.util.Optional.ofNullable;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class AdministratorMapper {

    public static Administrator newEntity(AdministratorDto dto) {
        return Administrator.builder()
                .email(dto.getEmail())
                .loginId(dto.getLoginId())
                .password(dto.getPassword())
                .fullName(dto.getFullName())
                .build();
    }

    public static void updateEntity(Administrator administrator, AdministratorDto administratorDto) {
        ofNullable(administratorDto.getFullName()).ifPresent(administrator::setFullName);
        ofNullable(administratorDto.getEmail()).ifPresent(administrator::setEmail);
        ofNullable(administratorDto.getLoginId()).ifPresent(administrator::setId);
        ofNullable(administratorDto.getPassword()).ifPresent(administrator::setPassword);
    }
}
