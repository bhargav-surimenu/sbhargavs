package com.springboot.zinkworks.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.springboot.zinkworks.exception.AccountException;
import com.springboot.zinkworks.exception.ResourceNotFoundException;
import com.springboot.zinkworks.model.AccountRequest;
import com.springboot.zinkworks.model.AccountResponse;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
class AccountDetailServiceTest {

	AccountRequest accountMock;
	AccountResponse accountResMock;
	
	AccountDetailService adsMock = null;
	AccountDetailService adsReal =  null;
	
	@BeforeEach
	public void init()
	{
		accountMock = new AccountRequest(1234,"1234");
		accountResMock = new AccountResponse(1234,"1234",10,10,"1234");
		adsMock = Mockito.mock(AccountDetailService.class);
		adsReal = new AccountDetailService();
	}
	
	@Test
	public void testFetchAccountDetailsAccountRequest() {
		Mockito.when(adsMock.fetchAccountDetails(accountMock)).thenReturn(accountResMock);
		//test
		AccountResponse actualResponse= adsMock.fetchAccountDetails(accountMock);	
		assertEquals(accountResMock,actualResponse);
	}
	
	@Test
	public void testFetchAccountDetailsAccountReq_InvalidPin() {
		
		accountMock = new AccountRequest(123456789,"123411");
		Exception exception = assertThrows(AccountException.class, () -> {
			adsReal.fetchAccountDetails(accountMock);
		});
		assertTrue(exception.getMessage().contains("Please check the Account Details Again"));
	}
	
	@Test
	public void testFetchAccountDetailsAccountReq_ResourceNotFond() {
		
		accountMock = new AccountRequest(234342,"123411");
		Exception exception = assertThrows(ResourceNotFoundException.class, () -> {
			adsReal.fetchAccountDetails(accountMock);
		});
		assertTrue(exception.getMessage().contains("Account Not Found"));
	}
	

}
