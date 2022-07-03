package com.springboot.zinkworks.service;

import org.springframework.stereotype.Service;

import com.springboot.zinkworks.exception.AccountException;
import com.springboot.zinkworks.exception.ResourceNotFoundException;
import com.springboot.zinkworks.init.AccountInitializer;
import com.springboot.zinkworks.model.AccountRequest;
import com.springboot.zinkworks.model.AccountResponse;

/**
 * @author BHARGAV
 *
 */
@Service("accountDetailService")
public class AccountDetailService {

	/**
	 * @param account
	 * @return AccountResponse
	 */
	public AccountResponse fetchAccountDetails(AccountRequest account) {

		AccountResponse accountResponse = (AccountResponse) AccountInitializer.getAllAccounts().stream()
				.filter(accNo -> accNo.getAccountNumber() == account.getAccountNumber()).findFirst()
				.orElseThrow(() -> new ResourceNotFoundException("Account Not Found"));
		
		if(!validateAccountPin(account.getPinNumber(),accountResponse.getPinNumber())){
			throw new AccountException("Please check the Account Details Again");
		}	
		
		// Maximum with drawl limit
		accountResponse.setMaxWithdrawlAmount(accountResponse.getBalanceAmount() - accountResponse.getOdAmount());
		accountResponse.setDinominations(null);
		return accountResponse;

	}

	/**
	 * @param inputPin
	 * @param accountpin
	 * @return boolean
	 */
	private boolean validateAccountPin(String inputPin, String accountpin) {
		return (accountpin.equals(inputPin)) ? true : false;
	}

}
