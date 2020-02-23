package caughey_problem2;

public class SavingsAccount {
	private static double annualInterestRate = 0.0;
	private double savingsBalance;
	
	public SavingsAccount(double balance) {
		savingsBalance = balance;
	}
	
	public void calculateMonthlyInterest() {
		savingsBalance += savingsBalance * (annualInterestRate / 12.0);
	}
	
	public static void modifyInterestRate(double value) {
		annualInterestRate = value;
	}
	
	public double getSavingsBalance() {
		return savingsBalance;
	}
}
