package com.ws.wsworkchallenge.car.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarEditDTO implements CarEdit {
    private String color;
    private Long modelId;
    private Integer year;
    private String fuel;
    private Byte numberDoors;
}
