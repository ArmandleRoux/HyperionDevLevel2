package level_2;
import java.util.Scanner;


public class grades {
	
	/*Main loop
	 Request input from user to provide their marks for 5 subjects.
	 Calculate the average of the 5 marks and determine which grade the 
	 student will get.
	 Print results to console.*/
	
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		int[] myTestResults = new int[5];
		int average = 0;
		
		for(int i = 0; i < 5; i++) {
			System.out.println("-----------------------------------------------------");
			System.out.println("Enter your result for subject " + (i+1));
			myTestResults[i] = input.nextInt();
		}
		
		// Close scanner
		input.close();	
		
		// Average calculation
		for(int i = 0; i < myTestResults.length; i++) {
			average += myTestResults[i];
		}
		average = average/5;
		
		System.out.println("-----------------------------------------------------");
		if(average >= 80 && average <= 100) {
			System.out.println("Average: " + average + "\nGrade Symbol: A");
		}
		else if(average >= 70 && average <= 79) {
			System.out.println("Average: " + average + "\nGrade Symbol: B");
		}
		else if(average >= 60 && average <= 69) {
			System.out.println("Average: " + average + "\nGrade Symbol: C");
		}
		else if(average >= 50 && average <= 59) {
			System.out.println("Average: " + average + "\nGrade Symbol: D");
		}
		else {
			System.out.println("Average: " + average + "\nGrade Symbol: F");
		}
		System.out.println("-----------------------------------------------------");
	
	}
}