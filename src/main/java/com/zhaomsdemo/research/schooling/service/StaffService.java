package com.zhaomsdemo.research.schooling.service;

import com.zhaomsdemo.research.schooling.dto.StaffDto;
import com.zhaomsdemo.research.schooling.vo.StaffVo;

import java.util.List;

public interface StaffService {

    StaffVo findById(String id);
    List<StaffVo> findByParamAndValue(String param, String value);
    StaffVo create(StaffDto staffDto);
    StaffVo update(String id, StaffDto staffDto);
    StaffVo delete(String id);
}
