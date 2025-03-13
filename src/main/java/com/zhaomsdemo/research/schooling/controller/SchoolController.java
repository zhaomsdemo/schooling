package com.zhaomsdemo.research.schooling.controller;

import com.zhaomsdemo.research.schooling.dto.SchoolDto;
import com.zhaomsdemo.research.schooling.service.SchoolService;
import com.zhaomsdemo.research.schooling.vo.Result;
import com.zhaomsdemo.research.schooling.vo.SchoolVo;
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
    public Result<SchoolVo> findSchoolById(@PathVariable String id) {
        SchoolVo school = schoolService.findSchoolById(id);
        return Result.success(school, 1);
    }

    @GetMapping("/all")
    public Result<List<SchoolVo>> findAllSchools(@RequestParam(required = false, defaultValue = "0") Integer page,
                                               @RequestParam(required = false, defaultValue = "10") Integer size) {
        List<SchoolVo> schools = schoolService.findAllSchools(PageRequest.of(page, size));
        return Result.success(schools, schools.size());
    }

    @PostMapping("")
    public Result<SchoolVo> registerSchool(@RequestBody SchoolDto schoolDto) {
        SchoolVo school = schoolService.registerNewSchool(schoolDto);
        return Result.success(school, 1);
    }

    @PostMapping("/{schoolId}/approvers")
    public Result<SchoolVo> addApprover(@PathVariable String schoolId, @RequestBody List<String> administratorIds) {
        SchoolVo school = schoolService.addApprover(schoolId, administratorIds);
        return Result.success(school, 1);
    }
}
