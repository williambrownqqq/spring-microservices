package com.zanchenko.alexey.microservices.http.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service("SecondService")
public class PropertyServiceSecondImpl implements PropertyService {
    @Value("${my.test.property:blabla}")
    private String propertyValue;

    @Override
    public String getPropertyValue() {
        return propertyValue;
    }
}
