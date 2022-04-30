package com.villanueva.peopledb.business.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Data //allows the Lombok library to scan the Person class and find the fields to generate getters setters constructors
@AllArgsConstructor // specifies all arguments because @Data gave no arg constructor from Lombok
@NoArgsConstructor
@Entity
public class Person {
    @Id // flags which id to use
    @GeneratedValue
    private Long id;

    @NotEmpty(message="First name is required")
    private String firstName;

    @NotEmpty(message="Last name is required")
    private String lastName;

    @Past(message="Date of birth must be in the past")
    @NotNull(message = "Date of birth must be specified")
    private LocalDate dob;

    @Email(message = "Email must be valid")
    @NotEmpty(message = "Email is required")
    private String email;

    @DecimalMin(value="1000.00", message="Salary must be at least $1000.00")
    @NotNull(message = "Salary is required")
    private BigDecimal salary;




}
