package com.villanueva.peopledb.business.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
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
    private String firstName;
    private String lastName;
    private LocalDate dob;
    private String email;
    private BigDecimal salary;




}
