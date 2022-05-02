package com.villanueva.peopledb.repositories;

import com.villanueva.peopledb.business.model.Person;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
//change from Crud to Paging and sorting since crud is connected
public interface PersonRepository extends PagingAndSortingRepository<Person, Long> {

}
