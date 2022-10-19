package com.ws.wsworkchallenge.model.controllers;

import com.ws.wsworkchallenge.model.dto.CreateModelDTO;
import com.ws.wsworkchallenge.model.dto.EditModelDTO;
import com.ws.wsworkchallenge.model.entity.Model;
import com.ws.wsworkchallenge.model.services.ModelService;
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
    public ResponseEntity<Model> create(@RequestBody @Valid CreateModelDTO model) {
        Model newModel = service.create(model);
        return new ResponseEntity<>(newModel, HttpStatus.CREATED);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Model> getModel(@PathVariable Long id) {
        Model model = service.findById(id);
        return new ResponseEntity<>(model, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Model>> findAllModels() {
        List<Model> model = service.findAll();
        return new ResponseEntity<>(model, HttpStatus.OK);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Model> updateModel(@RequestBody EditModelDTO model,
                                             @PathVariable Long id) {
        Model newModel = service.update(model, id);
        return new ResponseEntity<>(newModel, HttpStatus.OK);
    }

}
