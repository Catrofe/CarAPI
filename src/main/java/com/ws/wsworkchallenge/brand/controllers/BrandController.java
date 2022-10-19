package com.ws.wsworkchallenge.brand.controllers;
import com.ws.wsworkchallenge.brand.dto.RegisterBrand;
import com.ws.wsworkchallenge.brand.dto.IdsForDelete;
import com.ws.wsworkchallenge.brand.entity.Marca;
import com.ws.wsworkchallenge.brand.service.BrandService;
import com.ws.wsworkchallenge.brand.vo.ListErrorDeleted;
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
    public ResponseEntity<Marca> create(@RequestBody @Valid RegisterBrand marca){
        Marca newBrand = service.insert(marca);
        return new ResponseEntity<>(newBrand, HttpStatus.CREATED);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Marca> getBrand(@PathVariable Long id){
        Marca brand = service.getBrand(id);
        return new ResponseEntity<>(brand, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Marca>> getBrands(){
        List<Marca> brand = service.getAllBrands();
        return new ResponseEntity<>(brand, HttpStatus.OK);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Marca> updateBrand(@RequestBody @Valid RegisterBrand marca,
                                             @PathVariable Long id){
        Marca newBrand = service.update(marca, id);
        return new ResponseEntity<>(newBrand, HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteBrand(@PathVariable Long id) {
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping(value = "/deleteByList")
    public ResponseEntity<ListErrorDeleted> deleteAllBrands(@RequestBody IdsForDelete ids) {
        List<String> deleteOk = service.deleteAll(ids.getIds());
        if (deleteOk.size() == 0) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(new ListErrorDeleted(deleteOk), HttpStatus.OK);
    }
}
