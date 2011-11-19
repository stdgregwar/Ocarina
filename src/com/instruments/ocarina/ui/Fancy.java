package com.instruments.ocarina.ui;

import android.os.Bundle;
import com.instruments.ocarina.R;

/**
 * Fancy Ocarina UI
 *
 */
public class Fancy extends OcarinaUI {

	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.fancy);
		initializeOcarinaButton(R.id.ocarinaHole1);
		initializeOcarinaButton(R.id.ocarinaHole2);
		initializeOcarinaButton(R.id.ocarinaHole3);
		initializeOcarinaButton(R.id.ocarinaHole4);		
	}

	private void initializeOcarinaButton (int buttonID) {
		OcarinaButton button = (OcarinaButton) findViewById(buttonID);
		button.setSoundPlayer(super.getSoundPlayer());
	}
}
