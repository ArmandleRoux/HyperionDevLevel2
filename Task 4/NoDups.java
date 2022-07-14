package level_2;

import java.util.Arrays;

public class NoDups {

	/* Main loop
	 * Declare Array of numbers and call remove_Dups() method on array
	 * to remove all duplicates.*/
	public static void main(String[] args) {

		int[] list = {20,100,10,80,70,1,0,-1,2,10,15,300,7,6,2,18,19,21,9,0};

		System.out.println(Arrays.toString(list));
		list = removeDups(list);
		System.out.println(Arrays.toString(list));

	}
	
	/* This method takes an Array of integers and removes the duplicates.
	 * The function first determines the amount of duplicates to determine new array size.
	 * Then the original Arrays gets sorted and each element is compared to the next element
	 * in the Array.
	 * If the next element is different then there is no duplicate and the number will be added
	 * to a new temporary Array.
	 * Once all elements are checked return new array with no duplicates. */
	public static int[] removeDups(int[] numbers) {
		
		
		int arrLength = numbers.length;
		int j = 0;
		int dups = 0;
		
		// Sort array to have values that are the same next to each other.
		Arrays.sort(numbers);
		
		// Determine amount of duplicates.
		for(int i = 0; i < numbers.length; i++) {
			if (i == numbers.length -1) {
				continue;
			}
			else if (numbers[i] == numbers[i+1]) {
				dups++;;
			}
		}
		
		// Create new array without duplicates.
		int[] temp = new int[arrLength-dups];
		for(int i = 0; i < numbers.length; i++) {	
			if (i == numbers.length -1) {
				temp[j] = numbers[i];
 			}
			
			else if (numbers[i] != numbers[i+1]) {
				temp[j] = numbers[i];
				j++;
			}
		}
		return temp;
	}

}
