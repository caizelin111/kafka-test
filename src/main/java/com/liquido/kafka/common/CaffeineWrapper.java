package com.liquido.kafka.common;

import com.github.benmanes.caffeine.cache.Cache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


/**
 * a wrapper of CaffeineCache {@link CaffeineCacheConfig#cache()}
 *
 * @author caizelin
 * @date 2022/9/27
 */
@Component
public class CaffeineWrapper implements com.liquido.kafka.common.Cache {

    @Autowired
    private Cache<Object, Object> caffeineCache;

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
