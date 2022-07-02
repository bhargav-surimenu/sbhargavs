package com.springboot.zinkworks.init;

import java.util.ArrayList;
import java.util.List;

import com.springboot.zinkworks.model.Dinomination;

public class ATMInitializer {

	public static  int ATM_Amount;
	//private int[] denominations = new int[] {50,20,10,5};
	private static List<Dinomination> dinominations;
	
	static {
		
		ATM_Amount=1500;
		dinominations  = new ArrayList<Dinomination>();
		dinominations.add(new Dinomination(50,10));
		dinominations.add(new Dinomination(20,30));
		dinominations.add(new Dinomination(10,30));
		dinominations.add(new Dinomination(5,20));
	}

	/**
	 * @return
	 */
	public static List<Dinomination> getATMDinominations() {
		return dinominations;
	}
	
	public static int getATMBalance()
	{
		return ATM_Amount;
	}
}
