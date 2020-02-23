package caughey_problem1;
import java.security.SecureRandom;
import java.util.Scanner;

public class CAI1 {
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
		System.out.printf("Very good!%n");
	}
	
	static private void displayIncorrectResponse() {
		System.out.printf("No. Please try again.%n");
	}
	
	public static void main(String args[]) {
		rand = new SecureRandom();
		scanner = new Scanner(System.in);
		quiz();
	}
	
}
