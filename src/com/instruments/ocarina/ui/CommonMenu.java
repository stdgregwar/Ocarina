package com.instruments.ocarina.ui;


import java.util.ArrayList;
import com.instruments.ocarina.R;
import com.instruments.ocarina.service.SongPlayer;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.view.Menu;
import android.view.MenuItem;

public class CommonMenu extends Activity {

	// this is to ensure we don't try to start the song player on the wrong activity 
	private String currentSimpleClassName;	
	protected void setCurrentSimpleClassName(String name) {
		currentSimpleClassName = name;
	}
	
	@SuppressWarnings("unused")
	private SongPlayer songPlayer;
	// list of buttons that we'll pass to the songPlayer
	protected ArrayList<OcarinaButton> buttonList;
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
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
				currentSimpleClassName = Launcher.class.getSimpleName();
				break;
			case R.id.classic:
				launchActivity(Classic.class);
				currentSimpleClassName = Classic.class.getSimpleName();
				break;
			case R.id.fancy:
				launchActivity(Fancy.class);
				currentSimpleClassName = Fancy.class.getSimpleName();
				break;
			case R.id.songplayer:
				if (currentSimpleClassName == Fancy.class.getSimpleName() || currentSimpleClassName == Classic.class.getSimpleName())
				{
					// instantiate song player object
					songPlayer = new SongPlayer(buttonList);
					songPlayer.playSong(Uri.parse(""));
				}
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
