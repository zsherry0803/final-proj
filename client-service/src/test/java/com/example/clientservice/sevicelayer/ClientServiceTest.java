package com.example.clientservice.sevicelayer;

import com.example.clientservice.model.Person;
import com.example.clientservice.util.fiegn.PersonService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class ClientServiceTest {


    ClientService service;

    PersonService personService;

    @Before
    public void setUp() throws Exception {
        clientServiceSetup();
        service = new ClientService(personService);
    }

    @Test
    public void createPerson() {
        Person person = new Person();
        person.setAge(25);
        person.setName("Mike");

        person = service.createPerson(person);

        List<Person> personList = service.findPerson(person.getName());

        assertEquals(personList.size(), 1);
        assertEquals(person, personList.get(0));
    }

    private void clientServiceSetup(){
        personService = mock(PersonService.class);

        Person personMock = new Person();
        personMock.setAge(25);
        personMock.setId(15);
        personMock.setName("Mike");

        Person person = new Person();
        person.setAge(25);
        person.setName("Mike");

        List<Person> personList = new ArrayList<>();
        personList.add(personMock);

        doReturn(personMock).when(personService).createPerson(person);
        doReturn(personList).when(personService).findByName(personMock.getName());
    }
}