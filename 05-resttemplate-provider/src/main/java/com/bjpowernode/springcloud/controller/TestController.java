package com.bjpowernode.springcloud.controller;

import com.bjpowernode.springcloud.model.User;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TestController {
    @RequestMapping("/getForEntity01")

    public Object getForEneity01() {
        User user = new User(1L, "张三", 11);

        return user;
    }

    @RequestMapping("/getForEntity02")

    public Object getForEneity02() {
        User user = new User(1L, "张三", 11);
        User user2 = new User(2L, "张三", 11);
        User user3 = new User(3L, "张三", 11);
        List<User> list = new ArrayList<User>();
        list.add(user3);
        list.add(user);
        list.add(user2);
        return list;
    }

    @RequestMapping("/getForEntityParams01")

    public Object getForEntitParams01(User user) {
        user.setName(user.getName()+"服务提供者");
        return user;
    }

    @RequestMapping("/getForEntityParams02")

    public Object getForEntitParams02 (User user) {
        user.setName(user.getName()+"服务提供者");
        return user;
    }

    @RequestMapping("/getForObject")
    public Object getForObject () {
        User user = new User(1L, "张三", 11);
        return user;
    }

    @RequestMapping("/postForObject")
    public Object postForObject (User user) {
        user.setName(user.getName()+"服务提供者");
        return user;
    }
    @PutMapping("/put")
    public Object putForObject (User user) {
        user.setName(user.getName()+"服务提供者");
        System.out.println(user.getAge());
        System.out.println(user.getId());
        System.out.println(user.getName());
        return user;
    }

    @DeleteMapping("/delete")
    public Object delete (Integer id) {
        System.out.println(id);
        return "删除成功";
    }

}
