package com.instruments.ocarina.service;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Timer;

import android.net.Uri;

import com.instruments.ocarina.dao.IResourceRetriever;

public class SongPlayer {
	private IResourceRetriever resourceGet;
	private AutomationController controller;
	private Integer bpm;
	private Map<String,Timer> noteList;
	
	public SongPlayer() {
		//
	}
	
	public void playSong(Uri song) {
		noteList = decodeSong(resourceGet.getResource(song));
	}
	
	private Map<String,Timer> decodeSong(File songFile) {
		bpm = 0;//set value based on decoded value
		return new HashMap<String,Timer>();
	}
}
