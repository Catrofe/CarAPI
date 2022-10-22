package com.ws.wsworkchallenge.model.controllers;

import com.ws.wsworkchallenge.model.dto.CreateModelDTO;
import com.ws.wsworkchallenge.model.dto.EditModelDTO;
import com.ws.wsworkchallenge.model.entity.Model;
import com.ws.wsworkchallenge.model.services.ModelService;
import com.ws.wsworkchallenge.model.vo.ModelVO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RequiredArgsConstructor
@RestController
@RequestMapping("/model")
public class ModelController {

    private final ModelService service;

    @PostMapping
    public ResponseEntity<ModelVO> create(@RequestBody @Valid CreateModelDTO model) {
        ModelVO newModel = service.insert(model);
        return new ResponseEntity<>(newModel, HttpStatus.CREATED);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ModelVO> findById(@PathVariable Long id) {
        ModelVO model = service.findById(id);
        return new ResponseEntity<>(model, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<ModelVO>> findAll() {
        List<ModelVO> models = service.findAll();
        return new ResponseEntity<>(models, HttpStatus.OK);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<ModelVO> update(@RequestBody EditModelDTO model,
                                             @PathVariable Long id) {
        ModelVO newModel = service.update(model, id);
        return new ResponseEntity<>(newModel, HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
