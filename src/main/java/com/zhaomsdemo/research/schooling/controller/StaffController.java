package com.zhaomsdemo.research.schooling.controller;

import com.zhaomsdemo.research.schooling.dto.StaffDto;
import com.zhaomsdemo.research.schooling.service.StaffService;
import com.zhaomsdemo.research.schooling.vo.Result;
import com.zhaomsdemo.research.schooling.vo.StaffVo;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/staff")
@RequiredArgsConstructor
public class StaffController {

    private final StaffService staffService;

    @GetMapping("/{id}")
    public Result<StaffVo> findById(@PathVariable String id) {
        StaffVo staffVo = staffService.findById(id);
        return Result.success(staffVo, 1);
    }

    @GetMapping("/find/{name}/{value}")
    public Result<List<StaffVo>> findByName(@PathVariable String name,@PathVariable String value) {
        List<StaffVo> staffVos = staffService.findByParamAndValue(name, value);
        return Result.success(staffVos, staffVos.size());
    }

    @PostMapping("")
    public Result<StaffVo> onboard(@RequestBody StaffDto staffDto) {
        StaffVo staffVo = staffService.create(staffDto);
        return Result.success(staffVo, 1);
    }

    @PutMapping("/{id}")
    public Result<StaffVo> update(@PathVariable String id ,@RequestBody StaffDto staffDto) {
        StaffVo staffVo = staffService.update(id, staffDto);
        return Result.success(staffVo, 1);
    }

    @DeleteMapping("")
    public Result<StaffVo> delete(@PathVariable String id) {
        StaffVo staffVo = staffService.delete(id);
        return Result.success(staffVo, 1);
    }
}
