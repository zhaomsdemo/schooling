package com.zhaomsdemo.research.schooling.domain;

import com.zhaomsdemo.research.schooling.enumeration.StaffType;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.time.Instant;

@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@Document(collection = "staff")
public class Staff {

    @MongoId
    String id;
    String fullName;
    String email;
    String phone;
    StaffType type;

    @CreatedDate
    Instant createdOn;
    @CreatedBy
    String createdBy;
    @LastModifiedDate
    Instant updatedOn;
    @LastModifiedBy
    String updatedBy;
}
