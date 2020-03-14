package com.cloud.demo.consumer;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
//@EnableDiscoveryClient
public class ConsumerRibbonApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerRibbonApplication.class, args);
    }


    //开启restTemplate负载均衡
    @Bean
    @LoadBalanced
    RestTemplate restTemplate(){
        return new RestTemplate();
    }

    /**
     * 配置随机负载策略，需要配置属性service-B.ribbon.NFLoadBalancerRuleClassName=com.netflix.loadbalancer.RandomRule
     */
    @Bean
    public IRule ribbonRule() {
        return new RandomRule();
    }


}
