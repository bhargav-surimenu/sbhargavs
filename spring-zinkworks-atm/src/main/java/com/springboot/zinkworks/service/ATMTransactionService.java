package com.springboot.zinkworks.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.zinkworks.exception.AccountException;
import com.springboot.zinkworks.init.ATMInitializer;
import com.springboot.zinkworks.init.AccountInitializer;
import com.springboot.zinkworks.model.AccountRequest;
import com.springboot.zinkworks.model.AccountResponse;
import com.springboot.zinkworks.model.Dinomination;
import com.springboot.zinkworks.util.MinNotesDesponserUtil;

@Service("atmTransactionService")
public class ATMTransactionService {

	@Autowired
	AccountDetailService accountDetailService;

	@Autowired
	MinNotesDesponserUtil minNotesDesponserUtil;

	/**
	 * @param account
	 * @param accountRepo
	 * @return
	 */
	public AccountResponse doWithDrawl(AccountRequest account, AccountResponse accountRepo) {
		
		if (null != accountRepo) {
			
			int withDrawlAmnt = account.getWithdrawlAmount();
			if (account != null && minNotesDesponserUtil.validateWithdrawlAmount(withDrawlAmnt)) {
				
				int balanceAmnt = accountRepo.getBalanceAmount();
				int netBalanceAmnt = balanceAmnt - accountRepo.getOdAmount();
				
				if ((ATMInitializer.getATMBalance() >= withDrawlAmnt) && (netBalanceAmnt >= withDrawlAmnt)) {

					accountRepo.setBalanceAmount(balanceAmnt - withDrawlAmnt);

					List<Dinomination> dinominations = minNotesDesponserUtil.dispenseNotes(withDrawlAmnt);
					accountRepo.setDinominations(dinominations);

					ATMInitializer.ATM_Amount = ATMInitializer.ATM_Amount - withDrawlAmnt;
					minNotesDesponserUtil.deductDinomination(ATMInitializer.getATMDinominations(), dinominations);

				} else {
					System.out.println("Account Balance is Insufficient");
					throw new AccountException("Account Balance is Insufficient");
				}
				List<AccountResponse> accounts = AccountInitializer.getAllAccounts();
				accounts.set(accounts.indexOf(accountRepo), accountRepo);
			} else {
				System.out.println("Please Enter valid Withdrawl amount");
				throw new AccountException("Please Enter valid Withdrawl amount");
			}
		} else {	
			System.out.println("Please check the Account Details Again");
			throw new AccountException("Please check the Account Details Again");
		}

		return accountRepo;
	}
		
}
