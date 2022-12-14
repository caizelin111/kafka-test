package com.liquido.kafka.factory;

import com.liquido.kafka.interceptor.CustomerProducerInterceptors;
import lombok.SneakyThrows;
import org.apache.kafka.clients.KafkaClient;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.internals.ProducerInterceptors;
import org.apache.kafka.clients.producer.internals.ProducerMetadata;
import org.apache.kafka.common.serialization.Serializer;
import org.apache.kafka.common.utils.Time;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.ProducerPostProcessor;

import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;

import static org.apache.kafka.clients.producer.ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG;
import static org.apache.kafka.clients.producer.ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG;

public class CustomerDefaultKafkaProducerFactory extends DefaultKafkaProducerFactory<Object, Object> {

    // 设为final的好处是什么？
    private final CustomerProducerInterceptors interceptors;

    public CustomerDefaultKafkaProducerFactory(Map configs, CustomerProducerInterceptors interceptors) {
        super(configs);
        this.interceptors = interceptors;
    }

    @SneakyThrows
    @Override
    protected Producer createRawProducer(Map rawConfigs) {

        Constructor<KafkaProducer> declaredConstructor = KafkaProducer.class.getDeclaredConstructor(
                ProducerConfig.class,
                Serializer.class,
                Serializer.class,
                ProducerMetadata.class,
                KafkaClient.class,
                ProducerInterceptors.class, Time.class);

        declaredConstructor.setAccessible(true);
        Serializer<Object> keySerializer = super.getKeySerializerSupplier().get();
        Serializer<Object> valueSerializer = super.getValueSerializerSupplier().get();
        KafkaProducer kafkaProducer =
                declaredConstructor.newInstance(new ProducerConfig(appendSerializerToConfig(rawConfigs, keySerializer, valueSerializer)),
                        keySerializer, valueSerializer, null, null, interceptors, Time.SYSTEM);
        for (ProducerPostProcessor<Object, Object> pp : super.getPostProcessors()) {
            kafkaProducer = (KafkaProducer) pp.apply(kafkaProducer);
        }

        return kafkaProducer;
    }


    // todo 默认的静态方法在其他包也调用不了？？？
    private Map<String, Object> appendSerializerToConfig(Map<String, Object> configs,
                                                         Serializer<?> keySerializer,
                                                         Serializer<?> valueSerializer) {
        Map<String, Object> newConfigs = new HashMap<>(configs);
        if (keySerializer != null)
            newConfigs.put(KEY_SERIALIZER_CLASS_CONFIG, keySerializer.getClass());
        if (valueSerializer != null)
            newConfigs.put(VALUE_SERIALIZER_CLASS_CONFIG, valueSerializer.getClass());
        return newConfigs;
    }
}