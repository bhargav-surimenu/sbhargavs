package com.springboot.zinkworks.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.zinkworks.init.ATMInitializer;
import com.springboot.zinkworks.model.ATMResponse;

@RestController
@RequestMapping("zinkworks")
public class ATMAdminController {

	/**
	 * @return
	 */
	@GetMapping("/atmBalance")
	@ResponseBody
	public ResponseEntity<ATMResponse> fetchATMBalance() {
		return new ResponseEntity<ATMResponse>(
				new ATMResponse(1002, "IRLAND", ATMInitializer.getATMBalance(), ATMInitializer.getATMDinominations()),
				HttpStatus.OK);
	}
}
