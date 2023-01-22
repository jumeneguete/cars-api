package com.cars.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cars.api.dto.CarDTO;
import com.cars.api.model.Car;
import com.cars.api.service.CarsService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/cars")
public class CarsController {

    @Autowired
    private CarsService service;

    // Aula 1 - Semana 2 - Exercicio 2
    // @PostMapping
    // public void createCar(@RequestBody CarDTO req) {
    //     System.out.println(req);
    //     System.out.println(req.modelo());
    //     System.out.println(req.dataFabricacao());
    //     System.out.println(req.fabricante());
    // }

    @GetMapping
    public List<Car> getCars() {
        return service.getCars();
    }

    @PostMapping
    public void createCar(@RequestBody @Valid CarDTO req) {
        service.createCar(req);
    }

    @PutMapping("/{id}")
    public void updateCarById(@PathVariable Long id, @RequestBody @Valid CarDTO req){
        service.updateCarById(id, req);

    }
    
    @DeleteMapping("/{id}")
    public void deleteCarById(@PathVariable Long id){
        service.deleteCarById(id);
    }
}
