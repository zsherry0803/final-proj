package com.example.clientservice.controller;

import com.example.clientservice.model.Person;
import com.example.clientservice.sevicelayer.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ClientController {

    @Autowired
    ClientService service;

    @RequestMapping(value = "/clientfe/person/{name}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<Person> getPeopleWithName(@PathVariable String name){

        return service.findPerson(name);

    }

    @RequestMapping(value = "/clientfe/addperson", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public Person addPerson(@RequestBody Person person){

        return service.createPerson(person);
    }
}
