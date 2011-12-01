package com.instruments.ocarina.service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import android.net.Uri;

import com.instruments.ocarina.dao.IResourceRetriever;

public class SongPlayer {
	private IResourceRetriever resourceGet;
	private AutomationController controller;
	private Note note;
	private List<Note> noteList;
	private int index;
	private Timer timer = new Timer();
	private long delay;
	private Notes divisor;
	private NoteTask task;
	
	public enum Notes {
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
	
	public void playSong(Uri song) {
		noteList = decodeSong(resourceGet.getResource(song));
		index = 0;
		
		this.nextNote();
	}
	
	private void nextNote(){
		note = noteList.get(index);
		divisor = note.getNoteType();
		delay = 1000/divisor.getValue();
		
		controller.setCue(note.getPitch());
		
		index++;
		if(!(index>noteList.size())){
			//start show button light up here
			timer.schedule(task, delay);
		}
	}
	
	
	
	class NoteTask extends TimerTask {
		public void run(){
			//end show button light up here
			nextNote();
			timer.cancel();
		}
	}
	
	private List<Note> decodeSong(File songFile) {
		//set value of enums based on decoded bpm here
		String pitch;
		Notes nt;
		return new ArrayList<Note>();
	}
}
