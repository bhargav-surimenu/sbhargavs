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
import com.springboot.zinkworks.service.ATMTransactionService;
import com.springboot.zinkworks.service.AccountDetailService;

@RestController
@RequestMapping("zinkworks")
public class ATMTransactionController {

	@Autowired
	AccountDetailService accountDetailService;

	@Autowired
	ATMTransactionService atmTransactionService;

	@PostMapping("/withdrawl")
	@ResponseBody
	public ResponseEntity<AccountResponse> withdrawlBalanceCheck(@RequestBody AccountRequest account) {
		AccountResponse accountRepo = accountDetailService.fetchAccountDetails(account);
		
		return new ResponseEntity<AccountResponse>(atmTransactionService.doWithDrawl(account,accountRepo), HttpStatus.OK);

	}

}
