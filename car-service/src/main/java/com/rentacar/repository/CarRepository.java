package com.rentacar.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rentacar.entity.Car;

public interface CarRepository extends JpaRepository<Car, Long>{

}
