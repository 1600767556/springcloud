package com.bjpowernode.springcloud.hystrix;

import com.bjpowernode.springcloud.model.User;
import com.bjpowernode.springcloud.service.TestService;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 自定义异常熔断器类并实现自定义的声明式Feign的接口
 * 为这个接口中的所有抽象方法提供熔断处理
 */
@Component
public class MyFallback implements TestService {


    @Override
    public String test() {
        return "test请求熔断";
    }

    @Override
    public String testParams01(String name, Integer age) {
        return "testParams01请求熔断";
    }

    @Override
    public String testParams02(User user) {
        return "testParams02请求熔断";
    }

    @Override
    public User testreturnUser() {
        return null;
    }

    @Override
    public List<User> testreturnList() {
        return null;
    }
}
