package com.ahmedgeze.producer.service;


import com.ahmedgeze.producer.model.Log;

public interface KafkaLogService {

    public Log createRandomLog();

    public void sendLogToKafka();


}
