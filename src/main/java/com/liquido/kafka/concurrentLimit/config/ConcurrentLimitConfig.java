package com.liquido.kafka.concurrentLimit.config;

import com.liquido.kafka.concurrentLimit.core.layer.impl.DefaultConcurrentLimitHandler;
import com.liquido.kafka.concurrentLimit.core.layer.impl.DiscardStrategy;
import com.liquido.kafka.concurrentLimit.core.factory.DefaultConcurrentLimitLayerFactory;
import com.liquido.kafka.concurrentLimit.core.factory.LayerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @author caizelin
 * @date 2022/10/14
 */
@Component
public class ConcurrentLimitConfig {
    @Autowired
    private DefaultConcurrentLimitHandler defaultConcurrentLimitHandler;

    @Autowired
    private DiscardStrategy discardStrategy;


    @Bean
    private LayerFactory defaultConcurrentLimitInvokeAdapter() {
        return new DefaultConcurrentLimitLayerFactory(defaultConcurrentLimitHandler, discardStrategy);
    }

}
