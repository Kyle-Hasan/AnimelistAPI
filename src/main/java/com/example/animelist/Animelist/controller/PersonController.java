package com.example.animelist.Animelist.controller;

import com.example.animelist.Animelist.entity.Person;
import com.example.animelist.Animelist.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/api/people")
public class PersonController {

    private PersonService personService;
    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/{id}")
    public Person getVoiceActorById(@PathVariable String id) {
        Person person = personService.getById(id);
        return person;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        personService.delete(id);
    }

    @PostMapping("")
    public Person create(@RequestBody Person person) {
        return personService.save(person);
    }

    @PatchMapping("")
    public Person update(@RequestBody Person person) {
        return personService.save(person);
    }

    @GetMapping
    public List<Person> getList(@RequestBody List<String> ids) {
        return personService.getById(ids);
    }






}