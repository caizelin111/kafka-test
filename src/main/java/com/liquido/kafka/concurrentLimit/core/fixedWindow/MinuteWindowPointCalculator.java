package com.liquido.kafka.concurrentLimit.core.fixedWindow;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.joda.time.DateTime;

/**
 * minute level time window calculator
 */
@AllArgsConstructor
@NoArgsConstructor
public class MinuteWindowPointCalculator implements WindowPointCalculator {
    private Integer segment;

    @Override
    public Integer getPoint() {
        int minute = DateTime.now().getMinuteOfHour();
        return minute / segment;
    }

    @Override
    public Integer segmentTime() {
        return segment * 60;
    }
}
