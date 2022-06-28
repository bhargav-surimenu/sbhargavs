package com.springboot.zinkworks.init;

import java.util.ArrayList;
import java.util.List;

import com.springboot.zinkworks.model.AccountResponse;

public class AccountInitializer {

	private static List<AccountResponse> accountResponses;
	
	static {
		accountResponses = new ArrayList<AccountResponse>();
		accountResponses.add(new AccountResponse(123456789, "ZinkWorks India", 800, 200,"1234"));
		accountResponses.add(new AccountResponse(987654321, "ZinkWorks Irish", 1230, 150,"4321"));
	}

	public static List<AccountResponse> getAllAccounts() {
		return accountResponses;
	}

}
