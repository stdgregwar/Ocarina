package com.instruments.ocarina.service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import android.net.Uri;

import com.instruments.ocarina.dao.IResourceRetriever;
import com.instruments.ocarina.ui.OcarinaButton;

public class SongPlayer {
	private IResourceRetriever resourceGet;
	private AutomationController controller;
	private Note note;
	private List<Note> noteList;
	private int index;
	private Timer timer = new Timer();
	private long delay;
	private NoteTask task;
	
	public SongPlayer(ArrayList<OcarinaButton> buttons){
		controller = new AutomationController(buttons);
	}
	
	public enum Note {
		QUARTER(4),HALF(2),WHOLE(1),EIGHTH(8);
		
		private Integer type;
		private String pitch;
		private Note(Integer i){
			type=i;
		}
		public Integer getNoteType(){
			return type;
		}
		public void setNoteType(Integer i) {
			type=i;
		}
		public String getPitch(){
			return pitch;
		}
		public void setPitch(String i) {
			pitch=i;
		}
		public Note getSelfWithPitch(String s){
			pitch=s;
			return this;
		}
	}
	
	public void playSong(Uri song) {
		noteList = decodeSong(resourceGet.getResource(song));
		index = 0;
		
		this.nextNote();
	}
	
	private void nextNote(){
		note = noteList.get(index);
		delay = 1000/note.getNoteType();
		
		controller.setCue(note.getPitch());
		
		index++;
		if(!(index>noteList.size())){
			timer.schedule(task, delay);
		}
	}
	
	
	
	class NoteTask extends TimerTask {
		public void run(){
			nextNote();
			timer.cancel();
		}
	}
	
	private List<Note> decodeSong(File songFile) {
		//set value of enums based on decoded bpm here
		//hardcoding a song in here because we ran out of time to retrieve a song.
		ArrayList<Note> maryhadalittlelamb = new ArrayList<Note>();
		maryhadalittlelamb.add(Note.QUARTER.getSelfWithPitch("c"));		
		return new ArrayList<Note>();
	}
}
