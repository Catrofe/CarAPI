package com.ws.wsworkchallenge.brand.repository;

import com.ws.wsworkchallenge.brand.entity.Marca;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BrandRepository extends JpaRepository<Marca, Long> {

}

