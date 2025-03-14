package com.zhaomsdemo.research.schooling.controller;

import com.zhaomsdemo.research.schooling.dto.SchoolDto;
import com.zhaomsdemo.research.schooling.service.SchoolService;
import com.zhaomsdemo.research.schooling.vo.Result;
import com.zhaomsdemo.research.schooling.vo.SchoolVo;
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
@RequestMapping("/school")
@RequiredArgsConstructor
public class SchoolController {

    private final SchoolService schoolService;

    @GetMapping("/{id}")
    public Result<SchoolVo> findSchoolById(@PathVariable String id) {
        SchoolVo schoolVo = schoolService.findSchoolById(id);
        return Result.success(schoolVo, 1);
    }

    @GetMapping("/all")
    public Result<List<SchoolVo>> findAllSchools(@RequestParam(required = false, defaultValue = "0") Integer page,
                                               @RequestParam(required = false, defaultValue = "10") Integer size) {
        List<SchoolVo> schoolVos = schoolService.findAllSchools(PageRequest.of(page, size));
        return Result.success(schoolVos, schoolVos.size());
    }

    @PostMapping("")
    public Result<SchoolVo> registerSchool(@RequestBody SchoolDto schoolDto) {
        SchoolVo schoolVo = schoolService.registerNewSchool(schoolDto);
        return Result.success(schoolVo, 1);
    }

    @DeleteMapping("/{id}")
    public Result<SchoolVo> unregisterSchool(@PathVariable String id) {
        SchoolVo schoolVo = schoolService.unregisterSchool(id);
        return Result.success(schoolVo, 1);
    }

    @PostMapping("/{id}/approvers")
    public Result<SchoolVo> addApprover(@PathVariable String id, @RequestBody List<String> administratorIds) {
        SchoolVo schoolVo = schoolService.addApprover(id, administratorIds);
        return Result.success(schoolVo, 1);
    }

    @PutMapping("/{id}")
    public Result<SchoolVo> updateSchool(@PathVariable String id ,@RequestBody SchoolDto schoolDto) {
        SchoolVo schoolVo = schoolService.update(id, schoolDto);
        return Result.success(schoolVo, 1);
    }
}
