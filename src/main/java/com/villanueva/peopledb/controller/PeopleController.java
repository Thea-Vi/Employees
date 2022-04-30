package com.villanueva.peopledb.controller;

import com.villanueva.peopledb.business.model.Person;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/people")
public class PeopleController {

//    create method that returns a String
    @GetMapping
    public String getPeople(Model model){
        List<Person> people = List.of(
                new Person(10l, "Jake", "Smith", LocalDate.of(1950,1,1), new BigDecimal("50000")),
                new Person(20l, "Man", "Doe", LocalDate.of(1953,4,1), new BigDecimal("30000"))
        );
        model.addAttribute("people", people);
        return "people";
    }
}

