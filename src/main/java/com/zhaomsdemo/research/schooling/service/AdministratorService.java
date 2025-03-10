package com.zhaomsdemo.research.schooling.service;

import com.zhaomsdemo.research.schooling.domain.Administrator;
import com.zhaomsdemo.research.schooling.dto.AdministratorDto;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface AdministratorService {

    List<Administrator> importAdministrators(List<AdministratorDto> administratorDtos);
    Administrator create(AdministratorDto administratorDto);
    Administrator update(String id, AdministratorDto administratorDto);
    Administrator delete(String id);
    Administrator findById(String id);
    List<Administrator> findAll(Pageable pageable);
}
