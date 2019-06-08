package com.ahmedgeze.producer.service;

import com.ahmedgeze.producer.model.Log;
import com.ahmedgeze.producer.model.LogLevelEnum;
import com.ahmedgeze.producer.util.SpringBeanConstants;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

@Service(value = SpringBeanConstants.SERVICE_KAFKA_LOG)
public class KafkaLogServiceImpl implements KafkaLogService {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    private ObjectMapper jacksonObjectMapper;


    private  String valueFromFile=System.getenv("HOST_IP");



    @Override
    public Log createRandomLog() {

        Random rn = new Random();
        int randomId = rn.nextInt(5) + 1;
        LogLevelEnum logLevelEnum = LogLevelEnum.getLogLevelEnumWithId(randomId);
        if (logLevelEnum != null) {
            Date date = new Date();
            SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
            Log log = new Log(formatter.format(date), logLevelEnum.getName(), this.valueFromFile, "logDetail");
            ObjectMapper mapper = new ObjectMapper();
            return log;


        }
        return null;

    }

    @Override
    public void sendLogToKafka() {
        Log log = createRandomLog();
        if (log != null) {
            try {
                kafkaTemplate.send("Topic1", jacksonObjectMapper.writeValueAsString(log));
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }

        }

    }
}
