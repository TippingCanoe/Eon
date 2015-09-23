package com.tippingcanoe.eon;

import android.content.Context;

public class CustomTimeFrame {

    TimeBuilder.TimeFrames timeUnit;
    int shortResourceId;
    int mediumResourceId;
    int longResourceId;

    CustomTimeFrame(TimeBuilder.TimeFrames timeUnit, int shortResourceId, int mediumResourceId, int longResourceId) {
        this.timeUnit = timeUnit;
        this.shortResourceId = shortResourceId;
        this.mediumResourceId = mediumResourceId;
        this.longResourceId = longResourceId;
    }

    public TimeBuilder.TimeFrames getTimeUnit() {
        return timeUnit;
    }

    public int getShortResourceId() {
        return shortResourceId;
    }

    public int getMediumResourceId() {
        return mediumResourceId;
    }

    public int getLongResourceId() {
        return longResourceId;
    }

    public String getShortString(Context context, int count) {
        return context.getResources().getQuantityString(shortResourceId, count);
    }

    public String getMediumString(Context context, int count) {
        return context.getResources().getQuantityString(mediumResourceId, count);
    }

    public String getLongString(Context context, int count) {
        return context.getResources().getQuantityString(longResourceId, count);
    }
}
