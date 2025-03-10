package com.zhaomsdemo.research.schooling.repository;

import com.zhaomsdemo.research.schooling.domain.School;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SchoolRepository extends MongoRepository<School, String> {

    Optional<School> findFirstBySchoolName(String schoolName);
    Page<School> findAll(Pageable pageable);
}
