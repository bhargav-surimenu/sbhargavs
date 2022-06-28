package com.springboot.zinkworks.model;

import java.io.Serializable;

public class Dinomination implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8361524278645753453L;
	private int denomination;
	private int quantity;
	private String currency;
	
	
	public int getDenomination() {
		return denomination;
	}

	public void setDenomination(int denomination) {
		this.denomination = denomination;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Dinomination(int denomination, int quantity) {
		super();
		this.denomination = denomination;
		this.quantity = quantity;
	}

	
	public int getValue() {
		return denomination*quantity;
	}

	@Override
	public String toString() {
		return "Dinomination [denomination=" + denomination + ", quantity=" + quantity + ", currency=" + currency + "]";
	}

	public Dinomination(int denomination, int quantity, String currency) {
		super();
		this.denomination = denomination;
		this.quantity = quantity;
		this.currency = currency;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + denomination;
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
		Dinomination other = (Dinomination) obj;
		if (denomination != other.denomination)
			return false;
		return true;
	}
	
	
}
