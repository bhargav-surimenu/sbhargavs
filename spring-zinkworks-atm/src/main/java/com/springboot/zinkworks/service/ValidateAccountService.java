package com.springboot.zinkworks.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.zinkworks.exception.AccountException;
import com.springboot.zinkworks.model.AccountRequest;
import com.springboot.zinkworks.model.AccountResponse;

@Service("validateAccountService")
public class ValidateAccountService {

	@Autowired
	AccountDetailService accountDetailService;

	public AccountResponse validateFetchAccount(AccountRequest account) {

		AccountResponse accountResponse = accountDetailService.fetchAccountDetails(account.getAccountNumber());
		if (null != accountResponse && validateAccountPin(account.getPinNumber(), accountResponse.getPinNumber())) {
			return accountResponse;
		} else {
			throw new AccountException("Please check the account Details");
		}

	}
	private boolean validateAccountPin(String inputPin, String accountpin) {
		return (accountpin.equals(inputPin) == true) ? true : false;
	}
}
