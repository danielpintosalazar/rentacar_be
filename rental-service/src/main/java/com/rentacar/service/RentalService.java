package com.rentacar.service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.rentacar.client.CarClient;
import com.rentacar.client.CarDTO;
import com.rentacar.client.PersonClient;
import com.rentacar.client.PersonDTO;
import com.rentacar.entity.Rental;
import com.rentacar.repository.RentalRepository;

@Service
public class RentalService {

    private final RentalRepository rentalRepository;
    private final CarClient carClient;
    private final PersonClient personClient;

    public RentalService(RentalRepository rentalRepository, CarClient carClient, PersonClient personClient){
        this.rentalRepository = rentalRepository;
        this.carClient = carClient;
        this.personClient = personClient;
    }

    public Rental createRental(Rental rental) {
        int days = rental.getDays();
        Double price = rental.getPrice();
        rental.setTotal(days * price);

        CarDTO car = carClient.getCarById(rental.getCar());
        PersonDTO person = personClient.getPersonById(rental.getUser());
        
        if (car == null) {
            throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST, 
                "El ID del carro especificado no es válido"
            );
        }
        if (person == null) {
            throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST, 
                "El ID de la persona especificada no es válido"
            );
        }
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
