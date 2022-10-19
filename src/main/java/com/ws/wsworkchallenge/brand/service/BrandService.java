package com.ws.wsworkchallenge.brand.service;

import com.ws.wsworkchallenge.brand.dto.RegisterBrand;
import com.ws.wsworkchallenge.brand.entity.Marca;
import com.ws.wsworkchallenge.brand.repository.BrandRepository;
import com.ws.wsworkchallenge.utils.exceptions.ItemNotFound;
import com.ws.wsworkchallenge.utils.exceptions.SQLException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BrandService {

    private final BrandRepository repository;

    public Marca insert(RegisterBrand brand){
        Marca newBrand = new Marca();
        newBrand.setNomeMarca(brand.getNomeMarca());
        return repository.save(newBrand);
    }

    public Marca getBrand(Long id){
        return repository.findById(id).orElseThrow(() -> new ItemNotFound(String.format("Brand with id %d not found", id)));
    }

    public List<Marca> getAllBrands() {
        return repository.findAll();
    }

    public Marca update(RegisterBrand marca, Long id) {
        Marca brand = getBrand(id); // Reutilizando a função para não duplicar código, DRY.
        brand.setNomeMarca(marca.getNomeMarca());
        return repository.save(brand);
    }

    public void delete(Long id) {
            repository.deleteRefactoring(getBrand(id).getId()).orElseThrow(() -> new SQLException("Testing delete"));
    }
}
