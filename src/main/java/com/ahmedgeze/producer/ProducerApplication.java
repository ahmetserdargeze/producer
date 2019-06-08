package com.ahmedgeze.producer;

import com.ahmedgeze.producer.service.KafkaLogService;
import com.ahmedgeze.producer.util.SpringBeanConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.core.KafkaTemplate;

import java.util.Timer;
import java.util.TimerTask;

@SpringBootApplication
public class ProducerApplication implements CommandLineRunner {
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    @Qualifier(value = SpringBeanConstants.SERVICE_KAFKA_LOG)
    KafkaLogService kafkaLogService;



    public static void main(String[] args) {
        SpringApplication.run(ProducerApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Timer timer = new Timer();
        timer.schedule(new SayHello(), 0, 5400);
    }

    class SayHello extends TimerTask {
        public void run() {
            kafkaLogService.sendLogToKafka();
        }
    }



}
