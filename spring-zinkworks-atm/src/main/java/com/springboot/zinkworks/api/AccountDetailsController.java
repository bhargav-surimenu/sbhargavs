/**
 * 
 */
package com.springboot.zinkworks.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.zinkworks.model.AccountRequest;
import com.springboot.zinkworks.model.AccountResponse;
import com.springboot.zinkworks.service.ValidateAccountService;

/**
 * @author BHARGAV
 *
 */
@RestController
@RequestMapping("zinkworks")
public class AccountDetailsController {

	@Autowired
	ValidateAccountService validateAccountService;
	
	@PostMapping("/accountDetails")
	@ResponseBody
	public AccountResponse fetchAccountDetails(@RequestBody AccountRequest account) {
		
		return validateAccountService.validateFetchAccount(account);
		
	}
	
	
}
