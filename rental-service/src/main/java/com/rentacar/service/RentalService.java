package com.rentacar.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.rentacar.entity.Rental;
import com.rentacar.repository.RentalRepository;

@Service
public class RentalService {

    private final RentalRepository rentalRepository;

    public RentalService(RentalRepository rentalRepository){
        this.rentalRepository = rentalRepository;
    }

    public Rental createRental(Rental rental) {
        int days = rental.getDays();
        Double price = rental.getPrice();
        rental.setPrice(days * price);
        return rentalRepository.save(rental);
    }

    public List<Rental> getAllRentals() {
        return rentalRepository.findAll();
    }

    public Rental getRentalById(Long id) {
        return rentalRepository.findById(id).orElse(null);
    }

    public Rental updateRental(Long id, Rental rental) {
        Rental existingRental = getRentalById(id);
        existingRental.setUser(rental.getUser());
        existingRental.setCar(rental.getCar());
        existingRental.setDays(rental.getDays());
        existingRental.setPrice(rental.getPrice());
        existingRental.setTotal(rental.getTotal());
        return rentalRepository.save(existingRental);
    }

    public void deleteRental(Long id) {
        rentalRepository.deleteById(id);
    }
}
