package com.ws.wsworkchallenge.car.entity;

import com.ws.wsworkchallenge.model.entity.Model;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Timestamp timestampCadastro;

    @ManyToOne
    @JoinColumn(name = "modelo_id")
    private Model modelo;
    private Integer ano;
    private String combustivel;
    private Byte num_portas;
    private String cor;
}
