package com.zhaomsdemo.research.schooling.repository;

import com.zhaomsdemo.research.schooling.domain.Administrator;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdministratorRepository extends MongoRepository<Administrator, String> {

    Page<Administrator> findAll(Pageable pageable);
}
