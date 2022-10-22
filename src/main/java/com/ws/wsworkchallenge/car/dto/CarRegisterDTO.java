package com.ws.wsworkchallenge.car.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarRegisterDTO {

    @NotNull
    private Long modelId;

    @NotNull
    private Integer year;

    @NotNull
    @NotBlank
    private String fuel;

    @NotNull
    private Byte numberDoors;

    @NotNull
    @NotBlank
    private String color;
}
