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
		initializeOcarinaButton(R.id.ocarinaBlowHole, Keys.ONE);
		initializeOcarinaButton(R.id.ocarinaHoleTopLeft, Keys.TWO);
		initializeOcarinaButton(R.id.ocarinaHoleTopRight, Keys.THREE);
		initializeOcarinaButton(R.id.ocarinaHoleBottomLeft, Keys.FOUR);
		initializeOcarinaButton(R.id.ocarinaHoleBottomRight, Keys.FIVE);
	}

	private void initializeOcarinaButton (int buttonID, Keys key) {
		OcarinaButton button;
		// cast to correct type
		if (key == Keys.ONE) {
			button = (BlowHole) findViewById(buttonID);
		} else {
			button = (FingerHole) findViewById(buttonID);
		}
		button.setSoundPlayer(super.getSoundPlayer());
		button.setKey(key);
	}
}
