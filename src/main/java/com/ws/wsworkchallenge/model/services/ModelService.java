package com.ws.wsworkchallenge.model.services;

import com.ws.wsworkchallenge.brand.entity.Marca;
import com.ws.wsworkchallenge.brand.service.BrandService;
import com.ws.wsworkchallenge.model.dto.CreateModelDTO;
import com.ws.wsworkchallenge.model.dto.EditModelDTO;
import com.ws.wsworkchallenge.model.entity.Model;
import com.ws.wsworkchallenge.model.repository.ModelRepository;
import com.ws.wsworkchallenge.utils.exceptions.GenericException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Component
@Service
public class ModelService {

    private final ModelRepository repository;
    private BrandService brandService;

    @Autowired
    public void BrandServiceCreate(@Lazy BrandService brandService) {
        this.brandService = brandService;
    }

    public Model create(CreateModelDTO model) {
        Marca marca = brandService.getBrand(model.getIdMarca());
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
            Marca marca = brandService.getBrand(model.getIdMarca());
            newModel.setMarca(marca);
        }
        return repository.save(newModel);
    }

    public void delete(Long id) {
        Model model = findById(id);
        repository.delete(model);
    }

    public Boolean existsByBrand(Marca marca) {
        return repository.existsByMarca(marca);
    }
}
