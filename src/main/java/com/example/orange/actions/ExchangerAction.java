package com.example.orange.actions;

import com.example.orange.actions.dto.BaseResponseDTO;
import com.example.orange.models.ExchangeRate;
import com.example.orange.models.Exchanger;

import java.util.HashMap;
import java.util.Map;

public class ExchangerAction extends BaseAction{

    public static BaseResponseDTO ratesInserting(Long operatorId, Long currencyIdRecieved, Long currencyIdWithdrawn ,Double received) {
        String url = "http://localhost:8080/exchanger/transaction";

        Map<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/json");

        return post(url,
                null,
                headers,
                new Exchanger(operatorId,currencyIdRecieved, currencyIdWithdrawn, received),
                BaseResponseDTO.class);
    }
}
