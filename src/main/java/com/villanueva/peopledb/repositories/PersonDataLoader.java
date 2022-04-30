package com.villanueva.peopledb.repositories;

import com.villanueva.peopledb.business.model.Person;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Component
public class PersonDataLoader implements ApplicationRunner {
    private PersonRepository personRepository;

    //
    public PersonDataLoader(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        if (personRepository.count() == 0) {
            List<Person> people = List.of(
                    new Person(null, "John", "Smith", LocalDate.of(1950, 1, 1),"abc@test.com", new BigDecimal("50000")),
                    new Person(null, "Jen", "Man", LocalDate.of(1953, 4, 1), "abc@test.com", new BigDecimal("30000")),
                    new Person(null, "Lab", "Doe", LocalDate.of(1953, 4, 1), "abc@test.com", new BigDecimal("30000"))
            );
            personRepository.saveAll(people);
        }


    }
}
