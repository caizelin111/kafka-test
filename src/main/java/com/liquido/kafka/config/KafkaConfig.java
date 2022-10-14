package com.liquido.kafka.config;

import com.liquido.kafka.errorHandler.CustomErrorHandler;
import com.liquido.kafka.factory.CustomerDefaultKafkaProducerFactory;
import com.liquido.kafka.interceptor.CustomerProducerInterceptors;
import com.liquido.kafka.support.KafkaCompensationHandler;
import com.liquido.kafka.service.RobotAlarm;
import org.apache.kafka.clients.producer.ProducerInterceptor;
import org.apache.kafka.common.TopicPartition;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.kafka.DefaultKafkaProducerFactoryCustomizer;
import org.springframework.boot.autoconfigure.kafka.KafkaAutoConfiguration;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.listener.CommonErrorHandler;
import org.springframework.kafka.listener.DeadLetterPublishingRecoverer;
import org.springframework.kafka.listener.DefaultErrorHandler;
import org.springframework.util.backoff.BackOff;
import org.springframework.util.backoff.FixedBackOff;

import java.util.List;

@EnableConfigurationProperties({KafkaProperties.class})
@AutoConfigureBefore(KafkaAutoConfiguration.class)
@Configuration
public class KafkaConfig {

    @Autowired
    private RobotAlarm robotAlarm;

    @Autowired
    private List<ProducerInterceptor<Object, Object>> interceptors;

    @Autowired
    private List<KafkaCompensationHandler> kafkaCompensationHandlers;

    private final KafkaProperties properties;

    public KafkaConfig(KafkaProperties properties) {
        this.properties = properties;
    }

    @Bean
    @ConditionalOnMissingBean({ProducerFactory.class})
    public ProducerFactory<?, ?> kafkaProducerFactory(ObjectProvider<DefaultKafkaProducerFactoryCustomizer> customizers) {
        DefaultKafkaProducerFactory<?, ?> factory = new CustomerDefaultKafkaProducerFactory(this.properties.buildProducerProperties(), new CustomerProducerInterceptors(interceptors, robotAlarm, kafkaCompensationHandlers));
        String transactionIdPrefix = this.properties.getProducer().getTransactionIdPrefix();
        if (transactionIdPrefix != null) {
            factory.setTransactionIdPrefix(transactionIdPrefix);
        }

        customizers.orderedStream().forEach((customizer) -> {
            customizer.customize(factory);
        });
        return factory;
    }


    @Bean
    @Primary
    public CommonErrorHandler errorHandler(KafkaTemplate<?, ?> kafkaTemplate) {
        // use our DLT topic generator, to send dead letter message to a common topic

        // create dead letter recover component
        DeadLetterPublishingRecoverer deadLetterPublishingRecoverer = new DeadLetterPublishingRecoverer(kafkaTemplate, (cr, e) ->
                new TopicPartition("czl1.DLT", cr.partition()));

        // config backoff, specify how many times kafka consumer consume fail or how long a single consuming takes will
        // trigger sending the dead letter message.
        BackOff backOff = new FixedBackOff(3000, 1);

        // use our DLT handler adapter, to send alarm or do log
        DefaultErrorHandler commonErrorHandler = new CustomErrorHandler(deadLetterPublishingRecoverer, backOff, robotAlarm);
        return commonErrorHandler;
    }

}