package com.example.orange.controllers;

import com.example.orange.actions.CashAction;
import com.example.orange.actions.RatesAction;
import com.example.orange.excel.ExcelReport;
import com.example.orange.models.Exchanger;
import com.example.orange.repository.ExchangerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(value = "/exchanger")
public class ExchangerController {

    static Logger log = LoggerFactory.getLogger(ExchangerController.class);

    ExchangerRepository exchangerRepository;

    @Autowired
    public void setExchangerRepository(ExchangerRepository exchangerRepository) {
        this.exchangerRepository = exchangerRepository;
    }

    @GetMapping
    Flux<Exchanger> findAll() {
       return exchangerRepository.findAll().log();
    }

    @PostMapping("/excel")
    public void getExcel() {
        try {
            ExcelReport.createExcel("2022-05-17");
        } catch (Exception e) {
            log.error("We could not create the excel report");
            e.printStackTrace();

        }
    }

    @PostMapping("/transaction")
    Mono<Exchanger> newTransaction(@RequestBody Exchanger exchanger) {
        return Mono.just(exchanger).log().flatMap(o -> {
            CashAction.cashSubtraction(
                    (exchanger.getReceived() * RatesAction.getRateById(exchanger.getCurrencyIdReceived()).getRate() / RatesAction.getRateById(exchanger.getCurrencyIdWithdrawn()).getRate())
                    , exchanger.getOperatorId()
                    , exchanger.getCurrencyIdWithdrawn());
            CashAction.cashRepleinishment(exchanger.getReceived()
                    , exchanger.getOperatorId()
                    , exchanger.getCurrencyIdReceived());
             return exchangerRepository.insertNew(
                    exchanger.getOperatorId(),
                    exchanger.getCurrencyIdReceived(),
                    exchanger.getCurrencyIdWithdrawn(),
                    exchanger.getReceived(),
                    RatesAction.getRateById(exchanger.getCurrencyIdReceived()).getRate(),
                    exchanger.getReceived()*RatesAction.getRateById(exchanger.getCurrencyIdReceived()).getRate()/RatesAction.getRateById(exchanger.getCurrencyIdWithdrawn()).getRate());
        }).log("Transaction finished");
    }

}
