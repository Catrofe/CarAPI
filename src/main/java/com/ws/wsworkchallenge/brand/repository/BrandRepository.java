package com.ws.wsworkchallenge.brand.repository;

import com.ws.wsworkchallenge.brand.entity.Marca;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BrandRepository extends JpaRepository<Marca, Long> {

    @Query(value = "select exists (select * from model as md left join marca as mr on md.marca_id = mr.id where mr.id = :id)",
            nativeQuery = true)
    Boolean existsByModel(Long id);

    @Query(value = "delete from marca as mr where mr.id = :id", nativeQuery = true)
    Optional<Marca> deleteRefactoring(Long id);
}

