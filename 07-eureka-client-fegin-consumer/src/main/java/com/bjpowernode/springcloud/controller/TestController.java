package com.bjpowernode.springcloud.controller;

import com.bjpowernode.springcloud.model.User;
import com.bjpowernode.springcloud.service.TestService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class TestController {
    @Resource
    private TestService testService;

    @RequestMapping("/test")
    public String test() {

        String body = testService.test();

        return "使用了Feign的服务消费者---"+body;
    }

    @RequestMapping("/testParams01")
    public String testParams01() {

        String body = testService.testParams01("张三",11);

        return "使用了Feign的服务消费者---"+body;
    }

    @RequestMapping("/testParams02")
    public String testParams02() {
        User user = new User("李四",20);
        String body = testService.testParams02(user);

        return "使用了Feign的服务消费者---"+body;
    }

    @RequestMapping("/testreturnUser")
    public String testreturnUser() {
        User body = testService.testreturnUser();

        return "使用了Feign的服务消费者---"+body.getName()+"  "+body.getAge();
    }

    @RequestMapping("/testreturnList")
    public String testreturnList() {
        List<User> body = testService.testreturnList();
        for (User user : body) {
            System.out.println(user.getName()+  "  "+ user.getAge());
        }
        return "使用了Feign的服务消费者---"+body;
    }
}
