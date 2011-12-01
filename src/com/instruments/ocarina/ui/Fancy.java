package com.instruments.ocarina.ui;

import java.util.ArrayList;

import android.os.Bundle;

import com.instruments.ocarina.Keys;
import com.instruments.ocarina.R;

/**
 * Fancy Ocarina UI
 *
 */
public class Fancy extends OcarinaUI {

	
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		buttonList = new ArrayList<OcarinaButton>();
		
		setContentView(R.layout.fancy);
		buttonList.add(initializeOcarinaButton(R.id.ocarinaHoleTopLeft, Keys.ONE));
		buttonList.add(initializeOcarinaButton(R.id.ocarinaHoleTopRight, Keys.TWO));
		buttonList.add(initializeOcarinaButton(R.id.ocarinaHoleBottomLeft, Keys.THREE));
		buttonList.add(initializeOcarinaButton(R.id.ocarinaHoleBottomRight, Keys.FOUR));
		buttonList.add(initializeOcarinaButton(R.id.ocarinaBlowHole, Keys.FIVE));
	}

	private OcarinaButton initializeOcarinaButton (int buttonID, Keys key) {
		OcarinaButton button;
		// cast to correct type
		if (key == Keys.FIVE) {
			button = (BlowHole) findViewById(buttonID);
		} else {
			button = (FingerHole) findViewById(buttonID);
		}
		button.setSoundPlayer(super.getSoundPlayer());
		button.setKey(key);
		
		return button;
	}
}
