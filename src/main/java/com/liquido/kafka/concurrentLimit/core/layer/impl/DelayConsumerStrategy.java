package com.liquido.kafka.concurrentLimit.core.layer.impl;

import com.liquido.kafka.concurrentLimit.core.layer.DowngradeHandlerStrategy;

/**
 * @author caizelin
 * @date 2022/10/13
 */
public class DelayConsumerStrategy implements DowngradeHandlerStrategy {
    @Override
    public void executeStrategy(Runnable runnable, Object... params) {
        // do something
    }
}
