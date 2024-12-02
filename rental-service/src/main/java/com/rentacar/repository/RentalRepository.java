package com.rentacar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rentacar.entity.Rental;

@Repository
public interface RentalRepository extends JpaRepository<Rental, Long> {
    
}
