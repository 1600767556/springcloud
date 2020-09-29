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
    public String test() {

        //RestTemplate restTemplate = new RestTemplate();

/**
 * 通过注册中心发现服务并访问服务
 */
        ResponseEntity<String> forEntity = restTemplate.getForEntity("http://02-eureka-client-provider/test", String.class);

        String body = forEntity.getBody();
        return "使用了Eureka的服务消费者---" + body;
    }
}
