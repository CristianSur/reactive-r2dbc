package com.example.orange;

import com.example.orange.actions.CashAction;
import com.example.orange.actions.CurrencyAction;
import com.example.orange.actions.ExchangerAction;
import com.example.orange.repository.ExchangerRepository;
import com.example.orange.repository.OperatorRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class OrangeApplicationTests {


    @Autowired
    OperatorRepository operatorRepository;

    @Autowired
    ExchangerRepository exchangerRepository;


    @Test
    void contextLoads() {
        ExchangerAction.ratesInserting(1L, 3L, 1L, 25.0);
    }


}
