package com.rentacar.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

    @GetMapping("/find/{id}")
    public Car findCarById(@PathVariable Long id) {
        return carService.getCarById(id);
    }

    @GetMapping("/findAll")
    public List<Car> findAllCars() {
        return carService.getAllCars();
    }
    
    @PostMapping("/add")
    public Car createCar(@RequestBody Car car) {
        return carService.addCar(car);
    }
    
    @PutMapping("/update/{id}")
    public Car updateCar(@PathVariable Long id, @RequestBody Car car) {
        return carService.updateCar(id, car);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteCar(@PathVariable Long id){
        carService.deleteCar(id);
    }

}
