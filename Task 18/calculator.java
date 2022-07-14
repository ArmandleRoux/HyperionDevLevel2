import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class calculator {

  /* Main method
   * Requests user to provide 2 numbers and an operator.
   * The program then calls the function on the numbers related to
   * the operator chosen by the user. The equation is then printed
   * to the console with the result and is also saved to a textfile.*/
  public static void main(String[] args) {

    // Objects
    Scanner input = new Scanner(System.in);
    FileWriter writer = null;

    // Variables
    String userInput;
    String menu = "";
    float num1 = 0;
    float num2 = 0;
    float result = 0;

    // Initialising output file.
    try {
      new File("equations").mkdirs();
      writer = new FileWriter("equations\\equations.txt");
    }
    catch (IOException e) {
      System.out.println("File Error!");
    }

    while(!menu.equals("2")) {

      // Request first number with try catch to make sure user provides
      // a valid input.
      while (true) {
        System.out.println("Enter a number: ");
        userInput = input.nextLine().strip();

        try {
          num1 = Float.parseFloat(userInput);
          break;
        } catch (NumberFormatException e) {
          System.out.println("Please enter numbers only!");
        }
      }

      // Request second number with try catch to make sure user provides
      // a valid input.
      while (true) {
        System.out.println("Enter another number: ");
        userInput = input.nextLine().strip();

        try {
          num2 = Float.parseFloat(userInput);
          break;
        } catch (NumberFormatException e) {
          System.out.println("Please enter numbers only!");
        }
      }

      // Request operator from user with an if-else statement to check
      // if user provided valid input.
      while (true) {
        System.out.println("Choose your operation: ( +, -, *, /)");
        userInput = input.nextLine().strip();
        if ("+-*/".contains(userInput) && userInput.length() == 1) {
          switch (userInput) {
            case "+" -> result = sum(num1, num2);
            case "-" -> result = subtract(num1, num2);
            case "*" -> result = multiply(num1, num2);
            case "/" -> result = divide(num1, num2);
          }
          break;
        } else {
          System.out.println("Operator not found. Try again.");
        }
      }

      // Read equation to file.
      if (writer != null) {
        try {
          writer.write(num1 + " " + userInput + " " + num2 + " = " + result + "\n");
        } catch (IOException e){
          System.out.println("File error occurred");
        }
      }
      // Print equation to console.
      System.out.println(num1 + " " + userInput + " " + num2 + " = " + result);
      System.out.println("---------------------------------------------------");

      // Ask user if they would like to do another equation.
      while (true) {
        System.out.println("Would you like to do another equation?\n"
                + "1 - Yes\n2 - No");
        menu = input.nextLine();
        if("12".contains(menu)) {
          break;
        }
        else {
          System.out.println("No option chosen.");
        }
      }
    }

    // Close output file after user is done using program.
    if(writer != null) {
      try {
        writer.close();
      } catch (IOException e) {
        System.out.println("File error occurred");
      }
    }
    input.close();
    System.out.println("Goodbye!");
  }

  // Adds two numbers together.
  public static float sum(float num1 , float num2){
    return num1 + num2;
  }

  // Subtracts one number from another.
  public static float subtract(float num1 , float num2){
    return num1 - num2;
  }

  // Multiplies two numbers.
  public static float multiply(float num1 , float num2){
    return num1 * num2;
  }

  // Divide one number by another.
  public static float divide(float num1 , float num2){
    // Check to make sure user is not trying to divide by 0.
    if (num2 == 0) {
      System.out.println("Can't divide by 0!");
      return 0;
    }
    return num1/num2;
  }
}
