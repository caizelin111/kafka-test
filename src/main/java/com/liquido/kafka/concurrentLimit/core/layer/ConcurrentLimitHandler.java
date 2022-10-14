package com.liquido.kafka.concurrentLimit.core.layer;

public interface ConcurrentLimitHandler {

    /**
     * whether to limit current
     * <p>
     * When the request reaches the current limiting threshold in a certain time window
     * For counting in the time window, use the local cache caffeine or distributed cache
     * Redis and so one
     *
     * @param key
     * @param limitCount
     * @return
     */
    boolean limit(Object key, Integer limitCount, Object... param);
}
