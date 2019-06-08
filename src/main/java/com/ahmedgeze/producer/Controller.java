package com.ahmedgeze.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;


    @RequestMapping(value = "/deneme")
    public void sendmessage(){
        kafkaTemplate.send("Topic1","deneme");
        System.out.println("aaaaaaaa");

    }

}
