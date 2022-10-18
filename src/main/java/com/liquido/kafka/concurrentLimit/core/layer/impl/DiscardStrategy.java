package com.liquido.kafka.concurrentLimit.core.layer.impl;

import com.liquido.kafka.concurrentLimit.core.layer.DowngradeHandlerStrategy;
import org.springframework.stereotype.Component;

/**
 * @author caizelin
 * @date 2022/10/13
 */
public class DiscardStrategy implements DowngradeHandlerStrategy {
    @Override
    public void executeStrategy(Runnable runnable, Object...  params) {
        // do nothing
        return;
    }
}
