package level_2;
import java.util.Scanner;

public class factorial {
	
	/* Main function:
	Request input from user to provide a positive integer. Calculate the factorial
	of the integer and print the result to console. */
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		int factorial_Number = 1;
		
		System.out.println("Enter a positive integer: ");
		int user_Number = input.nextInt();		
		while (user_Number < 0) {
			System.out.println("Enter a POSITIVE integer: ");
			user_Number = input.nextInt();
		}
		
		for (int i = 1; i <= user_Number; i++) {
			factorial_Number *= i;
		}

		System.out.println("Factorial of " + user_Number + " = " + factorial_Number);
	}

}
