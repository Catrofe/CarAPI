package com.ws.wsworkchallenge.car.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class IdsForDeleteCar {
    private List<Long> ids;
}
