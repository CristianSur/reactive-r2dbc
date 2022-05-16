package com.example.orange.controllers;

import com.example.orange.models.ExchangeRate;
import com.example.orange.repository.ExchangeRateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(value = "/rates")
public class ExchangeRateController {

    ExchangeRateRepository exchangeRateRepository;

    @Autowired
    public void setExchangeRateRepository(ExchangeRateRepository exchangeRateRepository) {
        this.exchangeRateRepository = exchangeRateRepository;
    }

    @GetMapping
    public Flux<ExchangeRate> findAll() {
        return exchangeRateRepository.findAll();
    }

    @PostMapping("/new")
    public Mono<ExchangeRate> addNewOperator(@RequestBody ExchangeRate exchangeRate) throws Exception {
        return exchangeRateRepository.save(exchangeRate.getCurrencyId(), exchangeRate.getNominal(), exchangeRate.getRate());
    }

    @GetMapping("/rate/{id}")
    public Mono<ExchangeRate> findRateByIdd(@PathVariable Long id) {
        return exchangeRateRepository.findById(id);
    }

}
