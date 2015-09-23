package com.tippingcanoe.eon;

import android.content.Context;
import android.text.format.DateFormat;

import com.squareup.phrase.Phrase;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Eon {

    private static CustomTimeFrames customTimeFrames;

    public static void init(CustomTimeFrames timeFrames) {
        customTimeFrames = timeFrames;
    }

    public static List<String> getTimeUnits(Date origin, Length length, int maxUnits, boolean includeZeroUnits, TimeBuilder.TimeFrames smallestUnit, TimeBuilder.TimeFrames largestUnit, Context context) {

        long currentMs = System.currentTimeMillis();
        long originMs = origin.getTime();

        long differenceMs = currentMs - originMs;
        long runningDifferenceMs = Math.abs(differenceMs);

        List<String> units = new ArrayList<>();

        boolean hitLargest = false;

        // Work from largest timeframe to smallest.
        for (int i = TimeBuilder.TimeFrames.values().length - 1; i >= 0; i--) {
            TimeBuilder.TimeFrames timeFrame = TimeBuilder.TimeFrames.values()[i];

            if (timeFrame.equals(largestUnit)) {
                hitLargest = true;
            }

            if (hitLargest) {
                int wholeTimeFrameCount = (int) Math.floor(runningDifferenceMs / timeFrame.getMilliseconds());
                if (wholeTimeFrameCount > 0) {
                    units.add(getStringForTimeFrame(wholeTimeFrameCount, timeFrame, length, context));

                    runningDifferenceMs -= wholeTimeFrameCount * timeFrame.getMilliseconds();
                } else if (includeZeroUnits && units.size() != 0) {
                    units.add(getStringForTimeFrame(0, timeFrame, length, context));
                }
            }

            if (timeFrame.equals(smallestUnit)) {
                break;
            }

            if (units.size() >= maxUnits) {
                break;
            }
        }

        // Ensure there is a value.
        if (units.size() == 0) {
            units.add(getStringForTimeFrame(0, smallestUnit, length, context));
        }

        return units;
    }

    public static String getRelativeDate(Date origin, Length length, int maxUnits, boolean includeZeroUnits, boolean includePhrase, long maxMsForNonRelative, String unitSeparator, String finalUnitSeparator, TimeBuilder.TimeFrames smallestUnit, TimeBuilder.TimeFrames largestUnit, Context context) {
        long currentMs = System.currentTimeMillis();
        long originMs = origin.getTime();

        long differenceMs = currentMs - originMs;
        long runningDifferenceMs = Math.abs(differenceMs);

        if (runningDifferenceMs >= maxMsForNonRelative) {
            switch (length) {
                case LONG:
                    return DateFormat.getLongDateFormat(context).format(origin);
                case MEDIUM:
                    return DateFormat.getMediumDateFormat(context).format(origin);
                case SHORT:
                default:
                    return DateFormat.getDateFormat(context).format(origin);
            }
        } else {
            List<String> units = getTimeUnits(origin, length, maxUnits, includeZeroUnits, smallestUnit, largestUnit, context);

            String unitString = "";
            for (int i = 0; i < units.size(); i++) {
                if (!unitString.equals("")) {
                    if (i == units.size() - 1) {
                        unitString += finalUnitSeparator;
                    } else {
                        unitString += unitSeparator;
                    }
                }

                unitString += units.get(i);
            }

            if (includePhrase) {
                int phraseResourceId;
                if (differenceMs >= 0) {
                    phraseResourceId = R.string.eon_phrase_ago;
                } else {
                    phraseResourceId = R.string.eon_phrase_from_now;
                }

                return Phrase.from(context, phraseResourceId).put("time", unitString).format().toString();
            } else {
                return unitString;
            }
        }
    }

    private static String getStringForTimeFrame(int count, TimeBuilder.TimeFrames timeFrame, Length length, Context context) {

        // If we supplied our own custom time frames, then use those.
        if (customTimeFrames != null) {

            return count + " " + customTimeFrames.getTimeUnit(context, count, timeFrame, length);

        } else {

            // Use english default

            int pluralResourceId;

            switch (length) {
                case SHORT:
                    pluralResourceId = timeFrame.getShortResourceId();
                    break;
                case MEDIUM:
                    pluralResourceId = timeFrame.getMediumResourceId();
                    break;
                case LONG:
                default:
                    pluralResourceId = timeFrame.getLongResourceId();
                    break;
            }

            return count + " " + context.getResources().getQuantityString(pluralResourceId, count);
        }
    }

    public enum Length {
        SHORT,
        MEDIUM,
        LONG
    }
}
