package com.ws.wsworkchallenge.car.service;

import com.ws.wsworkchallenge.car.dto.CarEditDTO;
import com.ws.wsworkchallenge.car.dto.CarRegisterDTO;
import com.ws.wsworkchallenge.car.entity.Car;
import com.ws.wsworkchallenge.car.repository.CarRepository;
import com.ws.wsworkchallenge.car.vo.CarGetVO;
import com.ws.wsworkchallenge.model.entity.Model;
import com.ws.wsworkchallenge.model.services.ModelService;
import com.ws.wsworkchallenge.utils.exceptions.GenericException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CarService {

    private final CarRepository repository;
    private final ModelService modelService;

    public CarGetVO create(CarRegisterDTO car) {
        Car newCar = new Car();
        Model model = modelService.findById(car.getModeloId());
        newCar.setModelo(model);
        newCar.setAno(car.getAno());
        newCar.setCombustivel(car.getCombustivel());
        newCar.setNum_portas(car.getNumPortas());
        newCar.setCor(car.getCor());
        newCar.setTimestampCadastro(new java.sql.Timestamp(System.currentTimeMillis()));
        newCar = repository.save(newCar);
        return createDTO(newCar);
    }

    public CarGetVO findById(Long id) {
        Car car = repository.findById(id).orElseThrow(() -> new GenericException(String.format("Car with id %d not found", id)));
        return createDTO(car);
    }

    public List<CarGetVO> findAll() {
        List<Car> cars = repository.findAll();
        return cars.stream().map(car -> new CarGetVO(car.getId(),
                                car.getModelo().getMarca().getId(),
                                car.getModelo().getMarca().getNameBrand(),
                                car.getModelo().getName(),
                                car.getAno(),
                                car.getCombustivel(),
                                car.getNum_portas(),
                                car.getModelo().getValorFipe(),
                                car.getCor(),
                                car.getTimestampCadastro())).collect(Collectors.toList());
    }

    public CarGetVO update(CarEditDTO car, Long id) {
        Car newCar = repository.findById(id).orElseThrow(() -> new GenericException(String.format("Car with id %d not found", id)));
        if (car.getModeloId() != null) {
            Model model = modelService.findById(car.getModeloId());
            newCar.setModelo(model);
        }
        if (car.getAno() != null) {
            newCar.setAno(car.getAno());
        }
        if (car.getCombustivel() != null) {
            newCar.setCombustivel(car.getCombustivel());
        }
        if (car.getNumPortas() != null) {
            newCar.setNum_portas(car.getNumPortas());
        }
        if (car.getCor() != null) {
            newCar.setCor(car.getCor());
        }
        newCar = repository.save(newCar);
        return createDTO(newCar);
    }

    public static CarGetVO createDTO(Car car) {
        return new CarGetVO(car.getId(),
                car.getModelo().getMarca().getId(),
                car.getModelo().getMarca().getNameBrand(),
                car.getModelo().getName(),
                car.getAno(),
                car.getCombustivel(),
                car.getNum_portas(),
                car.getModelo().getValorFipe(),
                car.getCor(),
                car.getTimestampCadastro());
    }

    public Boolean existsByModel(Model model) {
        return repository.existsByModelo(model);
    }

    public void delete(Long id) {
        Car car = repository.findById(id).orElseThrow(() -> new GenericException(String.format("Car with id %d not found", id)));
        repository.delete(car);
    }

    public List<String> deleteByList(List<Long> ids) {
        List<String> error = new ArrayList<>();
        for (Long id : ids) {
            try {
                delete(id);
            } catch (Exception e) {
                error.add(String.format("Car with id %d not found", id));
            }
        }
        return error;
    }
}
