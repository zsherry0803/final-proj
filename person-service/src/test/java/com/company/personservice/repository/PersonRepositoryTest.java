package com.company.personservice.repository;
import com.company.personservice.model.Person;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.List;
import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class PersonRepositoryTest {

    @Autowired
    PersonRepository personRepository;
    @Before
    public void setUp() throws Exception {
    }
    @Test
    public void addPersonAndFindByName() {
        personRepository.deleteAll();
        Person person = new Person();
        person.setAge(21);
        person.setName("sherry");
        person = personRepository.save(person);
        Person person1 = personRepository.findById(person.getId()).get();
        assertEquals(person,person1);
        Person person2 = new Person();
        person2.setName("Ofe");
        person2.setAge(21);
        personRepository.save(person2);
        List<Person> list = personRepository.findByName(person.getName());
        assertEquals(1, list.size());
    }
}