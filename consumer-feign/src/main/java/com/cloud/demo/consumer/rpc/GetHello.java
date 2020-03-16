package com.cloud.demo.consumer.rpc;

import com.cloud.demo.consumer.bean.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "provider",path = "gbq_provider")
//@FeignClient(name = "provider")
public interface GetHello {

    //坑一
    //@GetMapping 不支持
    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    String sayHello(@RequestParam("name")String name);

    //坑二 传递值必须使用对应注解
    @RequestMapping(value = "/getPostUser",method = RequestMethod.POST)
    User getPostUser(@RequestBody User user);

    //坑三 传递参数为复杂参数是请求方式即便设置为get，但任然以post请求发送
    @RequestMapping(value = "/getUser",method = RequestMethod.GET)
    User getUser(@RequestBody User user);
}
