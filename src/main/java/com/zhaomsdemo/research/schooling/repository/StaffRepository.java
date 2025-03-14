package com.zhaomsdemo.research.schooling.repository;

import com.zhaomsdemo.research.schooling.domain.Staff;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StaffRepository extends MongoRepository<Staff, String> {

    List<Staff> findByFullNameContaining(String fullName);
    List<Staff> findByEmailContaining(String email);
}
