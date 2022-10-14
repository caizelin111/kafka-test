package com.liquido.kafka.concurrentLimit.core.factory;

import com.liquido.kafka.concurrentLimit.core.layer.AbstractConcurrentLimitLayer;

/**
 * concurrent limiting layer factory
 *
 * @author caizelin
 * @date 2022/10/14
 */
public interface LayerFactory {

    /**
     * create concurrent limit layer by factory
     *
     * @return {@link AbstractConcurrentLimitLayer}
     */
    AbstractConcurrentLimitLayer createLimitLayer();

}
