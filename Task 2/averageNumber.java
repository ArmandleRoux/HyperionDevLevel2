package level_2;
import java.util.Scanner;

public class averageNumber {

	/* Main Function
	 Request input from user to provide integer numbers. Determine amount of
	 positive and negative numbers entered. When user enters '0' calculate 
	 the Sum total of the numbers and the average. Print total positive and
	 negative numbers to the console as well as the calculation results.*/
	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		
		int total_Positive = 0;
		int total_Negative = 0;
		int total_Numbers = 0;
		int sum_Total = 0;
		int average_Number = 0;
		
		while (true) {
			System.out.println("-----------------------------------------------------");
			System.out.println("Enter an integer and press enter: \n"
								+ "(Enter 0 to start calculations)");
			int user_Number = input.nextInt();
			
			if (user_Number == 0) {
				break;
			}
			
			if (user_Number > 0 ) {
				total_Positive += 1;
			}
			else if (user_Number < 0) { 
				total_Negative += 1;
			}
			
			sum_Total += user_Number;
			
		}
		
		total_Numbers = total_Negative + total_Positive;
		average_Number = sum_Total/total_Numbers;
		System.out.println("-----------------------------------------------------");
		System.out.println("Total Numbers:               \t" + total_Numbers
							+ "\nTotal Positive number:  \t" + total_Positive
							+ "\nTotal Negative numbers: \t" + total_Negative);
		System.out.println("-----------------------------------------------------");
		System.out.println("Sum of all numbers = " + sum_Total
							+ "\nAverage = " + average_Number);
		System.out.println("-----------------------------------------------------");
		
		
	}

}
