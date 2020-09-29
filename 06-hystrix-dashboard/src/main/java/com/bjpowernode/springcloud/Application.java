package com.bjpowernode.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
//激活仪表盘功能
@EnableHystrixDashboard
@EnableCircuitBreaker //断路器


public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
