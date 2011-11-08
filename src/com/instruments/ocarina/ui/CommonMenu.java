package com.instruments.ocarina.ui;

import com.instruments.ocarina.R;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;

public class CommonMenu extends Activity {

	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{
		super.onCreateOptionsMenu(menu);
		
		// create and set the menu inflater
		getMenuInflater().inflate(R.menu.menu, menu);
		
		// returns true to display the menu
		return true;
	}

	
	@Override
	public boolean onOptionsItemSelected(MenuItem item)
	{
		super.onOptionsItemSelected(item);
		
		switch (item.getItemId())
		{
			case R.id.start	:
				launchActivity(Launcher.class);
				break;
			case R.id.classic:
				launchActivity(Classic.class);
				break;
			case R.id.fancy:
				launchActivity(Fancy.class);
				break;
		}
		return true;
	}
	
	
	/*
	 * Creates a new intent and starts the activity
	 */
	private void launchActivity(Class<?> c)
	{
		startActivity(new Intent(this, c));
	}
}
