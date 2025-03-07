package com.zhaomsdemo.research.schooling.service;

import com.zhaomsdemo.research.schooling.domain.Administrator;
import com.zhaomsdemo.research.schooling.dto.AdministratorDto;
import com.zhaomsdemo.research.schooling.exception.DataNotFoundException;
import com.zhaomsdemo.research.schooling.repository.AdministratorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.zhaomsdemo.research.schooling.mapper.AdministratorMapper.toEntity;
import static com.zhaomsdemo.research.schooling.mapper.AdministratorMapper.updateEntity;

@Service
@RequiredArgsConstructor
public class AdministratorServiceImpl implements AdministratorService {

    private final AdministratorRepository administratorRepository;

    @Override
    public Administrator create(AdministratorDto administratorDto) {
        Administrator administrator = toEntity(administratorDto);
        return administratorRepository.save(administrator);
    }

    @Override
    public Administrator update(String id, AdministratorDto administratorDto) {
        Administrator administrator = administratorRepository.findById(id)
                .orElseThrow(() -> new DataNotFoundException("Administrator not found : " + id));
        updateEntity(administrator, administratorDto);
        return administratorRepository.save(administrator);
    }

    @Override
    public Administrator delete(String id) {
        Administrator administrator = administratorRepository.findById(id)
                .orElseThrow(() -> new DataNotFoundException(id));
        administratorRepository.delete(administrator);
        return administrator;
    }

    @Override
    public Administrator findById(String id) {
        Administrator administrator = administratorRepository.findById(id)
                .orElseThrow(() -> new DataNotFoundException(id));
        return administrator;
    }

    @Override
    public List<Administrator> findAll(Pageable pageable) {
        return administratorRepository.findAll(pageable).getContent();
    }
}
