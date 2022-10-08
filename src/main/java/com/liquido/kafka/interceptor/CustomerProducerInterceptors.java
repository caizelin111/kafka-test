package com.liquido.kafka.interceptor;

import com.liquido.kafka.support.KafkaCompensationHandler;
import com.liquido.kafka.service.RobotAlarm;
import org.apache.kafka.clients.producer.ProducerInterceptor;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.internals.ProducerInterceptors;
import org.apache.kafka.common.TopicPartition;

import java.util.List;

public class CustomerProducerInterceptors extends ProducerInterceptors<Object,Object> {
    private final List<ProducerInterceptor<Object, Object>> interceptors;
    private final RobotAlarm robotAlarm;
    private final List<KafkaCompensationHandler> kafkaCompensationHandlers;

    public CustomerProducerInterceptors(List<ProducerInterceptor<Object, Object>> interceptors, RobotAlarm robotAlarm, List<KafkaCompensationHandler> kafkaCompensationHandlers) {
        super(interceptors);
        this.interceptors = interceptors;
        this.robotAlarm = robotAlarm;
        this.kafkaCompensationHandlers = kafkaCompensationHandlers;
    }

    @Override
    public ProducerRecord<Object, Object> onSend(ProducerRecord<Object, Object> record) {
        Object value = record.value();
        if(value instanceof String) {
            // 做一些处理
        }
        return super.onSend(record);
    }

    @Override
    public void onSendError(ProducerRecord<Object, Object> record, TopicPartition interceptTopicPartition, Exception exception) {
        // 告警
        robotAlarm.alarm();

        if(kafkaCompensationHandlers.size()>0) {
            // 补偿机制
            for (KafkaCompensationHandler kafkaCompensationHandler : kafkaCompensationHandlers) {
                kafkaCompensationHandler.handle(record);
            }
        }

        super.onSendError(record, interceptTopicPartition, exception);
    }
}

