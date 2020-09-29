package com.bjpowernode.springcloud.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
public class TestController {

//注入一个rest风格的请求模板对象
    @Resource
    private RestTemplate restTemplate;
@RequestMapping("/test")
    public String test(){

    //RestTemplate restTemplate = new RestTemplate();


    ResponseEntity<String> forEntity = restTemplate.getForEntity("http://localhost:8081/test", String.class);
    System.out.println(forEntity.getStatusCode());
    System.out.println(forEntity.getHeaders());
    String body  = forEntity.getBody();
    return "第一个springcloud的服务消费者---"+ body;
}
}
