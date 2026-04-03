package com.test.demo.service;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.test.demo.componen.FrankfurterClient;
import com.test.demo.componen.SpreadUtil;
import com.test.demo.dto.LatestRatesResponse;

@Service
public class LatestRatesService implements FinanceService {

    private final FrankfurterClient client;
    private final SpreadUtil spreadUtil;

    public LatestRatesService(FrankfurterClient client, SpreadUtil spreadUtil) {
        this.client = client;
        this.spreadUtil = spreadUtil;
    }

    @Override
    public Object getData() {

        LatestRatesResponse response = client.getLatestRates();

        Map<String, Double> rates = response.getRates();

        Double usdRate = rates.get("USD");

        double spreadFactor = spreadUtil.calculateSpreadFactor("endangsuwarni");

        double result = (1 / usdRate) * (1 + spreadFactor);

        response.setUsdBuySpreadIdr(result);

        return response;
    }

    @Override
    public String getType() {
        return "latest_idr_rates";
    }
}
