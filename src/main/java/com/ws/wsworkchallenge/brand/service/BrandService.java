package com.ws.wsworkchallenge.brand.service;

import com.ws.wsworkchallenge.brand.dto.RegisterBrand;
import com.ws.wsworkchallenge.brand.entity.Marca;
import com.ws.wsworkchallenge.brand.repository.BrandRepository;
import com.ws.wsworkchallenge.model.services.ModelService;
import com.ws.wsworkchallenge.utils.exceptions.GenericException;
import com.ws.wsworkchallenge.utils.exceptions.ImpossibleDelete;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BrandService {

    private final BrandRepository repository;

    private ModelService modelService;

    @Autowired
    public void ModelServiceCreate(@Lazy ModelService modelService) {
        this.modelService = modelService;
    }

    public Marca insert(RegisterBrand brand){
        Marca newBrand = new Marca();
        newBrand.setNomeMarca(brand.getNomeMarca());
        return repository.save(newBrand);
    }

    public Marca getBrand(Long id){
        return repository.findById(id).orElseThrow(() -> new GenericException(String.format("Brand with id %d not found", id)));
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
        Marca brand = getBrand(id);
        Boolean exists = modelService.existsByBrand(brand);
        if (exists) {
            throw new ImpossibleDelete("Unable to delete a Brand that has Models associated with it. Please delete Models first to ensure data integrity.");
        }
        repository.deleteById(getBrand(id).getId());
    }
}
