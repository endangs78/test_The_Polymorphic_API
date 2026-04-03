package com.test.demo.dto;

import java.util.Map;

import lombok.Data;

@Data
public class LatestRatesResponse {
    private String base;
    private Map<String, Double> rates;
    private Double usdBuySpreadIdr;
}
