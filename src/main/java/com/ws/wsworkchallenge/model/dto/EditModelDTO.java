package com.ws.wsworkchallenge.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EditModelDTO implements EditModelDetail {
    private Long idMarca;
    private String name;
    private Double valorFipe;
}
