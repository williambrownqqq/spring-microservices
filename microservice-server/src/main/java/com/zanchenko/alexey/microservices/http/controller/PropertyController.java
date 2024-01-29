package com.zanchenko.alexey.microservices.http.controller;

import com.zanchenko.alexey.microservices.http.service.PropertyService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PropertyController {

    // @Autowired
    private final PropertyService propertyServiceFirst;
    private final PropertyService propertyServiceSecond;

    public PropertyController(@Qualifier("FirstService") PropertyService propertyServiceFirst,
                              @Qualifier("SecondService")PropertyService propertyServiceSecond) {
        this.propertyServiceFirst = propertyServiceFirst;
        this.propertyServiceSecond = propertyServiceSecond;
    }

    //http:localhost:8088/api/property1
    @GetMapping("api/property1")
    public ResponseEntity<String> getResponseFirst(){
        return ResponseEntity.ok(propertyServiceFirst.getPropertyValue());
    }

    //http:localhost:8088/api/property2
    @GetMapping("api/property2")
    public ResponseEntity<String> getResponseSecond(){
        return ResponseEntity.ok(propertyServiceSecond.getPropertyValue());
    }
}
