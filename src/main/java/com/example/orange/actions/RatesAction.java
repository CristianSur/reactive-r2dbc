package com.example.orange.actions;

import com.example.orange.actions.dto.BaseResponseDTO;
import com.example.orange.models.ExchangeRate;

import java.util.HashMap;
import java.util.Map;

import static com.example.orange.actions.BaseAction.post;
import static com.example.orange.actions.BaseAction.get;

public class RatesAction {

//    public static BaseResponseDTO ratesInserting(Long currencyId, Integer nominal, Double value) {
//        String url = "http://localhost:8080/rates/new";
//
//        Map<String, String> headers = new HashMap<>();
//        headers.put("Content-Type", "application/json");
//
//        return post(url,
//                null,
//                headers,
//                new ExchangeRate(currencyId,nominal, value),
//                BaseResponseDTO.class);
//    }

    public static BaseResponseDTO ratesInserting(Long currencyId, Integer nominal, Double value) {
        String url = "http://localhost:8080/rates/new";

        Map<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/json");

        return post(url,
                null,
                headers,
                new ExchangeRate(currencyId,nominal, value),
                BaseResponseDTO.class);
    }

    public static ExchangeRate getRateById(Long id) {
        String url = "http://localhost:8080/rates/rate/" + id;

        Map<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/json");

        return get(url,
                null,
                headers,
                ExchangeRate.class);
    }
}
