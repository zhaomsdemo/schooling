package com.zhaomsdemo.research.schooling.repository;

import com.zhaomsdemo.research.schooling.domain.Staff;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StaffRepository extends MongoRepository<Staff, String> {
}
