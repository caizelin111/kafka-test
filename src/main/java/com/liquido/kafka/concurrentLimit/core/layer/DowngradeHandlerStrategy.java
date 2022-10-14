package com.liquido.kafka.concurrentLimit.core.layer;

/**
 * @author caizelin
 * @date 2022/10/13
 */
public interface DowngradeHandlerStrategy {

    /**
     *
     * @param runnable
     */
    void executeStrategy(Runnable runnable, Object... params);
}
