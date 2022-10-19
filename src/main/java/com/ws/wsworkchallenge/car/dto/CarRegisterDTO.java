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
    private Long modeloId;

    @NotNull
    private Integer ano;

    @NotNull
    @NotBlank
    private String combustivel;

    @NotNull
    private Byte numPortas;

    @NotNull
    @NotBlank
    private String cor;
}
