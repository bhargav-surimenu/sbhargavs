package com.springboot.zinkworks.exception;

public class ATMException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public ATMException(String msg) {
		super(msg);
	}
}
