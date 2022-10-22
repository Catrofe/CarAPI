package com.ws.wsworkchallenge.model.repository;


import com.ws.wsworkchallenge.brand.entity.Brand;
import com.ws.wsworkchallenge.model.entity.Model;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModelRepository extends JpaRepository<Model, Long> {
    Boolean existsByMarca(Brand brand);
}

