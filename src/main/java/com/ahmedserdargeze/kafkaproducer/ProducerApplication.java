package com.ahmedserdargeze.kafkaproducer;

import com.ahmedserdargeze.kafkaproducer.model.Log;
import com.ahmedserdargeze.kafkaproducer.service.KafkaLogService;
import com.ahmedserdargeze.kafkaproducer.util.SpringBeanConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.core.KafkaTemplate;

import java.util.Timer;
import java.util.TimerTask;

@SpringBootApplication
public class ProducerApplication implements CommandLineRunner {
    @Autowired
    private KafkaTemplate<String, Log> kafkaTemplate;

    @Autowired
    @Qualifier(value = SpringBeanConstants.SERVICE_KAFKA_LOG)
    KafkaLogService kafkaLogService;

    private  String interval=System.getenv("LOG_INTERVAL");



    public static void main(String[] args) {
        SpringApplication.run(ProducerApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Timer timer = new Timer();
        if(interval != null && !interval.isEmpty()){
            timer.schedule(new LogWithInterval(), 0, Long.parseLong(interval));
        }else {
            timer.schedule(new LogWithInterval(), 0, 8000);
            System.out.println("error");
        }
    }

    class LogWithInterval extends TimerTask {
        public void run() {
            kafkaLogService.sendLogToKafka();
        }
    }



}
