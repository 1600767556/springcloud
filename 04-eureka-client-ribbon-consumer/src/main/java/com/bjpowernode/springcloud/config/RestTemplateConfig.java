package com.bjpowernode.springcloud.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfig {
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();

    }

    /**
     * 定义Ribbon负载均衡策略,勇于改变Ribbon的默认负载均衡策略
     * @return
     */
    @Bean
    public IRule iRule(){
        //创建一个随机的
        return new RandomRule();
    }


}
