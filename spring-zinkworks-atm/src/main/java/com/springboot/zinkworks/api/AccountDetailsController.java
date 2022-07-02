/**
 * 
 */

package com.springboot.zinkworks.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.zinkworks.model.AccountRequest;
import com.springboot.zinkworks.model.AccountResponse;
import com.springboot.zinkworks.service.AccountDetailService;

/**
 * @author BHARGAV
 *
 */

@RestController

@RequestMapping("zinkworks")
public class AccountDetailsController {

	@Autowired
	AccountDetailService accountDetailService;

	/**
	 * @param account
	 * @return
	 */
	@PostMapping("/accountDetails")
	@ResponseBody
	public ResponseEntity<AccountResponse> fetchAccountDetails(@RequestBody AccountRequest account) {

		return new ResponseEntity<AccountResponse>(accountDetailService.fetchAccountDetails(account), HttpStatus.OK);

	}

}
