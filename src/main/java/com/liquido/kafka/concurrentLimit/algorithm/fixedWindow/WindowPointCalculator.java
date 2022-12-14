package com.liquido.kafka.concurrentLimit.algorithm.fixedWindow;

public interface WindowPointCalculator {
    /**
     * calculate the coordinate points in the current limiting window
     * @return
     */
    Integer getPoint();

    /**
     * acquire current limiting window segment time
     * @return
     */
    Integer segmentTime();
}
