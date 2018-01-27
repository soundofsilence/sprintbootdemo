package com.example.demo;

import com.service.HelloSender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by Administrator on 2018/1/15.
 */
@RunWith(SpringRunner.class)
public class RabbitMqHelloTest {

    @Autowired
    private HelloSender helloSender;

    @Test
    public void hello() throws Exception{
        helloSender.send();
    }
}
