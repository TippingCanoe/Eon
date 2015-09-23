package com.tippingcanoe.eon;

import android.content.Context;

public final class CustomTimeFrames {

    final CustomTimeFrame millis;
    final CustomTimeFrame seconds;
    final CustomTimeFrame minutes;
    final CustomTimeFrame hours;
    final CustomTimeFrame days;
    final CustomTimeFrame weeks;
    final CustomTimeFrame months;
    final CustomTimeFrame years;

    protected CustomTimeFrames(CustomTimeFrame millis,
                               CustomTimeFrame seconds,
                               CustomTimeFrame minutes,
                               CustomTimeFrame hours,
                               CustomTimeFrame days,
                               CustomTimeFrame weeks,
                               CustomTimeFrame months,
                               CustomTimeFrame years) {
        this.millis = millis;
        this.seconds = seconds;
        this.minutes = minutes;
        this.hours = hours;
        this.days = days;
        this.weeks = weeks;
        this.months = months;
        this.years = years;
    }

    public String getTimeUnit(Context context, int count, TimeBuilder.TimeFrames timeFrame, Eon.Length length) {
        switch (timeFrame) {
            case MILLISECOND:
                return getTimeUnit(context, count, millis, length);
            case SECOND:
                return getTimeUnit(context, count, seconds, length);
            case MINUTE:
                return getTimeUnit(context, count, minutes, length);
            case HOUR:
                return getTimeUnit(context, count, hours, length);
            case DAY:
                return getTimeUnit(context, count, days, length);
            case WEEK:
                return getTimeUnit(context, count, weeks, length);
            case MONTH:
                return getTimeUnit(context, count, months, length);
            case YEAR:
                return getTimeUnit(context, count, years, length);
        }
        return null;
    }

    private String getTimeUnit(Context context, int count, CustomTimeFrame customTimeFrame, Eon.Length length) {

        switch (length) {
            case SHORT:
                return customTimeFrame.getShortString(context, count);
            case MEDIUM:
                return customTimeFrame.getMediumString(context, count);
            case LONG:
                return customTimeFrame.getLongString(context, count);
        }

        // Shouldn't ever happen
        return null;
    }
}
