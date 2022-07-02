package com.springboot.zinkworks.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.springboot.zinkworks.init.AccountInitializer;
import com.springboot.zinkworks.model.AccountResponse;

/**
 * @author BHARGAV
 *
 */
@Service("accountDetailService")
public class AccountDetailService {

	/**
	 * @param accountNo
	 * @return
	 */
	public AccountResponse fetchAccountDetails(String accountNo) {

		long accountNumber = Long.parseLong(accountNo);
		AccountResponse accountResponse = (AccountResponse) AccountInitializer.getAllAccounts().stream()
				.filter(accNo -> accNo.getAccountNumber() == accountNumber).findFirst().orElse(null);

		// Maximum withdrawl limit
		accountResponse.setMaxWithdrawlAmount(accountResponse.getBalanceAmount() - accountResponse.getOdAmount());
		return accountResponse;

	}

	/**
	 * @param accountNo
	 * @return
	 */
	public AccountResponse fetchAccountDetails(long accountNo) {

		AccountResponse accountResponse = (AccountResponse) AccountInitializer.getAllAccounts().stream()
				.filter(accNo -> accNo.getAccountNumber() == accountNo).findFirst().orElse(null);

		// Maximum withdrawl limit
		accountResponse.setMaxWithdrawlAmount(accountResponse.getBalanceAmount() - accountResponse.getOdAmount());
		return accountResponse;
	}

	/**
	 * @return
	 */
	public List<AccountResponse> fetchAllAccountDetails() {

		return AccountInitializer.getAllAccounts();
	}

}
