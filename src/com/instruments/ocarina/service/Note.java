package com.instruments.ocarina.service;

import com.instruments.ocarina.service.SongPlayer.Notes;

public class Note{
	
	private Notes noteType;
	private String pitch;
	
	
	public Note(String p, Notes nt){
		
		pitch = p;
		noteType = nt;
		
	}
	
	public Notes getNoteType(){
		
		return noteType;
	}
	
	public String getPitch(){
		
		return pitch;
	}
	
}