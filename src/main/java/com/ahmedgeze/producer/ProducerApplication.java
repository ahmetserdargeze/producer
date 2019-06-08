package com.ahmedgeze.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.core.KafkaTemplate;

@SpringBootApplication
public class ProducerApplication implements CommandLineRunner {
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    private static String valueFromFile=System.getenv("HOST_IP");


    public static void main(String[] args) {
        System.out.println(valueFromFile+"***********");
        SpringApplication.run(ProducerApplication.class, args
        );
    }


    @Override
    public void run(String... args) throws Exception {
        try {
            for(int i = 0;i<20;i++){
//                System.out.println("*************"+valueFromFile+"***********");
                kafkaTemplate.send("Topic1","*******"+valueFromFile+"*****"+i);
            }

        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
