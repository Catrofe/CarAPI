package com.ws.wsworkchallenge.brand.service;

import com.ws.wsworkchallenge.brand.dto.RegisterBrand;
import com.ws.wsworkchallenge.brand.entity.Brand;
import com.ws.wsworkchallenge.brand.repository.BrandRepository;
import com.ws.wsworkchallenge.utils.exceptions.GenericException;
import com.ws.wsworkchallenge.utils.exceptions.ImpossibleDelete;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BrandService {

    private final BrandRepository repository;

    public Brand insert(RegisterBrand brand) {
        Brand newBrand = new Brand();
        newBrand.setNameBrand(brand.getNameBrand());
        return repository.save(newBrand);
    }

    public Brand findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new GenericException(String.format("Brand with id %d not found", id)));
    }

    public List<Brand> getAllBrands() {
        return repository.findAll();
    }

    public Brand update(RegisterBrand marca, Long id) {
        Brand brand = findById(id);
        brand.setNameBrand(marca.getNameBrand());
        return repository.save(brand);
    }

    public void delete(Long id) {
        Brand brand = findById(id);
        try {
            repository.delete(brand);
        } catch (Exception e) {
            throw new ImpossibleDelete(String.format("Brand with id %d can't be deleted", id));
        }
    }

}