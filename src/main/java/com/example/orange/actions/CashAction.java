package com.example.orange.actions;

import com.example.orange.actions.dto.BaseResponseDTO;
import com.example.orange.models.Cash;

import java.util.HashMap;
import java.util.Map;

public class CashAction extends BaseAction {


    public static BaseResponseDTO cashSubtraction(Double amount, Long operator, Long currency) {

        String url = "http://localhost:8080/cash/subtraction";

        Map<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/json");

        return post(url,
                null,
                headers,
                new Cash(amount, operator, currency),
                BaseResponseDTO.class);
    }

    public static BaseResponseDTO cashRepleinishment(Double amount, Long operator, Long currency) {

        String url = "http://localhost:8080/cash/replenishment";

        Map<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/json");

        return post(url,
                null,
                headers,
                new Cash(amount, operator, currency),
                BaseResponseDTO.class);
    }
}
