package com.rentacar.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rentacar.entity.Car;

@Repository
public interface CarRepository extends JpaRepository<Car, Long>{
    
    List<Car> findByNameContaining(String name);
    
}
