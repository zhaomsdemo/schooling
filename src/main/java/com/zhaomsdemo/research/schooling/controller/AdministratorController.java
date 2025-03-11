package com.zhaomsdemo.research.schooling.controller;

import com.zhaomsdemo.research.schooling.domain.Administrator;
import com.zhaomsdemo.research.schooling.dto.AdministratorDto;
import com.zhaomsdemo.research.schooling.service.AdministratorService;
import com.zhaomsdemo.research.schooling.vo.Result;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/administrator")
@RequiredArgsConstructor
public class AdministratorController {

    private final AdministratorService administratorService;

    @PostMapping("/batch")
    public Result<List<Administrator>> importAdministrators(@RequestBody List<AdministratorDto> administratorDtos) {
        List<Administrator> administrators = administratorService.importAdministrators(administratorDtos);
        return Result.success(administrators, administrators.size());
    }

    @PostMapping("")
    public Result<Administrator> create(@RequestBody AdministratorDto administratorDto) {
        Administrator administrator = administratorService.create(administratorDto);
        return Result.success(administrator, 1);
    }

    @PutMapping("/{id}")
    public Result<Administrator> update(@PathVariable String id, @RequestBody AdministratorDto administratorDto) {
        Administrator administrator = administratorService.update(id, administratorDto);
        return Result.success(administrator, 1);
    }

    @DeleteMapping("/{id}")
    public Result<Administrator> delete(@PathVariable String id) {
        Administrator administrator = administratorService.delete(id);
        return Result.success(administrator, 1);
    }

    @GetMapping("/{id}")
    public Result<Administrator> findById(@PathVariable String id) {
        Administrator administrator = administratorService.findById(id);
        return Result.success(administrator, 1);
    }

    @GetMapping("/all")
    public Result<List<Administrator>> findAll(@RequestParam(required = false, defaultValue = "0") Integer page,
                                               @RequestParam(required = false, defaultValue = "10") Integer size) {
        List<Administrator> administrators = administratorService.findAll(PageRequest.of(page, size));
        return Result.success(administrators, administrators.size());
    }
}
