package com.ws.wsworkchallenge.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateModelDTO {

    @NotNull
    private Long BrandId;

    @NotNull
    @NotBlank
    private String name;

    @NotNull
    private Double valueFipe;
}
