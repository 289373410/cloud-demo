package com.cloud.demo.consumer.service.impl;

import com.cloud.demo.consumer.service.HiService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class HiServiceImpl implements HiService {


    @Autowired
    private RestTemplate restTemplate;

    @Override
    @HystrixCommand(fallbackMethod = "getDefaultUser")
    public String sayHello(String name) {
        if(null != name){
            String url = "http://provider/hello?name="+name;
            System.err.println(url);
            return restTemplate.getForObject(url,String.class);
        }else {
            //名字为空请求一个不存在的地址
            String url = "http://provider/null";
            return restTemplate.getForObject(url,String.class);
        }

    }

    public String getDefaultUser(String name) {
        return "熔断，默认回调--名称是："+name;
    }

}
