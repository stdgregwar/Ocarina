package com.instruments.ocarina.ui;

import android.os.Bundle;

import com.instruments.ocarina.Keys;
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
		initializeOcarinaButton(R.id.ocarinaHole1, Keys.ONE);
		initializeOcarinaButton(R.id.ocarinaHole2, Keys.TWO);
		initializeOcarinaButton(R.id.ocarinaHole3, Keys.THREE);
		initializeOcarinaButton(R.id.ocarinaHole4, Keys.FOUR);		
	}

	private void initializeOcarinaButton (int buttonID, Keys key) {
		OcarinaButton button = (OcarinaButton) findViewById(buttonID);
		button.setSoundPlayer(super.getSoundPlayer());
		button.setKey(key);
	}
}
