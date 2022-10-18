package com.liquido.kafka.exceptions;

import org.apache.kafka.clients.consumer.ConsumerRecord;

import java.util.Collections;
import java.util.List;

public class BizException extends Exception{
    private final List<ConsumerRecord<?, ?>> recordList;

    public BizException(String message) {
        super(message);
        this.recordList = Collections.emptyList();
    }

    public BizException( List<ConsumerRecord<?, ?>> recordList, String message) {
        super(message);
        this.recordList = recordList;
    }

}
