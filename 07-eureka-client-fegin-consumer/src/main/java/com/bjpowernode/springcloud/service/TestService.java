package com.bjpowernode.springcloud.service;

import com.bjpowernode.springcloud.hystrix.MyFallback;
import com.bjpowernode.springcloud.hystrix.MyFallbackFactory;
import com.bjpowernode.springcloud.model.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @FeignClient用于标记当前接口是一个Fegin的声明式服务接口 spring会为这个接口生成动态代理对象
 * name 用于指定注册中心某个服务的名字
 */
//@FeignClient(name = "07-EUREKA-CLIENT-FEGIN-PROVIDER",fallback = MyFallback.class)
@FeignClient(name = "07-EUREKA-CLIENT-FEGIN-PROVIDER",fallbackFactory = MyFallbackFactory.class)
public interface TestService {
    @RequestMapping("/test")
    String test();

    @RequestMapping("/testParams01")
    String testParams01(@RequestParam String name, @RequestParam Integer age);

    @RequestMapping("/testParams02")
    String testParams02(@RequestBody User user);

    @RequestMapping("/testreturnUser")
    User testreturnUser();

    @RequestMapping("/testreturnList")
    List<User> testreturnList();
}
