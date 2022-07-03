package com.springboot.zinkworks.model;

import java.io.Serializable;

public class AccountRequest implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3089131457721765154L;
	private long accountNumber;
	private String pinNumber;
	private int withdrawlAmount;
	

	public AccountRequest(long accountNumber, String pinNumber, int withdrawlAmount) {
		super();
		this.accountNumber = accountNumber;
		this.pinNumber = pinNumber;
		this.withdrawlAmount = withdrawlAmount;
	}
	
	public AccountRequest(long accountNumber, String pinNumber) {
		super();
		this.accountNumber = accountNumber;
		this.pinNumber = pinNumber;
	}

	public long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getPinNumber() {
		return pinNumber;
	}

	@Override
	public String toString() {
		return "AccountReqest [accountNumber=" + accountNumber + ", pinNumber=" + pinNumber + ", withdrawlAmount="
				+ withdrawlAmount + "]";
	}

	public void setPinNumber(String pinNumber) {
		this.pinNumber = pinNumber;
	}

	public int getWithdrawlAmount() {
		return withdrawlAmount;
	}

	public void setWithdrawlAmount(int withdrawlAmount) {
		this.withdrawlAmount = withdrawlAmount;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (accountNumber ^ (accountNumber >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AccountRequest other = (AccountRequest) obj;
		if (accountNumber != other.accountNumber)
			return false;
		return true;
	}

}
