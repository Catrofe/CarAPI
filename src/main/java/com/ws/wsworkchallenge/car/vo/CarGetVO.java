package com.ws.wsworkchallenge.car.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarGetVO {
    private Long id;
    private Long marca_id;
    private String marca_nome;
    private String nome_modelo;
    private Integer ano;
    private String combustivel;
    private Byte num_portas;
    private Double valor_fipe;
    private String cor;
    private Timestamp timestamp_cadastro;

}
