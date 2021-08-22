package com.atm.demo;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;


@ExtendWith(MockitoExtension.class)
class AtmServiceTest {
	
	@InjectMocks
	AtmService atmService;

	@Test
	void testWithdraw_0_Negative_Amount_Throw_IncorrectAmountException() {
		
		
		
		IncorrectAmountException e = assertThrows(IncorrectAmountException.class, () -> {
			    atmService.withdraw(0);
			  });
		assertEquals("Incorrect withdraw amount input:: " + 0, e.getMessage());
	}
	
	@Test
	void testWithdraw_Over_the_balance_Amount_Throw_InsufficientFundstException() {
		
		assertThrows(InsufficientFundstException.class, () -> {
			    atmService.withdraw(9999);
			  });
	}
	
	@Test
	void testWithdraw_within_range_of_balance_Amount_does_not_Throw_any_Exception() {
		
		assertDoesNotThrow(() -> {
			    atmService.withdraw(4000);
			  });
	}

}
