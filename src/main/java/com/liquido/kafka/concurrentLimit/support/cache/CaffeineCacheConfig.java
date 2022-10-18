package com.liquido.kafka.concurrentLimit.support.cache;

import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.TimeUnit;

public class CaffeineCacheConfig {

    public static Cache<Object, Object> cache() {
        return Caffeine.newBuilder()
                .initialCapacity(10)
                .maximumSize(200)
                .expireAfterWrite(10, TimeUnit.MINUTES).build();
    }
}