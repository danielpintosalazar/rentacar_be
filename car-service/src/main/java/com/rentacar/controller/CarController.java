package com.rentacar.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rentacar.entity.Car;
import com.rentacar.service.CarService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
@RequestMapping("/api/cars")
public class CarController {

    @Autowired
    private CarService carService;

    @GetMapping("/{id}")
    public ResponseEntity<?> findCarById(@PathVariable Long id) {    
        try {
            Car car = carService.getCarById(id);
            if (car != null) {
                return new ResponseEntity<>(car, HttpStatus.OK); 
            }
            return new ResponseEntity<>("Elemento no encontrado",HttpStatus.NOT_FOUND);
            
        } catch (Exception e) {
            return new ResponseEntity<>("Error: " + e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);           
        }
    }

    @GetMapping("/findByName/{name}")
    public ResponseEntity<?> findByName(@PathVariable String name) {
        try {
            List<Car> cars = carService.getCarByName(name);
            if (cars != null && !cars.isEmpty()) {
                return new ResponseEntity<>(cars, HttpStatus.OK);
            }
            return new ResponseEntity<>("Elemento no encontrado",HttpStatus.NOT_FOUND);        
            
        } catch (Exception e) {
            return new ResponseEntity<>("Error: " + e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);           
        }
    }

    @GetMapping("/findByNameContainig/{name}")
    public ResponseEntity<?> findByNameContaining(@PathVariable String name) {
        try {
            List<Car> cars = carService.getCarByNameContaining(name);
            if (cars != null && !cars.isEmpty()) {
                return new ResponseEntity<>(cars, HttpStatus.OK);
            }
            return new ResponseEntity<>("Elemento no encontrado",HttpStatus.NOT_FOUND);        
            
        } catch (Exception e) {
            return new ResponseEntity<>("Error: " + e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);           
        }
    }

    @GetMapping
    public ResponseEntity<?> findAllCars() {
        try {
            List<Car> cars = carService.getAllCars();
            if (cars != null && !cars.isEmpty()) {
                return new ResponseEntity<>(cars, HttpStatus.OK);
            }
            return new ResponseEntity<>("Elemento no encontrado",HttpStatus.NOT_FOUND); 
            
        } catch (Exception e) {
            return new ResponseEntity<>("Error: " + e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);           
        }
    }
    
    @PostMapping
    public ResponseEntity<?> createCar(@RequestBody Car car) {
        try {
            Car newCar = carService.addCar(car);
            return new ResponseEntity<>(newCar, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Error: " + e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);   
        }   
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<?> updateCar(@PathVariable Long id, @RequestBody Car car) {
        try {
            Car updateCar = carService.updateCar(id, car);
            if (updateCar != null) {
                return new ResponseEntity<>(updateCar, HttpStatus.OK);
                
            }
            return new ResponseEntity<>("Elemento no encontrado. No es posible actualizar",HttpStatus.NOT_FOUND); 
        } catch (Exception e) {
            return new ResponseEntity<>("Error: " + e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);  
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCar(@PathVariable Long id){
        try {
            boolean resp = carService.deleteCar(id);
            if (resp) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            } else {
                return new ResponseEntity<>("Elemento no encontrado. No es posible eliminar",HttpStatus.NOT_FOUND);
            }


        } catch (Exception e) {
            return new ResponseEntity<>("Error: " + e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);  
        }
        
    }

}
