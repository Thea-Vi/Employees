package com.villanueva.peopledb.services;

import com.villanueva.peopledb.business.model.Person;
import com.villanueva.peopledb.repositories.FileStorageRepository;
import com.villanueva.peopledb.repositories.PersonRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.InputStream;
import java.util.Optional;

@Service
public class PersonService {
    private final PersonRepository personRepository;
    private final FileStorageRepository fileStorageRepository;

    public PersonService(PersonRepository personRepository, FileStorageRepository fileStorageRepository) {
        this.personRepository = personRepository;
        this.fileStorageRepository = fileStorageRepository;
    }

//    DELEGATE METHODS GENERATED
    @Transactional // starts a transaction on this method -- safeguard in case one throws an exception
    public Person save(Person person, InputStream photo) {
        Person save = personRepository.save(person);
        fileStorageRepository.save(person.getPhotoFilename(), photo);
        return save;
    }

    public Optional<Person> findById(Long aLong) {
        return personRepository.findById(aLong);
    }

    public Iterable<Person> findAll() {
        return personRepository.findAll();
    }

//    PAGEABLE
    public Page<Person> findAll(Pageable pageable) {
        return personRepository.findAll(pageable);
    }

    public void deleteAllById(Iterable<? extends Long> longs) {
        personRepository.deleteAllById(longs);
    }
}
