package com.liquido.kafka.concurrentLimit.support.cache;

import com.github.benmanes.caffeine.cache.Cache;
import com.liquido.kafka.concurrentLimit.support.cache.CaffeineCacheConfig;
import org.springframework.stereotype.Component;


/**
 * a wrapper of CaffeineCache {@link CaffeineCacheConfig#cache()}
 *
 * @author caizelin
 * @date 2022/9/27
 */
public class CaffeineWrapper implements com.liquido.kafka.concurrentLimit.support.cache.Cache {

    private final Cache<Object, Object> caffeineCache = CaffeineCacheConfig.cache();

    @Override
    public void putAndUpdateCache(Object key, Object value) {
        caffeineCache.put(key, value);

    }

    @Override
    public <T> T getObjCacheByKey(Object key, Class<T> t) {
        return (T) caffeineCache.asMap().get(key);
    }

    @Override
    public void removeCacheByKey(Object key) {
        caffeineCache.asMap().remove(key);

    }

    @Override
    public boolean containsKey(Object key) {
        return caffeineCache.asMap().containsKey(key);
    }
}
