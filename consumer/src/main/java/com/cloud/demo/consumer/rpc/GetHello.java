package com.cloud.demo.consumer.rpc;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "provider",path = "gbq_provider")
public interface GetHello {

    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    String sayHello(@RequestParam("name")String name);
}
