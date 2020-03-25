package com.cloud.demo.consumer.controller;

import com.cloud.demo.consumer.bean.User;
import com.cloud.demo.consumer.rpc.GetHello;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class HiController {

    @Resource
    private GetHello getHello;

    @GetMapping("/test")
    public User getPostUser(User user){
        return getHello.getPostUser(user);
    }

}
