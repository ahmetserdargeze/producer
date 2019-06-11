package com.ahmedserdargeze.kafkaproducer.service;

import com.ahmedserdargeze.kafkaproducer.model.Log;
import com.ahmedserdargeze.kafkaproducer.model.LogLevelEnum;
import com.ahmedserdargeze.kafkaproducer.util.SpringBeanConstants;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

@Service(value = SpringBeanConstants.SERVICE_KAFKA_LOG)
public class KafkaLogServiceImpl implements KafkaLogService {



    @Autowired
    private KafkaTemplate<String, Log> kafkaTemplate;

    @Autowired
    private ObjectMapper jacksonObjectMapper;


    private  String valueFromFile=System.getenv("SERVER_CITY_NAME");



    @Override
    public Log  createRandomLog() {

        Random rn = new Random();
        int randomId = rn.nextInt(5) + 1;
        LogLevelEnum logLevelEnum = LogLevelEnum.getLogLevelEnumWithId(randomId);
        if (logLevelEnum != null) {
            Date date = new Date();
            SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
            Log log = new Log(formatter.format(date), logLevelEnum.getName(), this.valueFromFile, "logDetail");
            return log;


        }
        return null;

    }

    @Override
    public void sendLogToKafka() {
        Log log = createRandomLog();
        if (log != null) {
            Message<Log> message = MessageBuilder
                    .withPayload(log)
                    .setHeader(KafkaHeaders.TOPIC, "Topic1")
                    .build();
                kafkaTemplate.send( message);
        }

    }
}
