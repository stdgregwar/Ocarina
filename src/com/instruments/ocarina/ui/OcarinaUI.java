package com.instruments.ocarina.ui;

import com.instruments.ocarina.service.SoundPlayer;
import android.os.Bundle;


/**
 * This abstract class contains common functionality between all of the different Ocarina GUIs
 * 
 */
public abstract class OcarinaUI extends CommonMenu {
	// TODO: Refactor common Ocarina functionality from Fancy.java
	private SoundPlayer soundPlayer;
	
	protected SoundPlayer getSoundPlayer() { return this.soundPlayer; }
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		soundPlayer = new SoundPlayer(this.getCacheDir(), this.getContentResolver());
	}
	
}
