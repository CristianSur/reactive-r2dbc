package com.example.orange.models;

import lombok.*;

import javax.persistence.Id;
import javax.persistence.Table;

@Table
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Currency {

    @Id
    Long currencyId;

    String code;
    String name;


    public Currency(String code, String name) {
        this.code = code;
        this.name = name;
    }

}
