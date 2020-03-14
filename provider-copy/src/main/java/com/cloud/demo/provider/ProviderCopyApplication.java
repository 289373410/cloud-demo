package com.cloud.demo.provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
//@EnableDiscoveryClient  //代表自己是一个Eureka的客户端
public class ProviderCopyApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProviderCopyApplication.class, args);
    }


}
