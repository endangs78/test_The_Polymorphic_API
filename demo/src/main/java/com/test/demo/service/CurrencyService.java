package com.test.demo.service;

import org.springframework.stereotype.Service;

import com.test.demo.componen.FrankfurterClient;

@Service
public class CurrencyService implements FinanceService {

    private final FrankfurterClient client;

    public CurrencyService(FrankfurterClient client) {
        this.client = client;
    }

    @Override
    public Object getData() {
        return client.getCurrencies();
    }

    @Override
    public String getType() {
        return "supported_currencies";
    }
}
