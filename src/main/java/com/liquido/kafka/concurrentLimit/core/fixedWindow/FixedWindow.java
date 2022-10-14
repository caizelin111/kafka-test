package com.liquido.kafka.concurrentLimit.core.fixedWindow;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * current limiting time window enumeration
 */
@Getter
@AllArgsConstructor
public enum FixedWindow {

    /**
     * All time intervals divisible by 60 in seconds
     */
    SECOND_2(new SecondWindowPointCalculator(2)),
    SECOND_3(new SecondWindowPointCalculator(3)),
    SECOND_4(new SecondWindowPointCalculator(4)),
    SECOND_5(new SecondWindowPointCalculator(5)),
    SECOND_6(new SecondWindowPointCalculator(6)),
    SECOND_10(new SecondWindowPointCalculator(10)),
    SECOND_12(new SecondWindowPointCalculator(12)),
    SECOND_15(new SecondWindowPointCalculator(15)),
    SECOND_20(new SecondWindowPointCalculator(20)),
    SECOND_30(new SecondWindowPointCalculator(30)),

    /**
     * All time intervals divisible by 60 in minute
     */
    MINUTE_2(new MinuteWindowPointCalculator(2)),
    MINUTE_3(new MinuteWindowPointCalculator(3)),
    MINUTE_4(new MinuteWindowPointCalculator(4)),
    MINUTE_5(new MinuteWindowPointCalculator(5)),
    MINUTE_6(new MinuteWindowPointCalculator(6)),
    MINUTE_10(new MinuteWindowPointCalculator(10)),
    MINUTE_12(new MinuteWindowPointCalculator(12)),
    MINUTE_15(new MinuteWindowPointCalculator(15)),
    MINUTE_20(new MinuteWindowPointCalculator(20)),
    MINUTE_30(new MinuteWindowPointCalculator(30)),


    ;

    private final WindowPointCalculator windowPoint;

    public Integer getPoint() {
        return windowPoint.getPoint();
    }

    public Integer getSegmentTime() {
        return windowPoint.segmentTime();
    }
}
