package com.zhaomsdemo.research.schooling.controller;

import com.zhaomsdemo.research.schooling.service.StaffService;
import com.zhaomsdemo.research.schooling.vo.Result;
import com.zhaomsdemo.research.schooling.vo.StaffVo;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/staff")
@RequiredArgsConstructor
public class StaffController {

    private final StaffService staffService;

    @GetMapping("/{id}")
    public Result<StaffVo> findById(@PathVariable String id) {

    }
}
