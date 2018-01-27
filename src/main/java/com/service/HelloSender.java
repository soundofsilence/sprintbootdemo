package com.service;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
/**
 * Created by Administrator on 2018/1/15.
 */
@Component
public class HelloSender {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void send(){
        String context = "hello"+new Date();
        System.out.println("Sender:"+context);
        this.rabbitTemplate.convertAndSend("hello",context);
    }
}
