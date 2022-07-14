package level_2;
import java.util.Scanner;
import java.util.Arrays;

public class identicalArrays {
	
	/*Main loop
	 Request input from user to provide 5 integers for 1 array and
	 another 5 integers for another array. 
	 Sort both arrays with Arrays.sort() and compare them to each other
	 with Arrays.equals.
	 If both arrays are identical print to console that they are else 
	 print to console that they are not identical.*/
	
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
			
		int[] firstNumArray = new int[5];
		int[] secondNumArray = new int[5];
		
		// First array
		System.out.println("-----------------------------------------------------");
		System.out.println("Enter 5 numbers for the First array pressing enter after each"
							+ " number entered: ");
		for(int i = 0; i < firstNumArray.length; i++) {
			System.out.println("Number " + (i+1) + ": ");
			firstNumArray[i] = input.nextInt();
		}
		
		// Second array
		System.out.println("-----------------------------------------------------");
		System.out.println("Enter 5 numbers for the Second array pressing enter after each"
							+ " number entered: ");
		for(int i = 0; i < secondNumArray.length; i++) {
			System.out.println("Number " + (i+1) + ": ");
			secondNumArray[i] = input.nextInt();
		}
		
		// Close scanner
		input.close();
		
		// Sort both arrays
		Arrays.sort(firstNumArray);
		Arrays.sort(secondNumArray);
		
		System.out.println("-----------------------------------------------------");
		if (Arrays.equals(firstNumArray, secondNumArray)) {  // Compare sorted arrays
			System.out.println("The two arrays are identical");
		}
		else {
			System.out.println("The two arrays are not identical");
		}
		System.out.println("-----------------------------------------------------");
	}

}
