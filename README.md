# atm-demo
atm-demo is springboot app with some rules built, along with unit test cases.

Developed a program called ATM. It takes an amount as input and dispenses the 10s, 5s, and 1s as needed. 

 
=> If the input amount is zero, negative, or over the balance, print "Incorrect or insufficient funds".
=> If the input amount is in valid range, print the number of 10s, 5s, and 1s needed to match the withdrawal amount.
=> Use higher denominations first before using the lower ones.
=> Also, print the balance.
 
For example, 
 
a) Input: 87 Output: 10s = 8, 5s = 1, and 1s = 2
b) Input: 10879 Output: "Incorrect or insufficient funds"
 
public class ATM {
   //Initial values
   private int balance10s = 360;
   private int balance5s = 273;
   private int balance1s = 56;
 
   public void withdraw(int amount) {
   }
}

