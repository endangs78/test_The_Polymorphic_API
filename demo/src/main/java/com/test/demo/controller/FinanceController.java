package com.test.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.demo.factory.FinanceServiceFactory;
import com.test.demo.service.FinanceService;

@RestController
@RequestMapping("/api/finance")
public class FinanceController {

    private final FinanceServiceFactory factory;

    public FinanceController(FinanceServiceFactory factory) {
        this.factory = factory;
    }

    @GetMapping("/data/{resourceType}")
    public ResponseEntity<Object> getFinanceData(@PathVariable String resourceType) {

        FinanceService service = factory.getService(resourceType);

        return ResponseEntity.ok(service.getData());
    }
}
