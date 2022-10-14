package com.liquido.kafka.concurrentLimit.core.layer.impl;


import com.liquido.kafka.concurrentLimit.core.layer.AbstractConcurrentLimitLayer;
import com.liquido.kafka.concurrentLimit.core.layer.ConcurrentLimitHandler;
import com.liquido.kafka.concurrentLimit.core.layer.DowngradeHandlerStrategy;

/**
 * @author caizelin
 * @date 2022/10/14
 */
public class DefaultConcurrentLimitInvokeLayer extends AbstractConcurrentLimitLayer {
    private final ConcurrentLimitHandler concurrentLimitHandler;
    private final DowngradeHandlerStrategy downgradeHandlerStrategy;

    public DefaultConcurrentLimitInvokeLayer(ConcurrentLimitHandler concurrentLimitHandler, DowngradeHandlerStrategy downgradeHandlerStrategy) {
        this.concurrentLimitHandler = concurrentLimitHandler;
        this.downgradeHandlerStrategy = downgradeHandlerStrategy;
    }


    @Override
    public boolean limit(Object key, Integer limitCount, Object... param) {
        //  do something such as interceptors
        return concurrentLimitHandler.limit(key, limitCount, param);
    }

    @Override
    public void executeStrategy(Runnable runnable, Object... params) {
        // do something here
        downgradeHandlerStrategy.executeStrategy(runnable, params);
    }
}
