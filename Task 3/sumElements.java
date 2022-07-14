package level_2;
import java.util.Scanner;

public class sumElements {

	/*Main loop
	 Request input form user to provide numbers for a 3-by-4 array.
	 Calculate the sum total of all the numbers in each column.
	 Ask user which column they would like to see add up.
	 Print results of chosen column to console.*/
	
	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
			
		double[][] numArray = new double[3][4];
		double[] columnTotal = new double[4];
		
		// Ask user for 3-by-4 array
		System.out.println("Please provide nubers for a 3 by 4 array: ");	
		for(int i = 0; i < numArray.length; i++) {
			for (int k = 0; k < numArray[i].length; k++) {
				System.out.println("Row " + (i+1) + " Column " + (k+1) + ":");
				numArray[i][k] = input.nextDouble();
			}
		}
		
		for(int i = 0; i < 4; i++) {
			for (int k = 0; k < numArray.length; k++) {
				columnTotal[i] += numArray[k][i];
			}
		}
		
		// Print array to console for user to view
		System.out.println("-----------------------------------------------------");
		System.out.println("1 \t 2 \t 3 \t 4");
		for(int i = 0; i < numArray.length; i++) {
			System.out.println(numArray[i][0] +"\t| "+ numArray[i][1] +"\t| "+ numArray[i][2]
							   +"\t| "+ numArray[i][3]);
		}
		System.out.println("-----------------------------------------------------");
		
		System.out.println("Which column would you like to add up?");
		int user_Column = input.nextInt();
		
		// Close scanner
		input.close();
		
		System.out.println("Sum total column "  + user_Column + ": " + columnTotal[user_Column-1]);
		
	}

}
