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
	private Map<String,Notes> noteList;
	
	private enum Notes {
		QUARTER(4),HALF(2),WHOLE(1),EIGHTH(8);
		
		private Integer value;
		private Notes(Integer i){
			value=i;
		}
		public Integer getValue(){
			return value;
		}
		public void setValue(Integer i) {
			value=i;
		}
	}
	
	public SongPlayer() {
		//
	}
	
	public void playSong(Uri song) {
		noteList = decodeSong(resourceGet.getResource(song));
	}
	
	private Map<String,Notes> decodeSong(File songFile) {
		//set value of enums based on decoded bpm here
		return new HashMap<String,Notes>();
	}
}
