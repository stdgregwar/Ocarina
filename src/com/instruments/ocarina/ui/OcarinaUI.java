package com.instruments.ocarina.ui;

import com.instruments.ocarina.service.ISoundPlayer;
import com.instruments.ocarina.service.SoundPlayer;
import android.os.Bundle;


/**
 * This abstract class contains common functionality between all of the different Ocarina GUIs
 * 
 */
public abstract class OcarinaUI extends CommonMenu {
	private ISoundPlayer soundPlayer;
	
	protected ISoundPlayer getSoundPlayer() { return this.soundPlayer; }
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		soundPlayer = new SoundPlayer(this.getCacheDir(), this.getContentResolver());
	}
	
}
