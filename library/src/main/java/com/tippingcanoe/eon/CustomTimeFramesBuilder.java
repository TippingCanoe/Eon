package com.tippingcanoe.eon;

import java.util.HashMap;

public class CustomTimeFramesBuilder {

    HashMap<TimeBuilder.TimeFrames, CustomTimeFrame> eonTimeUnitsMap;

    public CustomTimeFramesBuilder() {
        eonTimeUnitsMap = new HashMap<>();
    }

    public CustomTimeFramesBuilder millis(int shortResId, int medResId, int longResId) {
        eonTimeUnitsMap.put(TimeBuilder.TimeFrames.MILLISECOND, new CustomTimeFrame(TimeBuilder.TimeFrames.MILLISECOND, shortResId, medResId, longResId));
        return this;
    }

    public CustomTimeFramesBuilder seconds(int shortResId, int medResId, int longResId) {
        eonTimeUnitsMap.put(TimeBuilder.TimeFrames.SECOND, new CustomTimeFrame(TimeBuilder.TimeFrames.SECOND, shortResId, medResId, longResId));
        return this;
    }

    public CustomTimeFramesBuilder minutes(int shortResId, int medResId, int longResId) {
        eonTimeUnitsMap.put(TimeBuilder.TimeFrames.MINUTE, new CustomTimeFrame(TimeBuilder.TimeFrames.MINUTE, shortResId, medResId, longResId));
        return this;
    }

    public CustomTimeFramesBuilder hours(int shortResId, int medResId, int longResId) {
        eonTimeUnitsMap.put(TimeBuilder.TimeFrames.HOUR, new CustomTimeFrame(TimeBuilder.TimeFrames.HOUR, shortResId, medResId, longResId));
        return this;
    }

    public CustomTimeFramesBuilder days(int shortResId, int medResId, int longResId) {
        eonTimeUnitsMap.put(TimeBuilder.TimeFrames.DAY, new CustomTimeFrame(TimeBuilder.TimeFrames.DAY, shortResId, medResId, longResId));
        return this;
    }

    public CustomTimeFramesBuilder weeks(int shortResId, int medResId, int longResId) {
        eonTimeUnitsMap.put(TimeBuilder.TimeFrames.WEEK, new CustomTimeFrame(TimeBuilder.TimeFrames.WEEK, shortResId, medResId, longResId));
        return this;
    }

    public CustomTimeFramesBuilder months(int shortResId, int medResId, int longResId) {
        eonTimeUnitsMap.put(TimeBuilder.TimeFrames.MONTH, new CustomTimeFrame(TimeBuilder.TimeFrames.MONTH, shortResId, medResId, longResId));
        return this;
    }

    public CustomTimeFramesBuilder years(int shortResId, int medResId, int longResId) {
        eonTimeUnitsMap.put(TimeBuilder.TimeFrames.YEAR, new CustomTimeFrame(TimeBuilder.TimeFrames.YEAR, shortResId, medResId, longResId));
        return this;
    }

    public CustomTimeFrames build() {
        if (!eonTimeUnitsMap.containsKey(TimeBuilder.TimeFrames.MILLISECOND)) {
            throw new IllegalStateException("Missing time EonTimeUnit for milliseconds.");
        }
        if (!eonTimeUnitsMap.containsKey(TimeBuilder.TimeFrames.SECOND)) {
            throw new IllegalStateException("Missing time EonTimeUnit for seconds.");
        }
        if (!eonTimeUnitsMap.containsKey(TimeBuilder.TimeFrames.MINUTE)) {
            throw new IllegalStateException("Missing time EonTimeUnit for minutes.");
        }
        if (!eonTimeUnitsMap.containsKey(TimeBuilder.TimeFrames.HOUR)) {
            throw new IllegalStateException("Missing time EonTimeUnit for hours.");
        }
        if (!eonTimeUnitsMap.containsKey(TimeBuilder.TimeFrames.DAY)) {
            throw new IllegalStateException("Missing time EonTimeUnit for days.");
        }
        if (!eonTimeUnitsMap.containsKey(TimeBuilder.TimeFrames.WEEK)) {
            throw new IllegalStateException("Missing time EonTimeUnit for weeks.");
        }
        if (!eonTimeUnitsMap.containsKey(TimeBuilder.TimeFrames.MONTH)) {
            throw new IllegalStateException("Missing time EonTimeUnit for months.");
        }
        if (!eonTimeUnitsMap.containsKey(TimeBuilder.TimeFrames.YEAR)) {
            throw new IllegalStateException("Missing time EonTimeUnit for years.");
        }

        return new CustomTimeFrames(eonTimeUnitsMap.get(TimeBuilder.TimeFrames.MILLISECOND),
                eonTimeUnitsMap.get(TimeBuilder.TimeFrames.SECOND),
                eonTimeUnitsMap.get(TimeBuilder.TimeFrames.MINUTE),
                eonTimeUnitsMap.get(TimeBuilder.TimeFrames.HOUR),
                eonTimeUnitsMap.get(TimeBuilder.TimeFrames.DAY),
                eonTimeUnitsMap.get(TimeBuilder.TimeFrames.WEEK),
                eonTimeUnitsMap.get(TimeBuilder.TimeFrames.MONTH),
                eonTimeUnitsMap.get(TimeBuilder.TimeFrames.YEAR));
    }
}
