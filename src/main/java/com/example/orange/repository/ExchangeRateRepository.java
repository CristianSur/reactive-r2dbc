package com.example.orange.repository;

import com.example.orange.models.ExchangeRate;
import org.springframework.data.r2dbc.repository.Modifying;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import reactor.core.publisher.Mono;

public interface ExchangeRateRepository extends R2dbcRepository<ExchangeRate, Long> {

    @Query("SELECT * FROM exchange_rate WHERE id = $1")
    Mono<ExchangeRate> findById(Long id);

    @Query("SELECT rate FROM exchange_rate WHERE id = :id")
    Mono<Double> findRateById(Long id);

    @Modifying
    @Query("INSERT INTO exchange_rate(currency_id, nominal, rate) VALUES (:currency, :nominal, :rate)")
    Mono<ExchangeRate> save(Long currency, Integer nominal, Double rate);
}
