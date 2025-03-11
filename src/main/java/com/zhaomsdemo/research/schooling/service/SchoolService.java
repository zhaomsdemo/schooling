package com.zhaomsdemo.research.schooling.service;

import com.zhaomsdemo.research.schooling.domain.School;
import com.zhaomsdemo.research.schooling.dto.SchoolDto;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface SchoolService {

    School registerNewSchool(SchoolDto schoolDto);
    School update(String id, SchoolDto schoolDto);
    School unregisterSchool(String id);
    School findSchoolById(String id);
    School findSchoolByName(String schoolName);
    List<School> findAllSchools(Pageable pageable);
    School addApprover(String schoolId, String administratorId);
}
