package caughey_problem1;
import java.security.SecureRandom;
import java.util.Scanner;

public class CAI2 {
	private static SecureRandom rand;
	private static Scanner scanner;
	
	static private void quiz() {
		int num1 = rand.nextInt(10);
		int num2 = rand.nextInt(10);
		int answer = num1 * num2;
		while(true) {
			askQuestion(num1, num2);
			int response = readResponse();
			if (isAnswerCorrect(response, answer)) {
				displayCorrectResponse();
				return;
			} else {
				displayIncorrectResponse();
				continue;
			}
		}
	}
	
	static private void askQuestion(int num1, int num2) {
		System.out.printf("How much is %d times %d? ", num1, num2);
	}
	
	static private int readResponse() {
		int response = scanner.nextInt();
		return response;
	}
	
	static private boolean isAnswerCorrect(int response, int answer) {
		return response == answer;
	}
	
	static private void displayCorrectResponse() {
		int phrase = rand.nextInt(4);
		switch (phrase) {
			case 0: System.out.printf("Very good!%n");
				break;
			case 1: System.out.printf("Excellent!%n");
				break;
			case 2: System.out.printf("Nice work!%n");
				break;
			case 3: System.out.printf("Keep up the good work!%n");
				break;
		}
	}
	
	static private void displayIncorrectResponse() {
		int phrase = rand.nextInt(4);
		switch (phrase) {
			case 0: System.out.printf("No. Please try again.%n");
				break;
			case 1: System.out.printf("Wrong. Try once more.%n");
				break;
			case 2: System.out.printf("Don't give up!%n");
				break;
			case 3: System.out.printf("No. Keep trying.%n");
				break;
		}
	}
	
	public static void main(String args[]) {
		rand = new SecureRandom();
		scanner = new Scanner(System.in);
		quiz();
	}
	
}
