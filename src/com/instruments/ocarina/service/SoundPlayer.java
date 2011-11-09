package com.instruments.ocarina.service;

import java.io.File;
import java.util.HashMap;

import com.instruments.ocarina.dao.ResourceRetriever;

import android.content.ContentResolver;
import android.media.*;
import android.net.Uri;

public class SoundPlayer {
	private SoundPool audioPlayer;
	private ResourceRetriever resourceGet;
	private HashMap<String, Integer> noteSounds;

	// These represent the state of the buttons in the UI
	// True = the button is depressed
	// False = the button is not depressed
	boolean keyOne;
	boolean keyTwo;
	boolean keyThree;
	boolean keyFour;
	boolean keyFive;

	/**
	 * Constructor for class. Also initializes the class vars.
	 * 
	 * @param cacheDir
	 *            File object containing path to cache directory to pass to
	 *            resource retriever.
	 */
	public SoundPlayer(File cacheDir, ContentResolver resolver) {
		resourceGet = new ResourceRetriever(cacheDir, resolver);
		audioPlayer = new SoundPool(1, AudioManager.STREAM_MUSIC, 0);
		noteSounds = loadAudioFiles();
	}

	/**
	 * Method to load audio file retrieved from ResourceRetriver into SoundPool.
	 * 
	 * @return returns HashMap of soundIDs for the loaded note WAVs.
	 */
	private HashMap<String, Integer> loadAudioFiles() {
		HashMap<String,Integer> audioFiles = new HashMap<String,Integer>();
		audioFiles.put("Do", audioPlayer.load(resourceGet.getResource(Uri.parse("android.resource://com.instruments.ocarina/raw/do")).getAbsolutePath(),1));
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
		return audioFiles;
	}
	
	/**
	 * Method to detect when a key has been depressed.
	 * 
	 * @param key
	 * 			Parameter representing the key that called the function.
	 */

	public void addKey(int key) {

		if (key == 1) {
			keyOne = true;
		} else if (key == 2) {
			keyTwo = true;
		} else if (key == 3) {
			keyThree = true;
		} else if (key == 4) {
			keyFour = true;
		} else if (key == 5) {
			keyFive = true;
		}

		this.setNote();
	}

	/**
	 * Method to detect when a key is no longer depressed.
	 * 
	 * @param key
	 * 			Parameter representing the key that called the function.
	 */
	
	public void removeKey(int key) {

		if (key == 1) {
			keyOne = false;
		} else if (key == 2) {
			keyTwo = false;
		} else if (key == 3) {
			keyThree = false;
		} else if (key == 4) {
			keyFour = false;
		} else if (key == 5) {
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
		} else {
			audioPlayer.stop(1);
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
