package com.ws.wsworkchallenge.car.controller;

import com.ws.wsworkchallenge.car.dto.CarEditDTO;
import com.ws.wsworkchallenge.car.dto.CarRegisterDTO;
import com.ws.wsworkchallenge.car.service.CarService;
import com.ws.wsworkchallenge.car.vo.CarGetVO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/car")
@RequiredArgsConstructor
public class CarController {

    private final CarService service;

    @PostMapping
    public ResponseEntity<CarGetVO> register(@RequestBody @Valid CarRegisterDTO car) {
        CarGetVO newCar = service.create(car);
        return new ResponseEntity<>(newCar, HttpStatus.CREATED);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<CarGetVO> getCar(@PathVariable Long id) {
        CarGetVO car = service.findById(id);
        return new ResponseEntity<>(car, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<CarGetVO>> findAllCars() {
        List<CarGetVO> car = service.findAll();
        return new ResponseEntity<>(car, HttpStatus.OK);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<CarGetVO> updateCar(@RequestBody CarEditDTO car,
                                             @PathVariable Long id) {
        CarGetVO newCar = service.update(car, id);
        return new ResponseEntity<>(newCar, HttpStatus.OK);
    }

}
