package com.cloud.demo.provider.service.impl;

import com.cloud.demo.provider.service.HelloService;
import org.springframework.stereotype.Service;

@Service
public class HelloServiceImpl implements HelloService {


    @Override
    public String sayHello(String name) {
        return name;
    }
}
