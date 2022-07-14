public class Errors
{

	public static void main (String[] args)
	{
		// Syntax error. Missing ;
		System.out.println("Welcome to my first program!\n");

		// Logical error. ageStr can't contain letters only numbers
		// as it will be cast to an integer. Removed "years".
		String ageStr = "24";
      
		int age = Integer.parseInt(ageStr);
		
		System.out.println("I'm " + age + " years old.");

		// Exception error. three initialised to String instead of int.
		int three = 3;

		int answerYears = age + three;
		
		System.out.println("Total number of years: " + answerYears);

		// Logical error. 6 Months not added to answer month resulting
		// in the wrong answer.
		int answerMonths = (answerYears * 12) + 6;
		
		System.out.println("In 3 years and 6 months, I'll be " + answerMonths + " months old");
		
		//Once you've corrected all the errors, the answer should be 330.
	}

}


