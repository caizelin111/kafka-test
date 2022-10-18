package com.liquido.kafka.concurrentLimit.support.cache;

/**
 * @author caizelin
 * @date 2022/10/14
 */
public interface Cache {
    /**
     * add or update cache
     *
     * @param key
     * @param value
     */
    void putAndUpdateCache(Object key, Object value);


    /**
     * get value by key
     *
     * @param key
     * @return
     */
    <T> T getObjCacheByKey(Object key, Class<T> t);

    /**
     * del cache by key
     *
     * @param key
     */
    void removeCacheByKey(Object key);

    /**
     * adjust boolean contain key
     *
     * @param key
     * @return
     */
    boolean containsKey(Object key);
}
