package com.liquido.kafka.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.ProducerInterceptor;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.springframework.stereotype.Service;

import java.util.Map;

@Slf4j
@Service
public class CustomerProducerInterceptor implements ProducerInterceptor<Object, Object> {
    @Override
    public ProducerRecord<Object, Object> onSend(ProducerRecord<Object, Object> record) {
        log.info("onSend 拦截器 1。。。。。");
        return record;
    }

    @Override
    public void onAcknowledgement(RecordMetadata metadata, Exception exception) {

    }

    @Override
    public void close() {

    }

    @Override
    public void configure(Map<String, ?> configs) {

    }
}
