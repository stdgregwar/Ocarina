package com.instruments.ocarina.service;

import java.io.File;
import java.util.List;
import java.util.ArrayList;

import com.instruments.ocarina.dao.ResourceRetriever;
import android.media.*;

public class SoundPlayer {
        private SoundPool audioPlayer;
        private ResourceRetriever resourceGet;
        private List<Integer> noteSounds;
        
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
         */
        public SoundPlayer(File cacheDir)
        {
        	resourceGet = new ResourceRetriever(cacheDir);
        	audioPlayer = new SoundPool(2,AudioManager.STREAM_MUSIC,0);
        	noteSounds = loadAudioFiles();
        }
        
        /**
         * Method to load audio file retrieved from ResourceRetriver into SoundPool.
         * 
         * @return returns List of soundIDs for the loaded note WAVs.
         */
        private List<Integer> loadAudioFiles()
        {
        	//TODO:Load each wave file for notes and load into note list.
			return new ArrayList<Integer>();
        }
        
        /**
         * Method to play specified soundID loaded in SoundPool.
         * 
         * @param soundID ID of sound to play.
         * @return ID of stream of playing sound. Can be used to control/stop sound.
         */
        @SuppressWarnings("unused")
		private int playSound(Integer soundID)
        {
        	return audioPlayer.play(soundID, 1, 1, 1, -1, 1);
        }
        
        /**
         * Method to stop a playing sound .
         * 
         * @param streamID ID of stream which is playing and should be stopped.
         */
        private void stopSound(int streamID)
        {
        	audioPlayer.stop(streamID);
        }
        
        /**
         * Method to play note sound based on buttons that are down.
         * 
         */
     	
    	private void setNote(){
    		
    		//This takes the state of the UI in terms of which buttons are depressed
    		// and translates that into what note to play.
    		
    		if(keyOne&&keyTwo&&keyThree&&keyFour){
    			//DO
    		}
    		else if(keyOne&&!keyTwo&&keyThree&&keyFour){
    			//RE
    		}
    		else if(keyOne&&keyTwo&&keyThree&&!keyFour){
    			//Mi
    		}
    		else if(keyOne&&!keyTwo&&keyThree&&!keyFour){
    			//Fa
    		}
    		else if(!keyOne&&keyTwo&&keyThree&&keyFour){
    			//Fa#
    		}
    		else if(!keyOne&&!keyTwo&&keyThree&&keyFour){
    			//So
    		}
    		else if(!keyOne&&keyTwo&&keyThree&&!keyFour){
    			//So#
    		}
    		else if(!keyOne&&!keyTwo&&keyThree&&!keyFour){
    			//La
    		}
    		else if(!keyOne&&!keyTwo&&!keyThree&&keyFour){
    			//La#
    		}
    		else if(!keyOne&&keyTwo&&!keyThree&&!keyFour){
    			//Ti
    		}
    		else if(!keyOne&&!keyTwo&&!keyThree&&!keyFour&&keyFive){
    			//Dohi
    		}
    		else{
    			//silence
    		}
    		
    		//sound playing method will be called here
    		
    	}
    
}
