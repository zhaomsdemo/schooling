package com.zhaomsdemo.research.schooling.domain;

import com.zhaomsdemo.research.schooling.enumeration.SchoolStatus;
import com.zhaomsdemo.research.schooling.enumeration.SchoolType;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.time.Instant;
import java.util.List;

@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@Document(collection = "school")
public class School {

    @MongoId
    String id;
    String schoolName;
    String schoolCode;
    String address;
    SchoolType schoolType;
    SchoolStatus status;
    String description;
    @DBRef(lazy = true)
    List<Staff> staffs;
    @DBRef(lazy = true)
    List<Administrator> approvers;
    @DBRef(lazy = true)
    List<Student> students;

    @CreatedDate
    Instant createdOn;
    @CreatedBy
    String createdBy;
    @LastModifiedDate
    Instant updatedOn;
    @LastModifiedBy
    String updatedBy;
}
