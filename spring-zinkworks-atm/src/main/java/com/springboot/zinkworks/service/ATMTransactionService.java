package com.springboot.zinkworks.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.zinkworks.exception.AccountException;
import com.springboot.zinkworks.exception.ErrorMessage;
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

	public AccountResponse doWithDrawl(AccountRequest account, AccountResponse accountRepo) {
		if (null != accountRepo) {
			if (account != null && account.getWithdrawlAmount() > 0) {
				int balanceAmnt = accountRepo.getBalanceAmount();
				int netBalanceAmnt = balanceAmnt - accountRepo.getOdAmount();
				int withDrawlAmnt = account.getWithdrawlAmount();
				if ((ATMInitializer.ATM_Amount >= withDrawlAmnt) && (netBalanceAmnt >= withDrawlAmnt)) {

					accountRepo.setBalanceAmount(balanceAmnt - withDrawlAmnt);

					List<Dinomination> dinominations = minNotesDesponserUtil.dispenseNotes(withDrawlAmnt);
					accountRepo.setDinominations(dinominations);

					ATMInitializer.ATM_Amount = ATMInitializer.ATM_Amount - withDrawlAmnt;
					minNotesDesponserUtil.deductDinomination(ATMInitializer.getATMDinominations(), dinominations);

				} else {
					System.out.println("Account Balance is Insufficient");
					//accountRepo.setATMError(new ErrorMessage("5001", "Account Balance is Insufficient"));
					throw new AccountException("Account Balance is Insufficient");
				}
				List<AccountResponse> accounts = AccountInitializer.getAllAccounts();
				accounts.set(accounts.indexOf(accountRepo), accountRepo);
			} else {
				System.out.println("Please Enter valid Withdrawl amount");
				accountRepo = new AccountResponse(account.getAccountNumber());
				throw new AccountException("Please Enter valid Withdrawl amount");
			}
		} else {	
			accountRepo = new AccountResponse(account.getAccountNumber());
			throw new AccountException("Please check the Account Details Again");
		}

		return accountRepo;
	}

}
