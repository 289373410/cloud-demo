package com.cloud.demo.consumer.controller;

import com.cloud.demo.consumer.rpc.GetHello;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class HiController {

    @Resource
    private GetHello getHello;

    @GetMapping("/hi")
    public String sayHello(String name){
        return getHello.sayHello(name);
    }
}
