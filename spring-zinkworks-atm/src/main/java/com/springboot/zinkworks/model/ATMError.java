package com.springboot.zinkworks.model;

import java.io.Serializable;

public class ATMError implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4872558123736291004L;
	
	private String errorCode;
	private String errorDescription;

	
	public ATMError(String errorCode, String errorDescription) {
		super();
		this.errorCode = errorCode;
		this.errorDescription = errorDescription;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorDescription() {
		return errorDescription;
	}

	public void setErrorDescription(String errorDescription) {
		this.errorDescription = errorDescription;
	}

}
