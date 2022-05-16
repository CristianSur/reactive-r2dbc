package com.example.orange.models;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Table
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cash   {

    @Id
    Long id;

    Long operatorId;
    Long currencyId;
    Double amount;
    LocalDateTime lastModifiedDate;

    public Cash(Double amount, Long operator, Long currency) {
        this.amount = amount;
        this.operatorId = operator;
        this.currencyId = currency;
    }

}