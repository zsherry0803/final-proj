package com.example.clientservice.sevicelayer;

import com.example.clientservice.model.Person;
import com.example.clientservice.util.fiegn.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ClientService {

    @Autowired
    private final PersonService service;

    public ClientService(PersonService service) {
        this.service = service;
    }

    public Person createPerson(Person person){

        return service.createPerson(person);
    }

    public List<Person> findPerson(String name){
        return service.findByName(name);
    }
}
