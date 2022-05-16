package com.example.orange.controllers;

import com.example.orange.models.Cash;
import com.example.orange.repository.CashRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(value = "/cash")
public class CashController {

    CashRepository cashRepository;

    @Autowired
    public void setCashRepository(CashRepository cashRepository) {
        this.cashRepository = cashRepository;
    }

    @GetMapping
    public Flux<Cash> findAll() {
        return cashRepository.findAll();
    }

    @GetMapping("/{id}")
    public Flux<Cash> findById(@PathVariable long id) {
        return cashRepository.findByOperatorId(id);
    }

    @PostMapping("/subtraction")
    public Mono<Cash> subtraction(@RequestBody Cash cash) {
        return cashRepository.subtraction(cash.getAmount(), cash.getOperatorId(), cash.getCurrencyId());
    }
    @PostMapping("/replenishment")
    public Mono<Cash> replenishment(@RequestBody Cash cash) {
        return cashRepository.replenishment(cash.getAmount(), cash.getOperatorId(), cash.getCurrencyId());
    }

}
