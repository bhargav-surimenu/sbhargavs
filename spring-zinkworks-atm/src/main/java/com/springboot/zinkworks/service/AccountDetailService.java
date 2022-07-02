package com.springboot.zinkworks.service;

import java.util.List;

import org.springframework.stereotype.Service;

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
	 * @return
	 */
	public AccountResponse fetchAccountDetails(AccountRequest account) {

		AccountResponse accountResponse = (AccountResponse) AccountInitializer.getAllAccounts().stream()
				.filter(accNo -> accNo.getAccountNumber() == account.getAccountNumber()).findFirst()
				.orElseThrow(() -> new ResourceNotFoundException("Account Not Found"));

		// Maximum withdrawl limit
		accountResponse.setMaxWithdrawlAmount(accountResponse.getBalanceAmount() - accountResponse.getOdAmount());
		accountResponse.setDinominations(null);
		return accountResponse;

	}

	/**
	 * @param accountNo
	 * @return
	 */
	public AccountResponse fetchAccountDetails(long accountNo) {

		AccountResponse accountResponse = (AccountResponse) AccountInitializer.getAllAccounts().stream()
				.filter(accNo -> accNo.getAccountNumber() == accountNo).findFirst()
				.orElseThrow(() -> new ResourceNotFoundException("Account Not Found"));

		// Maximum withdrawl limit
		accountResponse.setMaxWithdrawlAmount(accountResponse.getBalanceAmount() - accountResponse.getOdAmount());
		accountResponse.setDinominations(null);
		return accountResponse;
	}

	/**
	 * @return
	 */
	public List<AccountResponse> fetchAllAccountDetails() {

		return AccountInitializer.getAllAccounts();
	}

}
