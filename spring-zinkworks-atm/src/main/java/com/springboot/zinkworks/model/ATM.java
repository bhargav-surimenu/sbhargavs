package com.springboot.zinkworks.model;

import java.io.Serializable;
import java.util.List;

public class ATM implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5045394286712945393L;
	private int atmNumber;
	private String atmLocation;
	private int balanceAmount;
	private List<Dinomination> atmDinominations;
	
	public int getAtmNumber() {
		return atmNumber;
	}
	public void setAtmNumber(int atmNumber) {
		this.atmNumber = atmNumber;
	}
	public String getAtmLocation() {
		return atmLocation;
	}
	public void setAtmLocation(String atmLocation) {
		this.atmLocation = atmLocation;
	}
	public int getBalanceAmount() {
		return balanceAmount;
	}
	public void setBalanceAmount(int balanceAmount) {
		this.balanceAmount = balanceAmount;
	}
	public ATM(int atmNumber) {
		super();
		this.atmNumber = atmNumber;
	}
	public ATM(int atmNumber, String atmLocation, int balanceAmount, List<Dinomination> atmDinominations) {
		super();
		this.atmNumber = atmNumber;
		this.atmLocation = atmLocation;
		this.balanceAmount = balanceAmount;
		this.setAtmDinominations(atmDinominations);
	}
	public List<Dinomination> getAtmDinominations() {
		return atmDinominations;
	}
	public void setAtmDinominations(List<Dinomination> atmDinominations) {
		this.atmDinominations = atmDinominations;
	}
	
	
	
}
