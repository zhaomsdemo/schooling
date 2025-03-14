package com.zhaomsdemo.research.schooling.dto;

import com.zhaomsdemo.research.schooling.enumeration.StaffType;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.springframework.validation.annotation.Validated;

@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@Validated
public class StaffDto {

    @NotNull
    String fullName;
    @NotNull
    String email;
    String phone;
    StaffType type;
    @NotNull
    String schoolId;
}
