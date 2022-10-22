package com.ws.wsworkchallenge.brand.controllers;
import com.ws.wsworkchallenge.brand.dto.RegisterBrand;
import com.ws.wsworkchallenge.brand.entity.Brand;
import com.ws.wsworkchallenge.brand.service.BrandService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/brand")
public class BrandController {

    private final BrandService service;

    @PostMapping
    public ResponseEntity<Brand> save(@RequestBody @Valid RegisterBrand brand){
        Brand newBrand = service.insert(brand);
        return new ResponseEntity<>(newBrand, HttpStatus.CREATED);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Brand> findById(@PathVariable Long id){
        Brand brand = service.findById(id);
        return new ResponseEntity<>(brand, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Brand>> findAll(){
        List<Brand> brands = service.getAllBrands();
        return new ResponseEntity<>(brands, HttpStatus.OK);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Brand> update(@RequestBody @Valid RegisterBrand brand,
                                             @PathVariable Long id){
        Brand newBrand = service.update(brand, id);
        return new ResponseEntity<>(newBrand, HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
