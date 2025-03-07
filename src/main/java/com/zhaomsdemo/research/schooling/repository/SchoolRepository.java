package com.zhaomsdemo.research.schooling.repository;

import com.zhaomsdemo.research.schooling.domain.School;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SchoolRepository extends MongoRepository<School, String> {
}
