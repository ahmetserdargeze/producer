package com.ahmedserdargeze.kafkaproducer.model;

public enum LogLevelEnum {
    INFO_LEVEL("INFO", 1),
    WARN_LEVEL("WARN", 2),
    FATAL_LEVEL("FATAL", 3),
    DEBUG_LEVEL("DEBUG", 4),
    ERROR_LEVEL("ERROR", 5);

    private final String name;
    private final int id;


    private LogLevelEnum(String name, int id) {
        this.name = name;
        this.id = id;

    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public static LogLevelEnum getLogLevelEnumWithId(int id) {
        switch (id) {
            case 1:
                return INFO_LEVEL;
            case 2:
                return WARN_LEVEL;
            case 3:
                return FATAL_LEVEL;
            case 4:
                return DEBUG_LEVEL;
            case 5:
                return ERROR_LEVEL;

            default:
                return null;
        }


    }


}
