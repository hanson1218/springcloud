package com.cloud.www.producer.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {

    @Value("${server.port}")
    String port;

    @GetMapping("/get")
    public String getMessage(@RequestParam("name")String name){
        return "Hi " + name + " ,I am from port:" + port;
    }

    @GetMapping("/feigntest")
    public String feigntest(@RequestParam("name")String name){
        return "Hi feign test.  " + name + " ,I am from port:" + port;
    }


}
