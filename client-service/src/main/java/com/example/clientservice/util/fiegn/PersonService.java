package com.example.clientservice.util.fiegn;

import com.example.clientservice.model.Person;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(name = "person-service")
public interface PersonService {

    @RequestMapping(value = "/person/{name}", method = RequestMethod.GET)
    public List<Person> findByName(String name);

    @RequestMapping(value = "/person/addperson", method = RequestMethod.POST)
    public Person createPerson(@RequestBody Person person);

}
