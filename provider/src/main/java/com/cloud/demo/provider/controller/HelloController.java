package com.cloud.demo.provider.controller;

import com.cloud.demo.provider.bean.User;
import com.cloud.demo.provider.service.HelloService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class HelloController {

    @Value("${server.port}")
    private int port;

    @Resource
    private HelloService helloService;

    @GetMapping("/hello")
    public String sayHello(String name){
        return "你好，cloud"+"name："+name+"port:"+port;
    }

    @PostMapping("/getPostUser")
    public User getPostUser(@RequestBody User user) throws InterruptedException {
        if (user.getId()!=1){
            System.err.println("1");
            return user;
        }else {
            Thread.sleep(10000L);//休息10秒
            return null;
        }

    }

    /**
     * 此处就可以看到，我是使用get请求发送，却用了post接收
     */
    @PostMapping("/getUser")
    public User getUser(@RequestBody User user){
        System.err.println("11");
        return user;
    }
}
