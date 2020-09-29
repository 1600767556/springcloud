package com.bjpowernode.springcloud.hystrix;

import com.bjpowernode.springcloud.model.User;
import com.bjpowernode.springcloud.service.TestService;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 自定义异常熔断器类 并且实现Hystrix的降级回调父接口
 * 注意
 *      这个父接口的泛型很重要 ,这个泛型决定当前类要为哪个声明式接口提供异常熔断
 */
@Component
public class MyFallbackFactory implements FallbackFactory<TestService> {
    /**
     * creat方法来自父接口
     * @param throwable
     * @return
     */
    @Override
    public TestService create(Throwable throwable) {
        //使用匿名内部类来创建TestService生命是服务接口的熔断对象

        return new TestService() {
            @Override
            public String test() {
                System.out.println(throwable.getMessage());
                System.out.println(throwable.getClass());
                System.out.println(throwable.getCause());
                return "test方法被熔断了"+throwable.getMessage();
            }

            @Override
            public String testParams01(String name, Integer age) {
                return null;
            }

            @Override
            public String testParams02(User user) {
                return null;
            }

            @Override
            public User testreturnUser() {
                return null;
            }

            @Override
            public List<User> testreturnList() {
                return null;
            }
        };
    }
}
