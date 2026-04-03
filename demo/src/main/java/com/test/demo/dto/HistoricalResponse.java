package com.test.demo.dto;

import java.util.Map;

import lombok.Data;

@Data
public class HistoricalResponse {

    private Double amount;
    private String base;

    private Map<String, Map<String, Double>> rates;
}
