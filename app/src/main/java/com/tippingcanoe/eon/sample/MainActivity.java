package com.tippingcanoe.eon.sample;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.tippingcanoe.eon.CustomTimeFramesBuilder;
import com.tippingcanoe.eon.Eon;
import com.tippingcanoe.eon.TimeBuilder;

import java.util.Date;

public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CustomTimeFramesBuilder builder = new CustomTimeFramesBuilder()
                .millis(R.plurals.milliseconds_short, R.plurals.milliseconds_med, R.plurals.milliseconds)
                .seconds(R.plurals.seconds_short, R.plurals.seconds_med, R.plurals.seconds)
                .minutes(R.plurals.minutes_short, R.plurals.minutes_med, R.plurals.minutes)
                .hours(R.plurals.hours_short, R.plurals.hours_med, R.plurals.hours)
                .days(R.plurals.days_short, R.plurals.days_med, R.plurals.days)
                .weeks(R.plurals.weeks_short, R.plurals.weeks_med, R.plurals.weeks)
                .months(R.plurals.months_short, R.plurals.months_med, R.plurals.months)
                .years(R.plurals.years_short, R.plurals.years_med, R.plurals.years);

        Eon.init(builder.build());

        Log.v("Eon", Eon.getRelativeDate("Reported {eon}, and {eon} ago.",
                new Date(System.currentTimeMillis() - new TimeBuilder().withYears(0).withWeeks(3).withDays(2).withHours(1).withSeconds(20).getMs()),
                Eon.Length.LONG,
                false,
                TimeBuilder.TimeFrames.SECOND,
                TimeBuilder.TimeFrames.YEAR,
                this));

        Log.v("Eon", Eon.getRelativeDate(new Date(System.currentTimeMillis() - new TimeBuilder().withYears(0).withWeeks(3).withDays(2).withHours(1).withSeconds(20).getMs()),
                Eon.Length.LONG,
                3,
                false,
                true,
                new TimeBuilder().withYears(1).getMs(),
                ", ",
                " and ",
                TimeBuilder.TimeFrames.SECOND,
                TimeBuilder.TimeFrames.YEAR,
                this));

        Log.v("Eon", Eon.getRelativeDate(new Date(System.currentTimeMillis() - new TimeBuilder().withYears(0).withWeeks(3).withDays(2).withHours(1).withSeconds(20).getMs()),
                Eon.Length.LONG,
                3,
                false,
                false,
                new TimeBuilder().withYears(1).getMs(),
                ", ",
                " and ",
                TimeBuilder.TimeFrames.SECOND,
                TimeBuilder.TimeFrames.YEAR,
                this));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
