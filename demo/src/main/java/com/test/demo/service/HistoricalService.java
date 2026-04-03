package com.test.demo.service;

import org.springframework.stereotype.Service;

import com.test.demo.componen.FrankfurterClient;

@Service
public class HistoricalService implements FinanceService {

    private final FrankfurterClient client;

    public HistoricalService(FrankfurterClient client) {
        this.client = client;
    }

    @Override
    public Object getData() {
        return client.getHistorical();
    }

    @Override
    public String getType() {
        return "historical_idr_usd";
    }
}
