package com.zhaomsdemo.research.schooling.controller;

import com.zhaomsdemo.research.schooling.domain.School;
import com.zhaomsdemo.research.schooling.dto.SchoolDto;
import com.zhaomsdemo.research.schooling.service.SchoolService;
import com.zhaomsdemo.research.schooling.vo.Result;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/school")
@RequiredArgsConstructor
public class SchoolController {

    private final SchoolService schoolService;

    @GetMapping("/{id}")
    public Result<School> findSchoolById(@PathVariable String id) {
        School school = schoolService.findSchoolById(id);
        return Result.success(school, 1);
    }

    @GetMapping("/all")
    public Result<List<School>> findAllSchools(@RequestParam(required = false, defaultValue = "0") Integer page,
                                               @RequestParam(required = false, defaultValue = "10") Integer size) {
        List<School> schools = schoolService.findAllSchools(PageRequest.of(page, size));
        return Result.success(schools, schools.size());
    }

    @PostMapping("")
    public Result<School> registerSchool(@RequestBody SchoolDto schoolDto) {
        School school = schoolService.registerNewSchool(schoolDto);
        return Result.success(school, 1);
    }

    @PostMapping("/{schoolId}/approver/{administratorId}")
    public Result<School> addApprover(@PathVariable String schoolId, @PathVariable String administratorId) {
        School school = schoolService.addApprover(schoolId, administratorId);
        return Result.success(school, 1);
    }
}
