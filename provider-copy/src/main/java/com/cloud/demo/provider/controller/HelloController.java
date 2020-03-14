package com.cloud.demo.provider.controller;


import com.cloud.demo.provider.service.HelloService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class HelloController {

    @Resource
    private HelloService helloService;

    @Value("${server.port}")
    private int port;


    @GetMapping("/hello")
    public String sayHello(String name){
        return "你好，cloud"+helloService.sayHello("name："+name+"port:"+port);
    }
}
