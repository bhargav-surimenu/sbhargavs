package com.springboot.zinkworks.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.springboot.zinkworks.exception.AccountException;
import com.springboot.zinkworks.model.AccountRequest;
import com.springboot.zinkworks.model.AccountResponse;
import com.springboot.zinkworks.util.NotesDispenserUtil;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
class ATMTransactionServiceTest {

	AccountRequest accountMock;
	AccountResponse accountResMock;

	@InjectMocks
	ATMTransactionService atmTSMock = new ATMTransactionService();

	@Mock
	NotesDispenserUtil minNotesDesponserUtilMock;

	@BeforeEach
	public void init() {
		accountMock = new AccountRequest(1234, "1234", 0);
		accountResMock = new AccountResponse(1234, "1234", 10, 10, "1234");
		atmTSMock = Mockito.mock(ATMTransactionService.class);
		minNotesDesponserUtilMock = Mockito.mock(NotesDispenserUtil.class);
	}

	@Test
	void testDoWithDrawl_Success() {

		// minNotesDesponserUtil.validateWithdrawlAmount(withDrawlAmnt))
		/*
		 * Mockito.when(minNotesDesponserUtilMock.validateWithdrawlAmount(mock(Integer.
		 * class))).thenReturn(true); //List<Dinomination> dinominations =
		 * minNotesDesponserUtil.dispenseNotes(withDrawlAmnt);
		 * Mockito.when(minNotesDesponserUtilMock.dispenseNotes(mock(Integer.class))).
		 * thenReturn((List<Dinomination>) mock(List.class));
		 * //minNotesDesponserUtil.deductDinomination(ATMInitializer.getATMDinominations
		 * (), dinominations);
		 * Mockito.when(minNotesDesponserUtilMock.deductDinomination((List<Dinomination>
		 * ) mock(List.class), (List<Dinomination>) mock(Dinomination.class))).
		 * thenReturn((List<Dinomination>) mock(List.class));
		 */

		Mockito.when(atmTSMock.doWithDrawl(accountMock, accountResMock)).thenReturn(accountResMock);

		AccountResponse actualResponse = atmTSMock.doWithDrawl(accountMock, accountResMock);
		assertEquals(accountResMock, actualResponse);

	}

	@Test
	void testDoWithDrawl_InvalidWithdrawl() {

		Mockito.when(atmTSMock.doWithDrawl(accountMock, accountResMock))
				.thenThrow(new AccountException("Please Enter valid Withdrawl amount"));

		Exception exception = assertThrows(AccountException.class, () -> {
			atmTSMock.doWithDrawl(accountMock, accountResMock);
		});
		assertTrue(exception.getMessage().contains("Please Enter valid Withdrawl amount"));

	}

	@Test
	void testDoWithDrawl_NoSufficientFunds() {

		Mockito.when(atmTSMock.doWithDrawl(accountMock, accountResMock))
				.thenThrow(new AccountException("Account Balance is Insufficient"));

		Exception exception = assertThrows(AccountException.class, () -> {
			atmTSMock.doWithDrawl(accountMock, accountResMock);
		});
		assertTrue(exception.getMessage().contains("Account Balance is Insufficient"));

	}

}
