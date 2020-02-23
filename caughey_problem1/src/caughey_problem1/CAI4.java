package caughey_problem1;
import java.security.SecureRandom;
import java.util.Scanner;

public class CAI4 {
	private static SecureRandom rand;
	private static Scanner scanner;
	
	static private void quiz(int difficulty) {
		int limit = (int) Math.pow(10, difficulty);
		int correct = 0;
		for (int i = 0; i < 10; i++) {
			int num1 = generateQuestionArgument(limit);
			int num2 = generateQuestionArgument(limit);
			int answer = num1 * num2;
			askQuestion(num1, num2);
			int response = readResponse();
			if (isAnswerCorrect(response, answer)) {
				displayCorrectResponse();
				correct++;
				continue;
			} else {
				displayIncorrectResponse();
				continue;
			}
		}
		displayCompletionMessage(correct, 10);
	}
	
	static private int generateQuestionArgument(int limit) {
		int num = rand.nextInt(limit);
		return num;
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
	
	static private void displayCompletionMessage(int correct, int questions) {
		double percent = (double) correct / (double) questions;
		System.out.printf("Your score is %.0f%%.%n", percent * 100.0);
		
		if (percent < 0.75) {
			System.out.printf("Please ask your teacher for extra help.%n");
		} else {
			System.out.printf("Congratulations, you are ready to go to the next level!%n");
		}
	}
	
	static private boolean askPlayAgain() {
		System.out.printf("Would you like to solve a new problem set? (y/n): ");
		String response = scanner.next();
		return response.equalsIgnoreCase("y");
	}
	
	static private int readDifficulty() {
		System.out.printf("What difficulty would you like to play at? (1-4): ");
		int response = scanner.nextInt();
		response = response < 1 ? 1 : (response > 4 ? 4 : response);
		return response;
	}
	
	public static void main(String args[]) {
		rand = new SecureRandom();
		scanner = new Scanner(System.in);
		do {
			int difficulty = readDifficulty();
			quiz(difficulty);
		} while(askPlayAgain());
	}
}
