package com.cloud.demo.consumer.comment;

import com.cloud.demo.consumer.bean.User;
import com.cloud.demo.consumer.rpc.GetHello;
import org.springframework.stereotype.Component;

@Component
public class UserFeignClientFallback implements  GetHello{

    @Override
    public User getPostUser(User user) {
        return new User(1,"用户1");
    }
}
