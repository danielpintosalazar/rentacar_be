package com.rentacar.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.rentacar.entity.Person;
import com.rentacar.repository.PersonRepository;

@Service
public class PersonService {

    private final PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public Person createPerson(Person person) {
        return personRepository.save(person);
    }

    public List<Person> getAllPersons() {
        return personRepository.findAll();
    }

    public Person getPersonById(Long id) {
        return personRepository.findById(id).orElse(null);
    }

    public Person updatePerson(Long id, Person person) {
        Person existingPerson = getPersonById(id);
        existingPerson.setName(person.getName());
        existingPerson.setAddress(person.getAddress());
        existingPerson.setPhone(person.getPhone());
        return personRepository.save(existingPerson);
    }

    public void deletePerson(Long id) {
        personRepository.deleteById(id);
    }
}
