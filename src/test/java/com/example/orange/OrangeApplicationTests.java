package com.example.orange;

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
    }

//    @Test
//    public void whenSearchForCR7_then1IsExpected() {
//        operatorRepository.findAllByLastName("Suruceanu")
//                .as(StepVerifier::create)
//                .expectNextCount(1)
//                .verifyComplete();
//    }

//    @Test
//    public void creating() {
//        Exchanger exchanger = new Exchanger(1, 1, 0.5d, 100, 100);
//        System.out.println(exchanger.getDate());
//        System.out.println(exchanger.getId());
//
//        exchangerRepository.save(exchanger);
//
//        System.out.println(exchangerRepository.findAll().map(o -> o.getDate()));
//
//    }

}
