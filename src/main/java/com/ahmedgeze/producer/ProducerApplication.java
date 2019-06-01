package com.ahmedgeze.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.core.KafkaTemplate;

@SpringBootApplication
public class ProducerApplication implements CommandLineRunner {
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public static void main(String[] args) {
        SpringApplication.run(ProducerApplication.class, args
        );
    }

    @Override
    public void run(String... args) throws Exception {
        kafkaTemplate.send("Topic1","deneme");
        System.out.println("---------************-------------************");

    }
}
