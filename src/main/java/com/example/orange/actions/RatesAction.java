package com.example.orange.actions;

import com.example.orange.actions.dto.BaseResponseDTO;
import com.example.orange.models.ExchangeRate;

import java.util.HashMap;
import java.util.Map;

import static com.example.orange.actions.BaseAction.post;
import static com.example.orange.actions.BaseAction.get;

public class RatesAction {

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
