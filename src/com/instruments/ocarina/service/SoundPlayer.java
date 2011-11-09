package com.instruments.ocarina.service;

import java.io.File;
import java.util.HashMap;
import com.instruments.ocarina.R;
import com.instruments.ocarina.dao.IResourceRetriever;
import android.content.ContentResolver;
import android.media.AudioManager;
import android.media.SoundPool;
import android.content.Context;
import android.media.*;
import android.net.Uri;
import com.instruments.ocarina.Keys;
import com.instruments.ocarina.dao.ResourceRetriever;

public class SoundPlayer implements ISoundPlayer {
	private SoundPool audioPlayer;
	private IResourceRetriever resourceGet;
	private HashMap<String, Integer> noteSounds;
	private Context context;

	// These represent the state of the buttons in the UI
	// True = the button is depressed
	// False = the button is not depressed
	boolean keyOne;
	boolean keyTwo;
	boolean keyThree;
	boolean keyFour;
	boolean keyFive;
	
	// int for tracking stream id
	int i = 0;

	/**
	 * Constructor for class. Also initializes the class vars.
	 * 
	 * @param cacheDir
	 *            File object containing path to cache directory to pass to
	 *            resource retriever.
	 */
	public SoundPlayer(File cacheDir, ContentResolver resolver, Context ct) {
		resourceGet = new ResourceRetriever(cacheDir, resolver);
		audioPlayer = new SoundPool(1, AudioManager.STREAM_MUSIC, 0);
		context = ct;
		noteSounds = loadAudioFiles();
	}

	/**
	 * Method to load audio file retrieved from ResourceRetriver into SoundPool.
	 * 
	 * @return returns HashMap of soundIDs for the loaded note WAVs.
	 */
	private HashMap<String, Integer> loadAudioFiles() {
		HashMap<String,Integer> audioFiles = new HashMap<String,Integer>();
		//To fix later
		/*audioFiles.put("Do", audioPlayer.load(resourceGet.getResource(Uri.parse("android.resource://com.instruments.ocarina/raw/do_low")).getAbsolutePath(),1));
		audioFiles.put("Fa#", audioPlayer.load(resourceGet.getResource(Uri.parse("android.resource://com.instruments.ocarina/raw/fa_sh")).getAbsolutePath(),1));
		audioFiles.put("Fa", audioPlayer.load(resourceGet.getResource(Uri.parse("android.resource://com.instruments.ocarina/raw/fa")).getAbsolutePath(),1));
		audioFiles.put("La#", audioPlayer.load(resourceGet.getResource(Uri.parse("android.resource://com.instruments.ocarina/raw/la_sh")).getAbsolutePath(),1));
		audioFiles.put("La", audioPlayer.load(resourceGet.getResource(Uri.parse("android.resource://com.instruments.ocarina/raw/la")).getAbsolutePath(),1));
		audioFiles.put("Mi", audioPlayer.load(resourceGet.getResource(Uri.parse("android.resource://com.instruments.ocarina/raw/mi")).getAbsolutePath(),1));
		audioFiles.put("Re", audioPlayer.load(resourceGet.getResource(Uri.parse("android.resource://com.instruments.ocarina/raw/re")).getAbsolutePath(),1));
		audioFiles.put("So#", audioPlayer.load(resourceGet.getResource(Uri.parse("android.resource://com.instruments.ocarina/raw/so_sh")).getAbsolutePath(),1));
		audioFiles.put("So", audioPlayer.load(resourceGet.getResource(Uri.parse("android.resource://com.instruments.ocarina/raw/so")).getAbsolutePath(),1));
		audioFiles.put("Ti", audioPlayer.load(resourceGet.getResource(Uri.parse("android.resource://com.instruments.ocarina/raw/ti")).getAbsolutePath(),1));
		audioFiles.put("Dohi", audioPlayer.load(resourceGet.getResource(Uri.parse("android.resource://com.instruments.ocarina/raw/dohi")).getAbsolutePath(),1));
		*/
		audioFiles.put("Do", audioPlayer.load(context,R.raw.do_low,1));
		audioFiles.put("Fa#", audioPlayer.load(context,R.raw.fa_sh,1));
		audioFiles.put("Fa", audioPlayer.load(context,R.raw.fa,1));
		audioFiles.put("La#", audioPlayer.load(context,R.raw.la_sh,1));
		audioFiles.put("La", audioPlayer.load(context,R.raw.la,1));
		audioFiles.put("Mi", audioPlayer.load(context,R.raw.mi,1));
		audioFiles.put("Re", audioPlayer.load(context,R.raw.re,1));
		audioFiles.put("So#", audioPlayer.load(context,R.raw.so_sh,1));
		audioFiles.put("So", audioPlayer.load(context,R.raw.so,1));
		audioFiles.put("Ti", audioPlayer.load(context,R.raw.ti,1));
		audioFiles.put("Dohi", audioPlayer.load(context,R.raw.dohi,1));
		return audioFiles;
	}
	
	/* (non-Javadoc)
	 * @see com.instruments.ocarina.service.ISoundPlayer#addKey(com.instruments.ocarina.Keys)
	 */

	public void addKey(Keys key) {

		if (key == Keys.ONE) {
			keyOne = true;
		} else if (key == Keys.TWO) {
			keyTwo = true;
		} else if (key == Keys.THREE) {
			keyThree = true;
		} else if (key == Keys.FOUR) {
			keyFour = true;
		} else if (key == Keys.FIVE) {
			keyFive = true;
		}

		this.setNote();
	}

	/* (non-Javadoc)
	 * @see com.instruments.ocarina.service.ISoundPlayer#removeKey(com.instruments.ocarina.Keys)
	 */
	
	public void removeKey(Keys key) {

		if (key == Keys.ONE) {
			keyOne = false;
		} else if (key == Keys.TWO) {
			keyTwo = false;
		} else if (key == Keys.THREE) {
			keyThree = false;
		} else if (key == Keys.FOUR) {
			keyFour = false;
		} else if (key == Keys.FIVE) {
			keyFive = false;
		}

		this.setNote();
	}

	/**
	 * Method to play specified soundID loaded in SoundPool.
	 * 
	 * @param soundID
	 *            ID of sound to play.
	 * @return ID of stream of playing sound. Can be used to control/stop sound.
	 */
	private void playSound(Integer soundID) {
		if (soundID != null) {
			audioPlayer.play(soundID, 1, 1, 1, -1, 1);
			
			// index to track stream id
			i++;
		} else {
			audioPlayer.stop(i);
		}
	}

	/**
	 * Method to play note sound based on buttons that are down.
	 * 
	 */

	private void setNote() {

		// This takes the state of the UI in terms of which buttons are
		// depressed
		// and translates that into what note to play.

		Integer soundID;

		if (keyOne && keyTwo && keyThree && keyFour) {
			// Do
			soundID = noteSounds.get("Do");
		} else if (keyOne && !keyTwo && keyThree && keyFour) {
			// Re
			soundID = noteSounds.get("Re");
		} else if (keyOne && keyTwo && keyThree && !keyFour) {
			// Mi
			soundID = noteSounds.get("Mi");
		} else if (keyOne && !keyTwo && keyThree && !keyFour) {
			// Fa
			soundID = noteSounds.get("Fa");
		} else if (!keyOne && keyTwo && keyThree && keyFour) {
			// Fa#
			soundID = noteSounds.get("Fa#");
		} else if (!keyOne && !keyTwo && keyThree && keyFour) {
			// So
			soundID = noteSounds.get("So");
		} else if (!keyOne && keyTwo && keyThree && !keyFour) {
			// So#
			soundID = noteSounds.get("So#");
		} else if (!keyOne && !keyTwo && keyThree && !keyFour) {
			// La
			soundID = noteSounds.get("La");
		} else if (!keyOne && !keyTwo && !keyThree && keyFour) {
			// La#
			soundID = noteSounds.get("La#");
		} else if (!keyOne && keyTwo && !keyThree && !keyFour) {
			// Ti
			soundID = noteSounds.get("Ti");
		} else if (!keyOne && !keyTwo && !keyThree && !keyFour && keyFive) {
			// Dohi
			soundID = noteSounds.get("Dohi");
		} else {
			// silence
			soundID = null;
		}

		// sound playing method will be called here

		this.playSound(soundID);

	}

}
