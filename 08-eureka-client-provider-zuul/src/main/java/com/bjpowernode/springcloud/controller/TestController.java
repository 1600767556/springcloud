package com.bjpowernode.springcloud.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
@RequestMapping("/test")
    public String test(){
        return "使用Zuul的服务提供者";
    }


    @RequestMapping("/test02")
    public String test02(){
        return "使用Zuul的服务提供者";
    }

}
