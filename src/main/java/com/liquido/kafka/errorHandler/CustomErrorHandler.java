package com.liquido.kafka.errorHandler;

import com.liquido.kafka.service.RobotAlarm;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.springframework.kafka.listener.ConsumerRecordRecoverer;
import org.springframework.kafka.listener.DefaultErrorHandler;
import org.springframework.kafka.listener.KafkaMessageListenerContainer;
import org.springframework.kafka.listener.MessageListenerContainer;
import org.springframework.util.backoff.BackOff;

import java.util.List;
@Slf4j
public class CustomErrorHandler extends DefaultErrorHandler {

    private RobotAlarm robotAlarm;
    public CustomErrorHandler(ConsumerRecordRecoverer recoverer, BackOff backOff, RobotAlarm robotAlarm) {
        super(recoverer, backOff);
        this.robotAlarm = robotAlarm;
    }


    @Override
    public void handleRecord(Exception thrownException, ConsumerRecord<?, ?> record, Consumer<?, ?> consumer, MessageListenerContainer container) {
        super.handleRecord(thrownException, record, consumer, container);
        log.info("handleRecord {}", record.value());
        robotAlarm.alarm();

    }

    @Override
    public void handleRemaining(Exception thrownException, List<ConsumerRecord<?, ?>> records, Consumer<?, ?> consumer, MessageListenerContainer container) {
        super.handleRemaining(thrownException, records, consumer, container);
        log.info("handleRemaining {}");
        robotAlarm.alarm();
    }

    @Override
    public void handleBatch(Exception thrownException, ConsumerRecords<?, ?> data, Consumer<?, ?> consumer, MessageListenerContainer container, Runnable invokeListener) {
        super.handleBatch(thrownException, data, consumer, container, invokeListener);
        robotAlarm.alarm();

    }

    @Override
    public void handleOtherException(Exception thrownException, Consumer<?, ?> consumer, MessageListenerContainer container, boolean batchListener) {
        super.handleOtherException(thrownException, consumer, container, batchListener);
        robotAlarm.alarm();

    }
}

// ??????????????????????????? ?????????
// ?????????????????????????????????????????????????????? ??????????????????????????????????????????????????? ????????????
//???????????????????????????????????????????????????
// ???????????????


