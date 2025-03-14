package com.zhaomsdemo.research.schooling.repository;

import com.zhaomsdemo.research.schooling.domain.Staff;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StaffRepository extends MongoRepository<Staff, String> {

    @Query(value = "{'?0':{'$regex':'?1','$options':'i'}}")
    List<Staff> findByNameAndValue(String name, String value);
}
