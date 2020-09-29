package com.bjpowernode.springcloud.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfig {
    /**
     * zaispring的应用上下文中定义一个Rest模板对象
     * @return
     */
    @Bean
    public RestTemplate restTemplate(){

        return new RestTemplate();
    }

}
