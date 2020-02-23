package caughey_problem2;

public class SavingsAccountTest {
	
	public static void main(String args[]) {
		SavingsAccount saver1 = new SavingsAccount(2000.00);
		SavingsAccount saver2 = new SavingsAccount(3000.00);
		SavingsAccount.modifyInterestRate(0.04);
		
		System.out.printf("saver1   saver2%n");
		for (int i = 0; i < 12; i++) {
			saver1.calculateMonthlyInterest();
			saver2.calculateMonthlyInterest();
			System.out.printf("$%.2f ", saver1.getSavingsBalance());
			System.out.printf("$%.2f%n", saver2.getSavingsBalance());
		}

		SavingsAccount.modifyInterestRate(0.05);
		saver1.calculateMonthlyInterest();
		saver2.calculateMonthlyInterest();
		System.out.printf("saver1 has $%.2f%n", saver1.getSavingsBalance());
		System.out.printf("saver2 has $%.2f%n", saver2.getSavingsBalance());
	}
	
}
