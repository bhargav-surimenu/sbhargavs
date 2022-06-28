package com.springboot.zinkworks.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.springboot.zinkworks.init.ATMInitializer;
import com.springboot.zinkworks.model.Dinomination;

@Component("minNotesDesponserUtil")
public class MinNotesDesponserUtil {

	public List<Dinomination> dispenseNotes(int amount){
		
		int[] notes = new int[]{ 50, 20, 10, 5};
        int[] noteCounter = new int[notes.length];
        List<Dinomination>  denominations = new ArrayList<Dinomination>();
        
        for (int i = 0; i < notes.length; i++) {
        	if (amount >= notes[i]) {
                noteCounter[i] = amount / notes[i];
                Dinomination atmDen = ATMInitializer.getATMDinominations().get(i);
                if(atmDen.getQuantity() >= noteCounter[i]) {
                	amount = amount - noteCounter[i] * notes[i];
            }
        	denominations.add( new Dinomination(notes[i],noteCounter[i],"€"));
          }
        }
        return denominations;
    }
	
	public List<Dinomination> deductDinomination(List<Dinomination> atmDinominations, List<Dinomination> transactionDinomination) {
	
		 for (int i = 0; i < atmDinominations.size(); i++) {
			 Dinomination denDest = atmDinominations.get(i);
		 
			 for(int t=0;t<transactionDinomination.size();t++) {
				 
				 Dinomination denSource = transactionDinomination.get(t);
			if(denDest.equals(denSource)) {
				denDest.setQuantity(denDest.getQuantity()-denSource.getQuantity());
			}
			atmDinominations.set(atmDinominations.indexOf(denDest),denDest);
		}
			 
	 } 
		 return atmDinominations;
	}
	
	
	
}
