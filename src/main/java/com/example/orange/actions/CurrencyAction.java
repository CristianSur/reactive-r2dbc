package com.example.orange.actions;

import com.example.orange.actions.dto.BaseResponseDTO;
import com.example.orange.models.Currency;

import java.util.HashMap;
import java.util.Map;

public class CurrencyAction extends BaseAction {


    public static BaseResponseDTO currencyInserting(String code, String name) {

        String url = "http://localhost:8080/currency/new";

        Map<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/json");

        return post(url,
                null,
                headers,
                new Currency(code, name),
                BaseResponseDTO.class);
    }


}
