package com.liquido.kafka.concurrentLimit.core.layer.impl;

import com.liquido.kafka.common.CaffeineWrapper;
import com.liquido.kafka.concurrentLimit.core.layer.ConcurrentLimitHandler;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * default concurrent limit handler which use the local cache caffeine
 */
@Component
@AllArgsConstructor
public class DefaultConcurrentLimitHandler implements ConcurrentLimitHandler {
    private final CaffeineWrapper caffeineWrapper;

    @Override
    public synchronized boolean limit(Object key, Integer limitCount, Object... param) {
        Integer currentCount = 1;
        if (caffeineWrapper.containsKey(caffeineWrapper)) {
            currentCount = caffeineWrapper.getObjCacheByKey(key, Integer.class);
            if (currentCount >= limitCount) {
                return true;
            } else {
                caffeineWrapper.putAndUpdateCache(key, currentCount + 1);
                return false;
            }
        }

        caffeineWrapper.putAndUpdateCache(key, currentCount);
        return false;

        // Add cache expiration tasks

    }

}
