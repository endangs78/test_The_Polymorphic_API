package com.test.demo.componen;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import com.test.demo.dto.HistoricalResponse;
import com.test.demo.dto.LatestRatesResponse;

@Component
public class FrankfurterClient {

    private final WebClient webClient;

    public FrankfurterClient(WebClient.Builder builder) {
        this.webClient = builder.baseUrl("https://api.frankfurter.app").build();
    }

    public LatestRatesResponse getLatestRates() {
        return webClient.get()
                .uri("/latest?base=IDR")
                .retrieve()
                .bodyToMono(LatestRatesResponse.class)
                .block();
    }

    public HistoricalResponse getHistorical() {
        return webClient.get()
                .uri("/2024-01-01..2024-01-05?from=IDR&to=USD")
                .retrieve()
                .bodyToMono(HistoricalResponse.class)
                .block();
    }

    public HistoricalResponse getCurrencies() {
        return webClient.get()
                .uri("/currencies")
                .retrieve()
                .bodyToMono(HistoricalResponse.class)
                .block();
    }
}
