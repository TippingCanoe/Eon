package com.tippingcanoe.eon.sample;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import com.tippingcanoe.eon.Eon;
import com.tippingcanoe.eon.TimeBuilder;

import java.util.Date;

public class MainActivity extends ActionBarActivity {

	@Override
	protected void onCreate ( Bundle savedInstanceState ) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		Log.v("Eon", Eon.getRelativeDate(new Date(System.currentTimeMillis() + new TimeBuilder().withYears(0).withWeeks(3).withDays(2).withHours(1).withSeconds(20).getMs()), Eon.Length.SHORT, 1, false, true, new TimeBuilder().withYears(1).getMs(), ", ", " and ", TimeBuilder.TimeFrames.SECOND, TimeBuilder.TimeFrames.YEAR, this));
	}

	@Override
	public boolean onCreateOptionsMenu ( Menu menu ) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.menu_main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected ( MenuItem item ) {
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
