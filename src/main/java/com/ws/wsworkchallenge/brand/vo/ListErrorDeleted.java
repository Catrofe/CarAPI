package com.ws.wsworkchallenge.brand.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ListErrorDeleted {
    private List<String> error;
}
