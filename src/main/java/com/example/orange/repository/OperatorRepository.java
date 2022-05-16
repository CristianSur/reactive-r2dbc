package com.example.orange.repository;

import com.example.orange.models.Operator;

import org.springframework.data.r2dbc.repository.R2dbcRepository;

public interface OperatorRepository extends R2dbcRepository<Operator, Long> {

}
