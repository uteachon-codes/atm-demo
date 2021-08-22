package com.atm.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AtmController {
	
	@Autowired
	AtmService atmService;
    
	@GetMapping("/withdraw")
	//add postmapping for security
	public String withdraw(@RequestParam String amount) {
		
	    try {
			return atmService.withdraw(Integer.parseInt(amount));
		} catch (NumberFormatException | IncorrectAmountException | InsufficientFundstException e) {
			return e.getMessage();
		}
    }
}
