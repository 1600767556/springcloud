package com.bjpowernode.springcloud.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
public class TestController {

    @Resource
    private RestTemplate restTemplate;

    @RequestMapping("/test")
    public String test(){
        ResponseEntity<String> forEntity = restTemplate.getForEntity("http://04-EUREKA-CLIENT-RIBBON-PROVIDER/test", String.class);
        String body = forEntity.getBody();
        return "使用了Ribbon负载均衡的消费者---"+body;
    }

}
