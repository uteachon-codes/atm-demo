package com.atm.demo;

import org.springframework.stereotype.Service;

@Service
public class AtmService {
	
   //Initial values
   private int balance10s = 360;
   private int balance5s = 273;
   private int balance1s = 56;
   
   private int balance;
   
   static int[] denoArray = new int[]{ 10, 5, 1 };
   
   AtmService() {
	  int total10s = balance10s*10;
	  int total5s = balance5s*5;
	  int total1s = balance1s*1;
	  
	  balance = total10s + total5s + total1s;
   }
   
   // should be separate service Impl
   private String performDenominations(int userInputAmount) {
	   
	   StringBuilder denoBlder = new StringBuilder("Output: ");
	   
	   for (int deno : denoArray) {
		   if (userInputAmount >= deno) {
			  int remAmount = userInputAmount % deno;
			  denoBlder.append(deno + "s = " + (userInputAmount-remAmount)/deno + ", ");
			  userInputAmount = remAmount;
		   }
	   }
	   return denoBlder.toString();
       
   }
   
   // add to withdraw service
   public String withdraw(int userInputAmount) throws IncorrectAmountException, InsufficientFundstException {
	   int origBalance = balance;
	   if (userInputAmount <= 0) {
		   throw new IncorrectAmountException("Incorrect withdraw amount input:: " + userInputAmount);
	   } else if (userInputAmount > balance) {
		   throw new InsufficientFundstException("Insufficient funds with balance:: " + origBalance);
	   } else {
		   performDenominations(userInputAmount);
		   balance = balance - userInputAmount;
	   }
	   
	   return "Original balance:: " + origBalance + "\n Withdraw successful:: " + userInputAmount + " Remaining balance:: " + balance + "\n" + performDenominations(userInputAmount);
   }
   
   // separate services
   
   // deposit
   
   // changePin
   
   // balanceInquiry


}
