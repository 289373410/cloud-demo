package com.cloud.demo.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableHystrix
@EnableHystrixDashboard
@SpringBootApplication
@EnableFeignClients
//@EnableDiscoveryClient
public class ConsumerFeignHystrixApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerFeignHystrixApplication.class, args);
    }

}


