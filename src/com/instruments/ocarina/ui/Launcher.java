package com.instruments.ocarina.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.instruments.ocarina.R;


public class Launcher extends CommonMenu {

		@Override
		public void onCreate(Bundle savedInstanceState)
		{
			super.onCreate(savedInstanceState);
			setContentView(R.layout.main);
			
			initializeComponents();
		}

		private void initializeComponents() {
			// set listeners for the buttons to launch their respective activities
			Button btnClassic = (Button) findViewById(R.id.btnClassic);
			btnClassic.setOnClickListener(new BtnActivityLauncher(Classic.class));
			
			Button btnFancy = (Button) findViewById(R.id.btnFancy);
			btnFancy.setOnClickListener(new BtnActivityLauncher(Fancy.class));
			
		}
		
		
		/*
		 * Generic OnClickListener used for launching activities
		 */
		private class BtnActivityLauncher implements OnClickListener 
		{
			private Class<?> activityToLaunch;
			
			/**
			 * Overloaded constructor
			 * @param c
			 *	This class object is used to create an Intent that is passed to startActivity()
			 */
			public BtnActivityLauncher(Class<?> c)
			{
				activityToLaunch = c;
			}
			
			@Override
			public void onClick(View v) 
			{
				startActivity(new Intent(Launcher.this, activityToLaunch));
			}
		}
}
