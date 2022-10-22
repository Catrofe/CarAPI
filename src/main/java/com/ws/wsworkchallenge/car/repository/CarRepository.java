package com.ws.wsworkchallenge.car.repository;

import com.ws.wsworkchallenge.car.entity.Car;
import com.ws.wsworkchallenge.model.entity.Model;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {

    Boolean existsByModelo(Model modelo);
}

