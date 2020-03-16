package com.cloud.demo.consumer.service.impl;

import com.cloud.demo.consumer.rpc.GetHello;
import com.cloud.demo.consumer.service.HiService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class HiServiceImpl implements HiService {
    @Resource
    private GetHello getHello;

    @Override
    public String sayHello(String name) {
        return getHello.sayHello(name);
    }
}
