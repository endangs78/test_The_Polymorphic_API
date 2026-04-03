package com.test.demo.factory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.test.demo.componen.ResourceNotFoundException;
import com.test.demo.service.FinanceService;

@Component
public class FinanceServiceFactory {

    private final Map<String, FinanceService> serviceMap = new HashMap<>();

    public FinanceServiceFactory(List<FinanceService> services) {
        for (FinanceService service : services) {
            serviceMap.put(service.getType(), service);
        }
    }

    public FinanceService getService(String type) {
        FinanceService service = serviceMap.get(type);

        if (service == null) {
            throw new ResourceNotFoundException("Resource type not found: " + type);
        }

        return service;
    }
}
