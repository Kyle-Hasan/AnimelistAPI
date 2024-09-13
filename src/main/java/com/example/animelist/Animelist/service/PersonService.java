package com.example.animelist.Animelist.service;

import com.example.animelist.Animelist.entity.Person;
import com.example.animelist.Animelist.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService {
    private PersonRepository personRepository;
    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }
    public Person save(Person person) {
       return this.personRepository.save(person);
    }
    public void delete(String id) {
        this.personRepository.deleteById(id);
    }
    public Person getById(String id) {
        Optional<Person> query = this.personRepository.findById(id);
        return query.orElse(null);
    }

    public List<Person> getById(List<String> id) {
        return this.personRepository.findAll(id);
    }
}
