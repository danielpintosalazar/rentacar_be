package com.rentacar.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rentacar.entity.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
    
    List<Person> findByName(String nameString);
    
}
