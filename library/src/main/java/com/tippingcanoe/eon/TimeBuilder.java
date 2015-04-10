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

	public TimeBuilder () {
		currentMs = 0l;
	}

	public TimeBuilder withMilliseconds ( long milliseconds ) {
		currentMs += milliseconds;
		return this;
	}

	public TimeBuilder withSeconds ( long seconds ) {
		currentMs += seconds * MS_IN_SEC;
		return this;
	}

	public TimeBuilder withMinutes ( long minutes ) {
		currentMs += minutes * MS_IN_MIN;
		return this;
	}

	public TimeBuilder withHours ( long hours ) {
		currentMs += hours * MS_IN_HR;
		return this;
	}

	public TimeBuilder withDays ( long days ) {
		currentMs += days * MS_IN_DAY;
		return this;
	}

	public TimeBuilder withWeeks ( long weeks ) {
		currentMs += weeks * MS_IN_WEEK;
		return this;
	}

	public TimeBuilder withMonths ( long months ) {
		currentMs += months * MS_IN_MONTH;
		return this;
	}

	public TimeBuilder withYears ( long years ) {
		currentMs += years * MS_IN_YEAR;
		return this;
	}

	public long getMs () {
		return currentMs;
	}

	public enum TimeFrames {
		MILLISECOND(1, R.plurals.milliseconds_short, R.plurals.milliseconds_med, R.plurals.milliseconds),
		SECOND(MS_IN_SEC, R.plurals.seconds_short, R.plurals.seconds_med, R.plurals.seconds),
		MINUTE(MS_IN_MIN, R.plurals.minutes_short, R.plurals.minutes_med, R.plurals.minutes),
		HOUR(MS_IN_HR, R.plurals.hours_short, R.plurals.hours_med, R.plurals.hours),
		DAY(MS_IN_DAY, R.plurals.days_short, R.plurals.days_med, R.plurals.days),
		WEEK(MS_IN_WEEK, R.plurals.weeks_short, R.plurals.weeks_med, R.plurals.weeks),
		MONTH(MS_IN_MONTH, R.plurals.months_short, R.plurals.months_med, R.plurals.months),
		YEAR(MS_IN_YEAR, R.plurals.years_short, R.plurals.years_med, R.plurals.years);

		long milliseconds;
		int shortResourceId;
		int mediumResourceId;
		int longResourceId;

		TimeFrames ( long milliseconds, int shortResourceId, int mediumResourceId, int longResourceId ) {
			this.milliseconds = milliseconds;
			this.shortResourceId = shortResourceId;
			this.mediumResourceId = mediumResourceId;
			this.longResourceId = longResourceId;
		}

		public long getMilliseconds () {
			return milliseconds;
		}

		public int getShortResourceId () {
			return shortResourceId;
		}

		public int getMediumResourceId () {
			return mediumResourceId;
		}

		public int getLongResourceId () {
			return longResourceId;
		}
	}
}
