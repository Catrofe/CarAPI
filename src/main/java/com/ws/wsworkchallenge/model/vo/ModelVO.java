package com.ws.wsworkchallenge.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ModelVO {
    private Long id;
    private String nameBrand;
    private Long idBrand;
    private String name;
    private Double valueFipe;
}
