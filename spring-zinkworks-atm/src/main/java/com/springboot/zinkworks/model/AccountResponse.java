package com.springboot.zinkworks.model;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AccountResponse implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8427962506703906875L;
	private long accountNumber;
	private String accountName;
	private int balanceAmount;
	private int odAmount;
	private int maxWithdrawlAmount;
	private String pinNumber;
	private List<Dinomination> dinominations;

	private ATMError error;

	public AccountResponse(long accountNumber, String accountName, int balanceAmount, int odAmount,String pinNumber) {
		super();
		this.accountNumber = accountNumber;
		this.accountName = accountName;
		this.balanceAmount = balanceAmount;
		this.odAmount = odAmount;
		this.pinNumber = pinNumber;
	}

	public AccountResponse(long accountNumber, String accountName, int balanceAmount, int odAmount,
			int maxWithdrawlAmount, List<Dinomination> dinominations, ATMError error) {
		super();
		this.accountNumber = accountNumber;
		this.accountName = accountName;
		this.balanceAmount = balanceAmount;
		this.odAmount = odAmount;
		this.maxWithdrawlAmount = maxWithdrawlAmount;
		this.dinominations = dinominations;
		this.error = error;
	}
	
	
	public AccountResponse(long accountNumber) {
		super();
		this.accountNumber = accountNumber;
	}

	public long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public int getBalanceAmount() {
		return balanceAmount;
	}

	public void setBalanceAmount(int balanceAmount) {
		this.balanceAmount = balanceAmount;
	}

	public int getOdAmount() {
		return odAmount;
	}

	public void setOdAmount(int odAmount) {
		this.odAmount = odAmount;
	}

	public int getMaxWithdrawlAmount() {
		return maxWithdrawlAmount;
	}

	public void setMaxWithdrawlAmount(int maxWithdrawlAmount) {
		this.maxWithdrawlAmount = maxWithdrawlAmount;
	}

	public List<Dinomination> getDinominations() {
		return dinominations;
	}

	public void setDinominations(List<Dinomination> dinominations) {
		this.dinominations = dinominations;
	}

	public ATMError getATMError() {
		return error;
	}

	public void setATMError(ATMError error) {
		this.error = error;
	}
	
	@JsonIgnore
	public String getPinNumber() {
		return pinNumber;
	}

	public void setPinNumber(String pinNumber) {
		this.pinNumber = pinNumber;
	}

}
