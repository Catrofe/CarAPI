package com.ws.wsworkchallenge.car.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarEditDTO implements CarEdit {
    private String cor;
    private Long modeloId;
    private Integer ano;
    private String combustivel;
    private Byte numPortas;
}
