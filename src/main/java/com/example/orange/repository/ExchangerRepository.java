package com.example.orange.repository;

import com.example.orange.models.Exchanger;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import reactor.core.publisher.Mono;

public interface ExchangerRepository extends R2dbcRepository<Exchanger, Long> {

    @Query("INSERT INTO exchanger(operator_id, currency_id_received, currency_id_withdrawn, rate, received, withdrawn)" +
            " VALUES (:operator, :currencyReceived, :currencyWithdrawn,:rate,:received,:withdrawn)")
    Mono<Exchanger> insertNew(Long operator, Long currencyReceived, Long currencyWithdrawn, Double received, Double rate, Double withdrawn);

}
