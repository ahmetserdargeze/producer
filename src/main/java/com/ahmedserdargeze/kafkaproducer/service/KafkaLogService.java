package com.ahmedserdargeze.kafkaproducer.service;


import com.ahmedserdargeze.kafkaproducer.model.Log;

public interface KafkaLogService {

    public Log createRandomLog();

    public void sendLogToKafka();


}
