package com.example.orange.models;

import lombok.*;

import javax.persistence.*;
import java.sql.Timestamp;

// Operatiunele facute de operatori
@Table
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Exchanger  {

    @Id
    private Long id;

    Long operatorId;
    Long currencyIdReceived;
    Long currencyIdWithdrawn;

    Double received;
    Double rates;
    Double withdrawn;
    Timestamp date;

    public Exchanger(Long operatorId, Long currencyIdRecieved, Long currencyIdWithdrawn, Double received) {
        this.operatorId = operatorId;
        this.currencyIdReceived = currencyIdRecieved;
        this.currencyIdWithdrawn = currencyIdWithdrawn;
        this.received = received;
    }
}
