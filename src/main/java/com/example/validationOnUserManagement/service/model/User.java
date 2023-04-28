package com.example.validationOnUserManagement.service.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.UniqueElements;

import java.sql.Time;
import java.util.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @NotEmpty
    @Pattern(regexp = "[0-9]+")
    private String userId;
    @NotEmpty
    private String name;
    @Size(min = 10, max = 12)
    @Pattern(regexp = "[0-9]+")
    private String number;
    @Email
    private String email;
    @NotNull
    private Date dateOfBirth;
    @NotNull
    private Date dateAndTime;
    @NotNull
    private Time time;
}
