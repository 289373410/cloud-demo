package com.cloud.demo.consumer.rpc;

import com.cloud.demo.consumer.bean.User;
import com.cloud.demo.consumer.comment.UserFeignClientFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "provider",fallback = UserFeignClientFallback.class)
//@FeignClient(name = "provider")
public interface GetHello {
    //坑二 传递值必须使用对应注解
    @RequestMapping(value = "/getPostUser",method = RequestMethod.POST)
    User getPostUser(@RequestBody User user);

}

