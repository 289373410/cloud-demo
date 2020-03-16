package com.cloud.demo.consumer.service.impl;

import com.cloud.demo.consumer.service.HiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class HiServiceImpl implements HiService {


    @Autowired
    private RestTemplate restTemplate;

    @Override
    public String sayHello(String name) {
        String url = "http://provider/hello?name="+name;
        System.err.println(url);
        return restTemplate.getForObject(url,String.class);
    }
}
