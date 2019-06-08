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

    public static void main(String[] args) {
        SpringApplication.run(ProducerApplication.class, args
        );
    }

//    @Value("${value.from.file}")
//    private String valueFromFile;

    @Override
    public void run(String... args) throws Exception {
        try {
            for(int i = 0;i<100000;i++){
//                System.out.println(valueFromFile+"***********");
                kafkaTemplate.send("Topic1","deneme"+i);
            }

        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
