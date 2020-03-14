package com.cloud.demo.consumer.controller;

import com.cloud.demo.consumer.service.HiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HiController {

    @Autowired
    private HiService hiService;

    @GetMapping("/hi")
    public String sayHello(String name){
        return hiService.sayHello(name);
    }
}
