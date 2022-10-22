package com.ws.wsworkchallenge.car.service;

import com.ws.wsworkchallenge.car.dto.CarEditDTO;
import com.ws.wsworkchallenge.car.dto.CarRegisterDTO;
import com.ws.wsworkchallenge.car.entity.Car;
import com.ws.wsworkchallenge.car.repository.CarRepository;
import com.ws.wsworkchallenge.car.vo.CarGetVO;
import com.ws.wsworkchallenge.model.entity.Model;
import com.ws.wsworkchallenge.model.services.ModelService;
import com.ws.wsworkchallenge.utils.exceptions.ConflictException;
import com.ws.wsworkchallenge.utils.exceptions.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CarService {

    private final CarRepository repository;
    private final ModelService modelService;

    public CarGetVO returnVO(Car car) {
        return new CarGetVO(car.getId(),
                car.getModel().getBrand().getId(),
                car.getModel().getBrand().getNameBrand(),
                car.getModel().getName(),
                car.getYear(),
                car.getFuel(),
                car.getNumberDoors(),
                car.getModel().getValueFipe(),
                car.getColor(),
                car.getTimestampRegistration());
    }

    public CarGetVO inset(CarRegisterDTO car) {
        Car newCar = new Car();
        Calendar.getInstance().getTimeInMillis();
        Model model = modelService.findByIdRaw(car.getModelId());
        newCar.setModel(model);
        newCar.setYear(car.getYear());
        newCar.setFuel(car.getFuel());
        newCar.setNumberDoors(car.getNumberDoors());
        newCar.setColor(car.getColor());
        newCar.setTimestampRegistration(Calendar.getInstance().getTimeInMillis());
        newCar = repository.save(newCar);
        return returnVO(newCar);
    }

    public CarGetVO findById(Long id) {
        Car car = repository.findById(id).orElseThrow(() -> new NotFoundException(String.format("Car with id %d not found", id)));
        return returnVO(car);
    }

    public Car findByIdRaw(Long id) {
        return repository.findById(id).orElseThrow(() -> new NotFoundException(String.format("Car with id %d not found", id)));
    }

    public List<CarGetVO> findAll() {
        List<Car> cars = repository.findAll();
        return cars.stream().map(this::returnVO).collect(Collectors.toList());
    }

    public CarGetVO update(CarEditDTO car, Long id) {
        Car newCar = repository.findById(id).orElseThrow(() -> new NotFoundException(String.format("Car with id %d not found", id)));
        if (car.getModelId() != null) {
            Model model = modelService.findByIdRaw(car.getModelId());
            newCar.setModel(model);
        }
        if (car.getYear() != null) {
            newCar.setYear(car.getYear());
        }
        if (car.getFuel() != null) {
            newCar.setFuel(car.getFuel());
        }
        if (car.getNumberDoors() != null) {
            newCar.setNumberDoors(car.getNumberDoors());
        }
        if (car.getColor() != null) {
            newCar.setColor(car.getColor());
        }
        newCar = repository.save(newCar);
        return returnVO(newCar);
    }

    public void delete(Long id) {
        Car car = findByIdRaw(id);
        try {
            repository.delete(car);
        } catch (Exception e) {
            throw new ConflictException(String.format("Car with id %d can't be deleted", id));
        }
    }
}
