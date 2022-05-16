package com.example.orange.repository;

import com.example.orange.models.Currency;
import org.springframework.data.r2dbc.repository.Modifying;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import reactor.core.publisher.Mono;

public interface CurrencyRepository extends R2dbcRepository<Currency, Long> {

    @Modifying
    @Query("INSERT INTO currency(code, name) VALUES (:code, :name)")
    Mono<Currency> save(String code, String name);

}
