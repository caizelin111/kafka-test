package com.liquido.kafka.concurrentLimit.core.factory;

import com.liquido.kafka.concurrentLimit.core.layer.impl.DefaultConcurrentLimitHandler;
import com.liquido.kafka.concurrentLimit.core.layer.impl.DefaultConcurrentLimitInvokeLayer;
import com.liquido.kafka.concurrentLimit.core.layer.AbstractConcurrentLimitLayer;
import com.liquido.kafka.concurrentLimit.core.layer.ConcurrentLimitHandler;
import com.liquido.kafka.concurrentLimit.core.layer.DowngradeHandlerStrategy;
import com.liquido.kafka.concurrentLimit.core.layer.impl.DiscardStrategy;

/**
 * @author caizelin
 * @date 2022/10/14
 */
public class DefaultConcurrentLimitLayerFactory implements LayerFactory {

    private final ConcurrentLimitHandler concurrentLimitHandler = new DefaultConcurrentLimitHandler();
    private final DowngradeHandlerStrategy downgradeHandlerStrategy = new DiscardStrategy();

    @Override
    public AbstractConcurrentLimitLayer createLimitLayer() {
        return new DefaultConcurrentLimitInvokeLayer(concurrentLimitHandler, downgradeHandlerStrategy);
    }
}
