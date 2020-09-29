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
        String url = "http://08-eureka-client-provider-zuul/test";
        String forEntity = restTemplate.getForObject(url, String.class);
        return "没有经过Zuul网关的服务消费者---" + forEntity;
    }

    @RequestMapping("/test02")
    public String test02(String token) {
        String url = "http://08-EUREKA-CLIENT-ZUUL-GATEWAY/api-zuul/test?token="+token;
        String forEntity = restTemplate.getForObject(url, String.class);
        return "经过Zuul网关的服务消费者---" + forEntity;
    }
}
