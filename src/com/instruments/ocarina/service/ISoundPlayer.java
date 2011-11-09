package com.instruments.ocarina.service;

import com.instruments.ocarina.Keys;

public interface ISoundPlayer {

	/**
	 * Method to detect when a key has been depressed.
	 * 
	 * @param key
	 * 			Parameter representing the key that called the function.
	 */

	public abstract void addKey(Keys key);

	/**
	 * Method to detect when a key is no longer depressed.
	 * 
	 * @param key
	 * 			Parameter representing the key that called the function.
	 */

	public abstract void removeKey(Keys key);

}