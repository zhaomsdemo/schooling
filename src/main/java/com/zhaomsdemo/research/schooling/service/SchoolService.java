package com.zhaomsdemo.research.schooling.service;

import com.zhaomsdemo.research.schooling.dto.SchoolDto;
import com.zhaomsdemo.research.schooling.vo.SchoolVo;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface SchoolService {

    SchoolVo registerNewSchool(SchoolDto schoolDto);
    SchoolVo update(String id, SchoolDto schoolDto);
    SchoolVo unregisterSchool(String id);
    SchoolVo findSchoolById(String id);
    SchoolVo findSchoolByName(String schoolName);
    List<SchoolVo> findAllSchools(Pageable pageable);
    SchoolVo addApprover(String schoolId, List<String> administratorIds);
}
