package com.example.orange.repository;

import com.example.orange.models.Cash;
import org.springframework.data.r2dbc.repository.Modifying;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CashRepository extends R2dbcRepository<Cash, Long> {

    @Query("SELECT * FROM cash WHERE id = $1")
    Mono<Cash> findById(Long id);

    @Query("SELECT cash.* FROM cash JOIN operator o on cash.operator_id = o.id JOIN currency c on cash.currency_id = c.id WHERE cash.operator_id = $1")
    Flux<Cash> findByOperatorId(Long id);

    @Modifying
    @Query("UPDATE cash SET amount = amount - :amount, last_modified_date = CURRENT_TIMESTAMP WHERE operator_id = :operator AND currency_id = :currency")
    Mono<Cash> subtraction(Double amount, Long operator, Long currency);

    @Modifying
    @Query("UPDATE cash SET amount = amount + :amount, last_modified_date = CURRENT_TIMESTAMP WHERE operator_id = :operator AND currency_id = :currency")
    Mono<Cash> replenishment(Double amount, Long operator, Long currency);

}
