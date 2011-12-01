package com.instruments.ocarina.service;

import java.util.ArrayList;

import com.instruments.ocarina.Keys;
import com.instruments.ocarina.ui.OcarinaButton;

public class AutomationController {
	private ArrayList<OcarinaButton> UIButtons;
	
	public AutomationController(ArrayList<OcarinaButton> buttons) {
		UIButtons = buttons;
	}
	
	public void setCue(String pitch){
		
		clearNotes();
		if (pitch == "Do") {
			// Do: keyOne && keyTwo && keyThree && keyFour
			
		} else if (pitch == "Re") {
			// Re: keyOne && !keyTwo && keyThree && keyFour
			
		} else if (pitch == "Mi") {
			// Mi: keyOne && keyTwo && keyThree && !keyFour
			
		} else if (pitch == "Fa") {
			// Fa: keyOne && !keyTwo && keyThree && !keyFour
			
		} else if (pitch == "Fa#") {
			// Fa#: !keyOne && keyTwo && keyThree && keyFour
			
		} else if (pitch == "So") {
			// So: !keyOne && !keyTwo && keyThree && keyFour
			
		} else if (pitch == "So#") {
			// So#: !keyOne && keyTwo && keyThree && !keyFour
			
		} else if (pitch == "La") {
			// La: !keyOne && !keyTwo && keyThree && !keyFour
			
		} else if (pitch == "La#") {
			// La#: !keyOne && !keyTwo && !keyThree && keyFour
			
		} else if (pitch == "Ti") {
			// Ti: !keyOne && keyTwo && !keyThree && !keyFour
			
		} else if (pitch == "Dohi") {
			// Dohi: !keyOne && !keyTwo && !keyThree && !keyFour && keyFive
			
		} else {
			// silence
			
		}
		
	}
	
	public void makeVisible(Keys key){
		
	}
	
	public void makeInvisible(Keys key){
		
	}
	
	private void clearNotes(){
		makeInvisible(Keys.ONE);
		makeInvisible(Keys.TWO);
		makeInvisible(Keys.THREE);
		makeInvisible(Keys.FOUR);
		makeInvisible(Keys.FIVE);
	}
}
