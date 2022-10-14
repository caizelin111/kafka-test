package com.liquido.kafka.concurrentLimit.core.factory;

import com.liquido.kafka.concurrentLimit.core.layer.impl.DefaultConcurrentLimitInvokeLayer;
import com.liquido.kafka.concurrentLimit.core.layer.AbstractConcurrentLimitLayer;
import com.liquido.kafka.concurrentLimit.core.layer.ConcurrentLimitHandler;
import com.liquido.kafka.concurrentLimit.core.layer.DowngradeHandlerStrategy;

/**
 * @author caizelin
 * @date 2022/10/14
 */
public class DefaultConcurrentLimitLayerFactory implements LayerFactory {

    private final ConcurrentLimitHandler concurrentLimitHandler;
    private final DowngradeHandlerStrategy downgradeHandlerStrategy;

    public DefaultConcurrentLimitLayerFactory(ConcurrentLimitHandler concurrentLimitHandler, DowngradeHandlerStrategy downgradeHandlerStrategy) {
        this.concurrentLimitHandler = concurrentLimitHandler;
        this.downgradeHandlerStrategy = downgradeHandlerStrategy;
    }

    @Override
    public AbstractConcurrentLimitLayer createLimitLayer() {
        return new DefaultConcurrentLimitInvokeLayer(concurrentLimitHandler, downgradeHandlerStrategy);
    }
}
