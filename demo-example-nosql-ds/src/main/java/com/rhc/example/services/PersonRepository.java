package com.rhc.example.services;

import com.rhc.example.services.common.model.Person;
import org.springframework.data.domain.*;
import org.springframework.data.repository.*;

public interface PersonRepository extends Repository<Person, Long> {

    Page<Person> findAll(Pageable pageable);

    Person findByName(String name);

}
