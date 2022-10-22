package com.ws.wsworkchallenge.car.entity;

import com.ws.wsworkchallenge.model.entity.Model;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long timestampRegistration;

    @ManyToOne
    @JoinColumn(name = "model_id")
    private Model model;
    private Integer year;
    private String fuel;
    private Byte numberDoors;
    private String color;
}
