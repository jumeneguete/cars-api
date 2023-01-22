package com.cars.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.cars.api.dto.CarDTO;
import com.cars.api.model.Car;
import com.cars.api.repository.CarRepository;

import jakarta.validation.Valid;

@Service
public class CarsService {

    @Autowired
    private CarRepository repository;

    @GetMapping
    public List<Car> getCars() {
        return repository.findAll();
    }

    @PostMapping
    public void createCar(CarDTO req) {
        repository.save(new Car(req));
    }

    @PutMapping("/{id")
    public void updateCarById(Long id, CarDTO req){
        repository.findById(id).map(car -> {
            car.setModelo(req.modelo());
            car.setFabricante(req.fabricante());
            car.setDataFabricacao(req.dataFabricacao());
            car.setAnoModelo(req.anoModelo());
            car.setValor(req.valor());

            return repository.save(car);
        });
    }

    @DeleteMapping("/{id}")
    public void deleteCarById(Long id) {
        repository.deleteById(id);
    }
    
}
