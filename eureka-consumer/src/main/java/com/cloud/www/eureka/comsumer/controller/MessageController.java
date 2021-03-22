package com.cloud.www.eureka.comsumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class MessageController {
    @Autowired
    RestTemplate restTemplate;

//    可以使用虚拟IP替代真实IP地址。所谓的虚拟IP就是服务提供者在application.properties或yml文件中配置的spring.application.name属性的值。
    @GetMapping("/show")
    public String showMessage(@RequestParam String name){
        return restTemplate.getForObject("http://producer/get?name="+name, String.class);
    }

}
