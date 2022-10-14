package com.liquido.kafka.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.listener.ErrorHandler;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class KafkaConsumer {
    private final Logger logger = LoggerFactory.getLogger(KafkaConsumer.class);

    @KafkaListener(topics = {"testInfoTopic"})
    public void onMessage1(List<ConsumerRecord<String, String>> consumerRecord, Acknowledgment acknowledgment) {
        logger.info("comsumerRecord ...", consumerRecord);
//        Optional<?> optional = Optional.ofNullable(consumerRecord.value());
//        System.out.println(0/0);
        System.out.println(0/0);
    acknowledgment.acknowledge();
    }

//    @KafkaListener(topics = {"czl.DLT"})
//    public void deadLetterConsumer(ConsumerRecord<?, ?> consumerRecord, Acknowledgment acknowledgment) {
//        logger.info("进入死信队列 ...", consumerRecord);
//        Optional<?> optional = Optional.ofNullable(consumerRecord.value());
//        System.out.println(0/0);
//        if (optional.isPresent()) {
//            Object msg = optional.get();
//            System.out.println(msg);
//        }
//        acknowledgment.acknowledge();
//        return;
////        logger.info("进入死信队列 ...", consumerRecord);
////        Optional<?> optional = Optional.ofNullable(consumerRecord.value());
////        System.out.println(0/0);
////        if (optional.isPresent()) {
////            Object msg = optional.get();
////            System.out.println(msg);
////        }
//    }
}
