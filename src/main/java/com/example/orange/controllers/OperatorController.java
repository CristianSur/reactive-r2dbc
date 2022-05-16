package com.example.orange.controllers;

import com.example.orange.models.Operator;
import com.example.orange.repository.OperatorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(value = "/operator")
public class OperatorController {

    OperatorRepository operatorRepository;

    @Autowired
    public void setOperatorRepository(OperatorRepository operatorRepository) {
        this.operatorRepository = operatorRepository;
    }

    @GetMapping
    public Flux<Operator> findAll() {
        return operatorRepository.findAll();
    }

    @GetMapping("/{id}")
    public Mono<Operator> findById(@PathVariable long id) {
        return operatorRepository.findById(id);
    }

    @PostMapping("/new")
    public Mono<Operator> addNewOperator(@RequestBody Operator operator) {
        return operatorRepository.save(operator);
    }

    @DeleteMapping("/delete/{id}")
    public Mono<Void> deleteOperatorById(@PathVariable long id) {
        return operatorRepository.deleteById(id);
    }

}