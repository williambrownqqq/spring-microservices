package com.zanchenko.alexey.microservicesclient.controller;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping(value = "api/second-microservice")
public class ControllerClient {
    //http:localhost:8087/api/second-microservice/call-first-microservice
    @GetMapping(value = "/call-first-microservice")
    public String getResponse(){
        String url = "http:localhost:8088/api/property1";
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(url) // by default get request
                .build();
        try (Response response = client.newCall(request).execute()){
            return response.body().string();
        } catch (IOException e){
            throw new RuntimeException(e);
        }
    }
    // когда идет кол на этот ендпоинт, то с этого ендпоинта будет генерироваться кол на ендпоинт с первого микросервиса

    //когда мы заходим на этот ендпоинт, у нас сгенерировался колл на первый микросервис
    // первый микросервис отдает нам респонс, мы получаем его на втором микросервисе и видим уже его

    // более известный вариант имплементации HTTP клиента в  библиотеку,
}
