package com.bjpowernode.springcloud.controller;

import com.bjpowernode.springcloud.mode.User;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TestController {
    @RequestMapping("/test")
    public String test() {
        System.out.println(10/0);
        return "使用Feign的服务提供者";
    }

    @RequestMapping("/testParams01")
    public String testParams01(String name,Integer age) {
        return "testParams01使用Feign的服务提供者name "+name+" age "+age;
    }

    /**
     * 必须加@RequestBody 不然参数传递不到服务提供者中 服务提供者也需要加
     * @param user
     * @return
     */
    @RequestMapping("/testParams02")
    public String testParams02(@RequestBody User user) {
        return "testParams02使用Feign的服务提供者name "+user.getName()+" age "+user.getAge();
    }

    @RequestMapping("/testreturnUser")
    public Object testreturnUser() {
        User user = new User("张三",22);
       return user;
    }

    @RequestMapping("/testreturnList")
    public Object testreturnList() {
        User user = new User("张三",22);
        User user2 = new User("张四",223);
        List list = new ArrayList();
        list.add(user);
        list.add(user2);
        return list;
    }

}
