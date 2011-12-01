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
			makeVisible(Keys.ONE);
			makeVisible(Keys.TWO);
			makeVisible(Keys.THREE);
			makeVisible(Keys.FOUR);
			
		} else if (pitch == "Re") {
			// Re: keyOne && !keyTwo && keyThree && keyFour
			makeVisible(Keys.ONE);
			makeVisible(Keys.THREE);
			makeVisible(Keys.FOUR);
			
		} else if (pitch == "Mi") {
			// Mi: keyOne && keyTwo && keyThree && !keyFour
			makeVisible(Keys.ONE);
			makeVisible(Keys.TWO);
			makeVisible(Keys.THREE);
			
		} else if (pitch == "Fa") {
			// Fa: keyOne && !keyTwo && keyThree && !keyFour
			makeVisible(Keys.ONE);
			makeVisible(Keys.THREE);
			
		} else if (pitch == "Fa#") {
			// Fa#: !keyOne && keyTwo && keyThree && keyFour
			makeVisible(Keys.TWO);
			makeVisible(Keys.THREE);
			makeVisible(Keys.FOUR);
			
		} else if (pitch == "So") {
			// So: !keyOne && !keyTwo && keyThree && keyFour
			makeVisible(Keys.THREE);
			makeVisible(Keys.FOUR);
			
		} else if (pitch == "So#") {
			// So#: !keyOne && keyTwo && keyThree && !keyFour
			makeVisible(Keys.TWO);
			makeVisible(Keys.THREE);
			
		} else if (pitch == "La") {
			// La: !keyOne && !keyTwo && keyThree && !keyFour
			makeVisible(Keys.THREE);
			
		} else if (pitch == "La#") {
			// La#: !keyOne && !keyTwo && !keyThree && keyFour
			makeVisible(Keys.FOUR);
			
		} else if (pitch == "Ti") {
			// Ti: !keyOne && keyTwo && !keyThree && !keyFour
			makeVisible(Keys.TWO);
			
		} else if (pitch == "Dohi") {
			// Dohi: !keyOne && !keyTwo && !keyThree && !keyFour && keyFive
			makeVisible(Keys.FIVE);
			
		} else {
			// silence
			
		}
	}
	
	public void makeVisible(Keys key){
		for(OcarinaButton b :UIButtons){
			if(b.getKey() == key){
				b.showOverlay();
			}
		}
	}
	
	public void makeInvisible(Keys key){
		for(OcarinaButton b :UIButtons){
			if(b.getKey() == key){
				b.hideOverlay();
			}
		}
	}
	
	public void clearNotes(){
		makeInvisible(Keys.ONE);
		makeInvisible(Keys.TWO);
		makeInvisible(Keys.THREE);
		makeInvisible(Keys.FOUR);
		makeInvisible(Keys.FIVE);
	}
}
