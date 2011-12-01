package com.instruments.ocarina.service;

import java.io.File;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import android.net.Uri;
import android.util.Log;

import com.instruments.ocarina.dao.IResourceRetriever;
import com.instruments.ocarina.ui.OcarinaButton;

public class SongPlayer {
	private IResourceRetriever resourceGet;
	private AutomationController controller;
	private Note note;
	private ArrayList<Note> noteList;
	private int index;
	private Timer timer = new Timer();
	private long delay;
	private NoteTask task;
	
	public SongPlayer(ArrayList<OcarinaButton> buttons){
		controller = new AutomationController(buttons);
		task = new NoteTask();
	}
	
	public class Note {
		
		private Integer type;
		private String pitch;
		static final int QUARTER = 4;
		static final int HALF = 2;
		static final int WHOLE = 1;
		static final int EIGHTH = 8;
		public Note(Integer i){
			type=i;
		}
		public Note(Integer i,String s){
			type=i;
			pitch=s;
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
	}
	
	public void playSong(Uri song) {
		//noteList = decodeSong(resourceGet.getResource(song));
		//hardcoding song. ran out of time.
		noteList = decodeSong(new File(""));
		index = 0;
		this.nextNote();
	}
	
	private void nextNote(){
		task = new NoteTask();
		note = noteList.get(index);
		delay = 4000/note.getNoteType();
		controller.setCue(note.getPitch());
		
		index++;
		if(!(index >= noteList.size())){
			timer.schedule(task, delay);
		} else {
			controller.clearNotes();
		}
	}
	
	
	
	class NoteTask extends TimerTask {
		public void run(){
			nextNote();
			this.cancel();
		}
	}
	
	private ArrayList<Note> decodeSong(File songFile) {
		//set value of enums based on decoded bpm here
		//hardcoding a song in here because we ran out of time to retrieve a song.
		ArrayList<Note> maryhadalittlelamb = new ArrayList<Note>();
		maryhadalittlelamb.add(new Note(Note.QUARTER,"Mi"));
		maryhadalittlelamb.add(new Note(Note.QUARTER,"Re"));
		maryhadalittlelamb.add(new Note(Note.QUARTER,"Do"));
		maryhadalittlelamb.add(new Note(Note.QUARTER,"Re"));
		maryhadalittlelamb.add(new Note(Note.QUARTER,"Mi"));
		maryhadalittlelamb.add(new Note(Note.QUARTER,"Mi"));
		maryhadalittlelamb.add(new Note(Note.QUARTER,"Mi"));
		return maryhadalittlelamb;
	}
}
