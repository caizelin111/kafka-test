package com.liquido.kafka.concurrentLimit.algorithm.fixedWindow;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.joda.time.DateTime;

/**
 * second level time window calculator
 */
@AllArgsConstructor
@NoArgsConstructor
public class SecondWindowPointCalculator implements WindowPointCalculator {
    private Integer segment;


    @Override
    public Integer getPoint() {
        int second = DateTime.now().secondOfMinute().get();
        return second / segment;
    }

    @Override
    public Integer segmentTime() {
        return segment;
    }
}
