package com.liquido.kafka.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.logging.Logger;

@Component
public class KafkaConsumer {
//    private final Logger logger = LoggerFactory.getLogger(KafkaConsumer.class);

    //不指定group，默认取yml里配置的
    @KafkaListener(topics = {"testInfoTopic"})
    public void onMessage1(ConsumerRecord<?, ?> consumerRecord) {
        Optional<?> optional = Optional.ofNullable(consumerRecord.value());
        if (optional.isPresent()) {
            Object msg = optional.get();
            System.out.println(msg);
        }
    }
}
