package com.villanueva.peopledb.business.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Data //allows the Lombok library to scan the Person class and find the fields to generate getters setters constructors
@AllArgsConstructor // specifies all arguments because @Data gave no arg constructor
public class Person {
    private Long id;
    private String firstName;
    private String lastName;
    private LocalDate dob;
    private BigDecimal salary;




}
