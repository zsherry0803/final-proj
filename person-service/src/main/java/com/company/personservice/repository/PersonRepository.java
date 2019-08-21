package com.company.personservice.repository;

import com.company.personservice.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PersonRepository extends JpaRepository<Person, Integer> {
    List<Person> findByName(String Name);
}
