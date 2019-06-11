package com.ahmedserdargeze.kafkaproducer.model;

public class Log {
    private String date;
    private String logLevel;
    private String city;
    private String logDetail;

    public Log() {
    }

    public Log(String date, String logLevel, String city, String logDetail) {
        this.date = date;
        this.logLevel = logLevel;
        this.city = city;
        this.logDetail = logDetail;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getLogLevel() {
        return logLevel;
    }

    public void setLogLevel(String logLevel) {
        this.logLevel = logLevel;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getLogDetail() {
        return logDetail;
    }

    public void setLogDetail(String logDetail) {
        this.logDetail = logDetail;
    }


    @Override
    public String toString() {
        return "Log{" +
                "date='" + date + '\'' +
                ", logLevel='" + logLevel + '\'' +
                ", city='" + city + '\'' +
                ", logDetail='" + logDetail + '\'' +
                '}';
    }
}
