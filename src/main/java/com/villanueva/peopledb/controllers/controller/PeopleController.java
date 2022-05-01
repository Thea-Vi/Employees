package com.villanueva.peopledb.controllers.controller;

import com.villanueva.peopledb.business.model.Person;
import com.villanueva.peopledb.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/people")
public class PeopleController {

    private PersonRepository personRepository;

//    create constructor instead of @autowired --SC com return
    public PeopleController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @ModelAttribute("people")
    public Iterable<Person> getPeople(){
        return personRepository.findAll();
    }

    @ModelAttribute
    public Person getPerson() {
        return new Person();
    }

    // SHOW
    @GetMapping
    public String displayPeople(){
        return "people";
    }

    // POST
    @PostMapping
    public String savePerson(@Valid Person person, Errors errors) {
        System.out.println(person);
//        error check
        if (!errors.hasErrors()) {
            personRepository.save(person);
            return "redirect:people";
        }
        return "people";
    }

    // DELETE
    @PostMapping(params = "delete=true")
    public String deletePerson(@RequestParam Optional<List<Long>> options) {
        System.out.println(options);
        if (options.isPresent()) {
            personRepository.deleteAllById(options.get());
        }
        return "redirect:people";
    }
}

