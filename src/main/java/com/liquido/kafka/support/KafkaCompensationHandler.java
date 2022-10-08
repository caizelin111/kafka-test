package com.liquido.kafka.support;

public interface KafkaCompensationHandler {
    void handle(Object obj);
}
