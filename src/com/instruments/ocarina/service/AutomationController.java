package com.instruments.ocarina.service;

public class AutomationController {
	
	public AutomationController() {
		//
	}
	
	public void setCue(String pitch){
		
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
	
	public void makeVisible(){
		
	}
	
	public void makeInvisible(){
		
	}
}
