package com.ws.wsworkchallenge.model.services;

import com.ws.wsworkchallenge.brand.entity.Brand;
import com.ws.wsworkchallenge.brand.service.BrandService;
import com.ws.wsworkchallenge.car.service.CarService;
import com.ws.wsworkchallenge.model.dto.CreateModelDTO;
import com.ws.wsworkchallenge.model.dto.EditModelDTO;
import com.ws.wsworkchallenge.model.entity.Model;
import com.ws.wsworkchallenge.model.repository.ModelRepository;
import com.ws.wsworkchallenge.utils.exceptions.GenericException;
import com.ws.wsworkchallenge.utils.exceptions.ImpossibleDelete;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Component
@Service
public class ModelService {

    private final ModelRepository repository;
    private BrandService brandService;
    private CarService carService;

    @Autowired
    public void BrandServiceCreate(@Lazy BrandService brandService) {
        this.brandService = brandService;
    }

    @Autowired
    public void CarServiceCreate(@Lazy CarService carService) {
        this.carService = carService;
    }

    public Model create(CreateModelDTO model) {
        Brand marca = brandService.findById(model.getIdMarca());
        Model newModel = new Model();
        newModel.setName(model.getName());
        newModel.setValorFipe(model.getValorFipe());
        newModel.setMarca(marca);
        return repository.save(newModel);
    }

    public Model findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new GenericException(String.format("Model with id %d not found", id)));
    }

    public List<Model> findAll() {
        return repository.findAll();
    }

    public Model update(EditModelDTO model, Long id) {
        Model newModel = findById(id);
        if (model.getName() != null) {
            newModel.setName(model.getName());
        }
        if (model.getValorFipe() != null) {
            newModel.setValorFipe(model.getValorFipe());
        }
        if (model.getIdMarca() != null) {
            Brand marca = brandService.findById(model.getIdMarca());
            newModel.setMarca(marca);
        }
        return repository.save(newModel);
    }

    public void delete(Long id) {
        Model model = findById(id);
        try {
            repository.delete(model);
        } catch(Exception e) {
            throw new ImpossibleDelete(String.format("Impossible to delete model with id %d. Please delete first car's associated with model.", id));
        }
    }

    public List<String> deleteByList(List<Long> ids) {
        List<String> error = new ArrayList<>();
        for (Long id : ids) {
            Boolean exists = carService.existsByModel(findById(id));
            if (exists) {
                error.add(String.format("Impossible to delete model with id %d. Please delete first car's associated with model.", id));
            } else {
                repository.deleteById(id);
            }
        }
        return error;
    }

    public Boolean existsByBrand(Brand brand) {
        return repository.existsByMarca(brand);
    }
}
