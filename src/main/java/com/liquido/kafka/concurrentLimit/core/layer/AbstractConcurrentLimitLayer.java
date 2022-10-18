package com.liquido.kafka.concurrentLimit.core.layer;


import com.liquido.kafka.concurrentLimit.algorithm.fixedWindow.FixedWindow;

/**
 * @author caizaelin
 * @date 2022/10/14
 */
public abstract class AbstractConcurrentLimitLayer implements ConcurrentLimitHandler, DowngradeHandlerStrategy {

    private static final String keyPattern = "%:%";


    /**
     * Execute the concurrent limiting main flow
     * <p> The first step is parameter pre-check, the secondstep is
     * current limit judgment, and the third step is current limit
     * compensation when exceed the threshold value
     *
     * @param businessKey
     * @param limitCount
     * @param fixedWindow
     * @param runnable
     */
    public void invokeConcurrentLimit(String businessKey, Integer limitCount, FixedWindow fixedWindow,
                                      Runnable runnable) {
        // todo pre check
        checkInParameter(businessKey, limitCount);

        try {
            // used fixedWindow algorithm generate key
            String key = String.format(keyPattern, businessKey, fixedWindow.getPoint());

            // whether to limit current
            if (!limit(key, limitCount, fixedWindow)) {
                // pass
                runnable.run();
                return;
            }
            // execute compensation strategy
            executeStrategy(runnable);

        } catch (Exception e) {
            // todo  can defined custom Exception

        } finally {
            // todo
        }

    }

    private void checkInParameter(String businessKey, Integer limitCount) {

    }

}
