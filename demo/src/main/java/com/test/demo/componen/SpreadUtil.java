package com.test.demo.componen;

import org.springframework.stereotype.Component;

@Component
public class SpreadUtil {

    public double calculateSpreadFactor(String username) {
        int sum = username.toLowerCase()
                .chars()
                .sum();

        return (sum % 1000) / 100000.0;
    }
}
