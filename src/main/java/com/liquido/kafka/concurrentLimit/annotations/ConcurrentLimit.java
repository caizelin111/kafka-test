package com.liquido.kafka.concurrentLimit.annotations;


import com.liquido.kafka.concurrentLimit.algorithm.fixedWindow.FixedWindow;
import com.liquido.kafka.concurrentLimit.core.layer.ConcurrentLimitHandler;
import com.liquido.kafka.concurrentLimit.core.layer.impl.DefaultConcurrentLimitHandler;
import com.liquido.kafka.concurrentLimit.core.layer.impl.DiscardStrategy;
import com.liquido.kafka.concurrentLimit.core.layer.DowngradeHandlerStrategy;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ConcurrentLimit {

    /**
     * concurrent limit business key which must follow SpringEL expression rule
     * @return
     */
    String key() default "";


    /**
     * current limiting fixed window
     * @return
     */
    FixedWindow fixedWindow() ;


    /**
     * current limiting times in fixed window
     * @return
     */
    int limitCount();


    /**
     * current limiting handler in fixed window
     * @return
     */
    Class <? extends ConcurrentLimitHandler> currentLimitHandler() default DefaultConcurrentLimitHandler.class;


    /**
     * degraded policy handling after current limiting
     */
    Class<? extends DowngradeHandlerStrategy> downgradeHandlerStrategy() default DiscardStrategy.class;

}
