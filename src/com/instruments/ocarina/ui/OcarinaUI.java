package com.instruments.ocarina.ui;

import android.app.Activity;

public abstract class OcarinaUI extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState);
	{
		super.onCreate(savedInstanceState);
		
		initialize();
	}
	
	
	private void initialize()
	{
		// initialize UI elements
	}
}