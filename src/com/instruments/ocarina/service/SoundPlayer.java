package com.instruments.ocarina.service;

import java.io.File;
import java.util.List;
import java.util.ArrayList;

import com.instruments.ocarina.dao.ResourceRetriever;

import android.content.ContentResolver;
import android.media.*;

public class SoundPlayer {
        private SoundPool audioPlayer;
        private ResourceRetriever resourceGet;
        private List<Integer> noteSounds;
        
        /**
         * Constructor for class. Also initializes the class vars.
         * 
         * @param cacheDir File object containing path to cache directory to pass to resource retriever.
         */
        public SoundPlayer(File cacheDir,ContentResolver resolver)
        {
        	resourceGet = new ResourceRetriever(cacheDir,resolver);
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
         * @param buttons List of buttons and whether they are down or not.
         */
        public void playNote(List<Boolean> buttons)
        {
        	//TODO:Grant will use this function to determine which buttons make which sound.
        }
}
