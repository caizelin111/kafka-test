package com.liquido.kafka.common;

import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.TimeUnit;

@Configuration
public class CaffeineCacheConfig {

    @Bean
    public Cache<Object, Object> cache() {
        return Caffeine.newBuilder()
                .initialCapacity(10)
                .maximumSize(200)
                .expireAfterWrite(10, TimeUnit.MINUTES).build();
    }
}