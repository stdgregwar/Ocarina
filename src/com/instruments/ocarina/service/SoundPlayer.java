package com.instruments.ocarina.service;

import java.io.File;
import java.util.HashMap;


import com.instruments.ocarina.dao.ResourceRetriever;

import android.content.ContentResolver;
import android.media.*;

public class SoundPlayer {
        private SoundPool audioPlayer;
        private ResourceRetriever resourceGet;
        private HashMap<String,Integer> noteSounds;
        
        // These represent the state of the buttons in the UI
    	// True = the button is depressed 
    	//False = the button is not depressed
    	boolean keyOne;
    	boolean keyTwo;
    	boolean keyThree;
    	boolean keyFour;
    	boolean keyFive;
        
        /**
         * Constructor for class. Also initializes the class vars.
         * 
         * @param cacheDir File object containing path to cache directory to pass to resource retriever.
         * @param resolver ContentResolver passed from main Activity that allows resource retrieval.
         */
        public SoundPlayer(File cacheDir,ContentResolver resolver)
        {
        	resourceGet = new ResourceRetriever(cacheDir,resolver);
        	audioPlayer = new SoundPool(1,AudioManager.STREAM_MUSIC,0);
        	noteSounds = loadAudioFiles();
        }
        
        /**
         * Method to load audio file retrieved from ResourceRetriver into SoundPool.
         * 
         * @return returns List of soundIDs for the loaded note WAVs.
         */
        private HashMap<String,Integer> loadAudioFiles()
        {
        	//TODO:Load each wave file for notes and load into note list.
			return new HashMap<String,Integer>();
        }
        
     
        
        /**
         * Method to play specified soundID loaded in SoundPool.
         * 
         * @param soundID ID of sound to play.
         * @return ID of stream of playing sound. Can be used to control/stop sound.
         */
		private void playSound(Integer soundID)
        {
        	if(soundID!=null){
        	audioPlayer.play(soundID, 1, 1, 1, -1, 1);
        	}else{
        		audioPlayer.stop(1);
        	}
        }
        
        
        /**
         * Method to play note sound based on buttons that are down.
         * 
         */
     	
    	private void setNote(){
    		
    		//This takes the state of the UI in terms of which buttons are depressed
    		// and translates that into what note to play.
    		
    		Integer soundID;
    		
    		if(keyOne&&keyTwo&&keyThree&&keyFour){
    			//Do
    			soundID = noteSounds.get("Do");
    		}
    		else if(keyOne&&!keyTwo&&keyThree&&keyFour){
    			//Re
    			soundID = noteSounds.get("Re");
    		}
    		else if(keyOne&&keyTwo&&keyThree&&!keyFour){
    			//Mi
    			soundID = noteSounds.get("Mi");
    		}
    		else if(keyOne&&!keyTwo&&keyThree&&!keyFour){
    			//Fa
    			soundID = noteSounds.get("Fa");
    		}
    		else if(!keyOne&&keyTwo&&keyThree&&keyFour){
    			//Fa#
    			soundID = noteSounds.get("Fa#");
    		}
    		else if(!keyOne&&!keyTwo&&keyThree&&keyFour){
    			//So
    			soundID = noteSounds.get("So");
    		}
    		else if(!keyOne&&keyTwo&&keyThree&&!keyFour){
    			//So#
    			soundID = noteSounds.get("So#");
    		}
    		else if(!keyOne&&!keyTwo&&keyThree&&!keyFour){
    			//La
    			soundID = noteSounds.get("La");
    		}
    		else if(!keyOne&&!keyTwo&&!keyThree&&keyFour){
    			//La#
    			soundID = noteSounds.get("La#");
    		}
    		else if(!keyOne&&keyTwo&&!keyThree&&!keyFour){
    			//Ti
    			soundID = noteSounds.get("Ti");
    		}
    		else if(!keyOne&&!keyTwo&&!keyThree&&!keyFour&&keyFive){
    			//Dohi
    			soundID = noteSounds.get("Dohi");
    		}
    		else{
    			//silence
    			soundID = null;
    		}
    		
    		//sound playing method will be called here
    		
    		this.playSound(soundID);
    		
    	}
    
}
