package com.rentacar.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rentacar.entity.Car;
import com.rentacar.repository.CarRepository;

@Service
public class CarService {

    @Autowired
    private CarRepository carRepository;
    
    public Car getCarById(Long id){
        return carRepository.findById(id).orElse(null);
    }

    public List<Car> getCarByName(String name){
        return carRepository.findByNameContaining(name);
    }

    public List<Car> getAllCars(){
        return carRepository.findAll();
    }

    public Car addCar(Car car){
        return carRepository.save(car);
    }

    public Car updateCar(Long id, Car car){
        Car existCar = carRepository.findById(id).orElse(null);
        if (existCar != null){
            existCar.setName(car.getName());
            existCar.setBrand(car.getBrand());
            existCar.setColor(car.getColor());
            return carRepository.save(existCar);
        }
        return null;
    }

    public boolean deleteCar(Long id){
        Car existCar = carRepository.findById(id).orElse(null);
        if (existCar != null){
            carRepository.deleteById(id);
            return true;
        }
        return false;
    }

}
