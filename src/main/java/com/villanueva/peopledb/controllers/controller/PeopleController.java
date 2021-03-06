package com.villanueva.peopledb.controllers.controller;

import com.villanueva.peopledb.business.model.Person;
import com.villanueva.peopledb.repositories.FileStorageRepository;
import com.villanueva.peopledb.repositories.PersonRepository;
import com.villanueva.peopledb.services.PersonService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/people")
@Log4j2 //enables logging - can be turned on and off - better than system.out.println
public class PeopleController {

    private final PersonRepository personRepository;
    private final FileStorageRepository fileStorageRepository;
    private final PersonService personService;

//    create constructor instead of @autowired --SC com return
    public PeopleController(PersonRepository personRepository, FileStorageRepository fileStorageRepository, PersonService personService) {
        this.personRepository = personRepository;
        this.fileStorageRepository = fileStorageRepository;
        this.personService = personService;
    }

    @ModelAttribute("people")
    public Page<Person> getPeople(@PageableDefault(size = 3) Pageable page) {
        return personService.findAll(page);
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
    @PostMapping                                                    //required for uploading file
    public String savePerson(@Valid Person person, Errors errors, @RequestParam MultipartFile photoFilename) throws IOException {
        log.info(person);
        log.info(photoFilename.getOriginalFilename());
        log.info("Errors" + errors);
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
        log.info(options);
        if (options.isPresent()) {
//            personRepository.deleteAllById(options.get());
            personRepository.deleteAllById(options.get());
        }
        return "redirect:people";
    }

    // EDIT
    @PostMapping(params = "edit=true")
    public String editPerson(@RequestParam Optional<List<Long>> options, Model model) {
        log.info(options);
        if (options.isPresent()) {
            Optional<Person> person = personRepository.findById(options.get().get(0));
            model.addAttribute("person", person);
        }
        return "people";
    }
}

