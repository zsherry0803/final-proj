package com.company.personservice.controller;

import com.company.personservice.model.Person;
import com.company.personservice.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PersonController {
    PersonRepository personRepository;

    @Autowired
    public PersonController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @RequestMapping(value = "/person/{name}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<Person> findByName(@PathVariable String name) {
        List<Person> list = personRepository.findByName(name);
        return list;
    }

    @RequestMapping(value = "/person/addperson", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public Person createPerson(@RequestBody Person person) {
        person = personRepository.save(person);
        return person;
    }
}
