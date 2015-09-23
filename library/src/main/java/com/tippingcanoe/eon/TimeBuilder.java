package com.tippingcanoe.eon;

public class TimeBuilder {
    final static long MS_IN_SEC = 1000;
    final static long MS_IN_MIN = MS_IN_SEC * 60;
    final static long MS_IN_HR = MS_IN_MIN * 60;
    final static long MS_IN_DAY = MS_IN_HR * 24;
    final static long MS_IN_WEEK = MS_IN_DAY * 7;
    final static long MS_IN_MONTH = MS_IN_DAY * 30;
    final static long MS_IN_YEAR = MS_IN_DAY * 365;
    static long currentMs;

    public TimeBuilder() {
        currentMs = 0l;
    }

    public TimeBuilder withMilliseconds(long milliseconds) {
        currentMs += milliseconds;
        return this;
    }

    public TimeBuilder withSeconds(long seconds) {
        currentMs += seconds * MS_IN_SEC;
        return this;
    }

    public TimeBuilder withMinutes(long minutes) {
        currentMs += minutes * MS_IN_MIN;
        return this;
    }

    public TimeBuilder withHours(long hours) {
        currentMs += hours * MS_IN_HR;
        return this;
    }

    public TimeBuilder withDays(long days) {
        currentMs += days * MS_IN_DAY;
        return this;
    }

    public TimeBuilder withWeeks(long weeks) {
        currentMs += weeks * MS_IN_WEEK;
        return this;
    }

    public TimeBuilder withMonths(long months) {
        currentMs += months * MS_IN_MONTH;
        return this;
    }

    public TimeBuilder withYears(long years) {
        currentMs += years * MS_IN_YEAR;
        return this;
    }

    public long getMs() {
        return currentMs;
    }

    public enum TimeFrames {
        MILLISECOND(1, R.plurals.eon_milliseconds_short, R.plurals.eon_milliseconds_med, R.plurals.eon_milliseconds),
        SECOND(MS_IN_SEC, R.plurals.eon_seconds_short, R.plurals.eon_seconds_med, R.plurals.eon_seconds),
        MINUTE(MS_IN_MIN, R.plurals.eon_minutes_short, R.plurals.eon_minutes_med, R.plurals.eon_minutes),
        HOUR(MS_IN_HR, R.plurals.eon_hours_short, R.plurals.eon_hours_med, R.plurals.eon_hours),
        DAY(MS_IN_DAY, R.plurals.eon_days_short, R.plurals.eon_days_med, R.plurals.eon_days),
        WEEK(MS_IN_WEEK, R.plurals.eon_weeks_short, R.plurals.eon_weeks_med, R.plurals.eon_weeks),
        MONTH(MS_IN_MONTH, R.plurals.eon_months_short, R.plurals.eon_months_med, R.plurals.eon_months),
        YEAR(MS_IN_YEAR, R.plurals.eon_years_short, R.plurals.eon_years_med, R.plurals.eon_years);

        long milliseconds;
        int shortResourceId;
        int mediumResourceId;
        int longResourceId;

        TimeFrames(long milliseconds, int shortResourceId, int mediumResourceId, int longResourceId) {
            this.milliseconds = milliseconds;
            this.shortResourceId = shortResourceId;
            this.mediumResourceId = mediumResourceId;
            this.longResourceId = longResourceId;
        }

        public long getMilliseconds() {
            return milliseconds;
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
    }
}
