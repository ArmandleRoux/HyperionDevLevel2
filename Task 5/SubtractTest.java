package level_2;

import java.util.Scanner;


public class SubtractTest {
	
	/* Main loop
	 * Request input from user to provide answers for subtraction equations.
	 * After all equations are answered print results and time it took to console. */
	
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);

		final int totalQuestions = 5;
		int correctCount = 0; 
		int questionCounter = 0; 
		long startTime = System.currentTimeMillis();
		String allEquations = " ";
		
		while (questionCounter < totalQuestions) {
			
			int number1 = (int)(Math.random() * 10);
			int number2 = (int)(Math.random() * 10);
			
			// Swap numbers if number1 > number2
			if (number1 < number2) {
				int temp = number1; 
				number1 = number2; 
				number2 = temp;
			}
			
			System.out.print("What is " + number1 + " - " + number2 + "? ");
			int answer = input.nextInt();
		
			if (number1 - number2 == answer) { 
				System.out.println("You are correct!");
				correctCount++; // Increase the correct answer count
			}
			else {
				System.out.println("Your answer is wrong.\n" + number1
								+ " - " + number2 + " should be "
								+ (number1 - number2));
			}
			
			questionCounter++;
			allEquations += "\n" + number1 + "-" + number2 + "=" + answer +
							((number1 - number2 == answer) ? " correct" : " wrong");
			
		}
		
		// Close scanner
		input.close();
		
		// Calculate time it took to finish
		long endTime = System.currentTimeMillis();
		long testTime = endTime - startTime;
		
		System.out.println("Correct count is " + correctCount
						+ "/5\nTest time is " + testTime / 1000
						+ " seconds\n" + allEquations);
		}
}
