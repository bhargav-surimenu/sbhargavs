package com.springboot.zinkworks.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.zinkworks.init.ATMInitializer;
import com.springboot.zinkworks.model.ATM;
import com.springboot.zinkworks.util.MinNotesDesponserUtil;

@RestController
@RequestMapping("zinkworks")
public class ATMAdminController {

	@Autowired
	MinNotesDesponserUtil minNotesDesponserUtil;
	
	/**
	 * @return
	 */
	@GetMapping("/atmBalance")
	public ATM fetchATMBalance()
	{
		return new ATM(1002,"IRLAND",ATMInitializer.getATMBalance(),ATMInitializer.getATMDinominations()); 
	}
}
