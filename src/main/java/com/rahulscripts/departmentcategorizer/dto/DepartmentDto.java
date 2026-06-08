package com.rahulscripts.departmentcategorizer.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.rahulscripts.departmentcategorizer.customannotation.RolePattern;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jdk.jfr.BooleanFlag;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentDto {
    private Long id;

    @NotBlank(message = "Post of the department is required")
    private String title;

    @NotNull(message = "isActive cannot be blank")
    private Boolean isActive;

    @NotNull(message = "Created at cannot be blank")
    @PastOrPresent
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate createdAt;

    @NotBlank(message = "Role is missing")
    @RolePattern
    String Role;
}
