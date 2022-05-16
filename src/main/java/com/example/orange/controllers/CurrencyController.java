package com.example.orange.controllers;


import com.example.orange.models.Currency;
import com.example.orange.repository.CurrencyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(value = "/currency")
public class CurrencyController {

    CurrencyRepository currencyRepository;

    @Autowired
    public void setCurrencyRepository(CurrencyRepository currencyRepository) {
        this.currencyRepository = currencyRepository;
    }

    @GetMapping
    public Flux<Currency> findAll() {
       return currencyRepository.findAll();
    }

    @PostMapping("/new")
    public Mono<Currency> addNewOperator(@RequestBody Currency currency) {
        return currencyRepository.save(currency.getCode(), currency.getName());
    }
}
