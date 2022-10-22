package com.ws.wsworkchallenge.model.services;

import com.ws.wsworkchallenge.brand.entity.Brand;
import com.ws.wsworkchallenge.brand.service.BrandService;
import com.ws.wsworkchallenge.car.service.CarService;
import com.ws.wsworkchallenge.model.dto.CreateModelDTO;
import com.ws.wsworkchallenge.model.dto.EditModelDTO;
import com.ws.wsworkchallenge.model.entity.Model;
import com.ws.wsworkchallenge.model.repository.ModelRepository;
import com.ws.wsworkchallenge.model.vo.ModelVO;
import com.ws.wsworkchallenge.utils.exceptions.NotFoundException;
import com.ws.wsworkchallenge.utils.exceptions.ConflictException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Component
@Service
public class ModelService {

    private final ModelRepository repository;
    private final BrandService brandService;

    public ModelVO returnVO(Model model) {
        ModelVO modelVO = new ModelVO();
        modelVO.setId(model.getId());
        modelVO.setName(model.getName());
        modelVO.setValueFipe(model.getValueFipe());
        modelVO.setIdBrand(model.getBrand().getId());
        modelVO.setNameBrand(model.getBrand().getNameBrand());
        return modelVO;
    }

    public ModelVO insert(CreateModelDTO model) {
        Brand brand = brandService.findById(model.getBrandId());
        Model newModel = new Model();
        newModel.setName(model.getName());
        newModel.setValueFipe(model.getValueFipe());
        newModel.setBrand(brand);
        newModel = repository.save(newModel);
        return returnVO(newModel);
    }

    public ModelVO findById(Long id) {
        Model model = repository.findById(id).orElseThrow(() -> new NotFoundException(String.format("Model with id %d not found", id)));
        return returnVO(model);
    }

    public Model findByIdRaw(Long id) {
        return repository.findById(id).orElseThrow(() -> new NotFoundException(String.format("Model with id %d not found", id)));
    }

    public List<ModelVO> findAll() {
        return repository.findAll().stream().map(this::returnVO).collect(Collectors.toList());
    }

    public ModelVO update(EditModelDTO model, Long id) {
        Model newModel = findByIdRaw(id);
        if (model.getName() != null) {
            newModel.setName(model.getName());
        }
        if (model.getValueFipe() != null) {
            newModel.setValueFipe(model.getValueFipe());
        }
        if (model.getBrandId() != null) {
            Brand marca = brandService.findById(model.getBrandId());
            newModel.setBrand(marca);
        }
        return returnVO(repository.save(newModel));
    }

    public void delete(Long id) {
        Model model = findByIdRaw(id);
        try {
            repository.delete(model);
        } catch(Exception e) {
            throw new ConflictException(String.format("Impossible to delete model with id %d. Please delete first car's associated with model.", id));
        }
    }

}
