import java.io.File;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Formatter;

public class MyFile {

    /* The program reads data from an input file that provides a method and an
       array of numbers. The program then determines the method to apply to the
       array and writes the result to an output file.*/

  public static void main(String[] args) {

    //Get user directory to locate input file and store output file
    String userDirectory = System.getProperty("user.dir");
    String outputPath = (userDirectory + "\\output.txt");


    // Try catch for reading data from input file and writing to output file
    try{
      File x = new File(userDirectory + "\\input.txt");
      if (x.createNewFile()) {
        System.out.println("File created: "
                + x.getAbsolutePath());
      }
      else {
        System.out.println("File already exists. " + x.getAbsolutePath());
      }
      Scanner sc = new Scanner(x);

      Formatter f = new Formatter(outputPath);

      while (sc.hasNext()){
        // Determine which function to use according to method from file
        String[] line = sc.nextLine().split(":");
        String method = line[0];
        line = line[1].split(",");

        // Create array of numbers after method was determined
        int[] numbers = new int[line.length];
        for(int i = 0; i < line.length; i++) {
          numbers[i] = Integer.parseInt(line[i]);
        }

        // Apply determined method to number array and write result to output file
        if(method.equals("min")) {
          f.format("The " + method + " of " + Arrays.toString(numbers)
                  +" is " + min(numbers) + "\n");
        }
        else if(method.equals("max")) {
          f.format("The " + method + " of " + Arrays.toString(numbers)
                  +" is "+ max(numbers) + "\n");
        }
        else if(method.equals("avg")) {
          f.format("The " + method + " of " + Arrays.toString(numbers)
                  +" is "+ average(numbers) + "\n");
        }
        else if(method.equals("sum")) {
          f.format("The " + method + " of " + Arrays.toString(numbers)
                  +" is "+ sum(numbers) + "\n");
        }
        else if(method.startsWith("P")) {
          method = method.replace("P", "");
          int percentileNum = Integer.parseInt(method);
          f.format("The " + percentileNum + "th percentile of "
                  + Arrays.toString(numbers) +" is "
                  + percentile(numbers, percentileNum) + "\n");
        }
      }
      System.out.println("Output file location: " + outputPath);
      f.close();
      sc.close();
    } catch(Exception e) {
      System.out.println("Error, File not found!");
    }

  }

  // Determine the smallest number in an array of integers
  public static int min(int[] numbers) {
    int smallest = 0;
    for (int number : numbers) {
      if (smallest > number) {
        smallest = number;
      }
    }
    return smallest;
  }

  // Determine the largest number in an array of integers
  public static int max(int[] numbers) {
    int largest = 0;
    for (int number : numbers) {
      if (largest < number) {
        largest = number;
      }
    }
    return largest;
  }

  // Determine the average number in an array of integers
  public static int average(int[] numbers) {
    int average;
    int total = 0;
    for (int number : numbers) {
      total += number;
    }
    average = total/numbers.length;
    return average;
  }

  // Determine sum of numbers in an array of integers
  public static int sum(int[] numbers) {
    int total = 0;
    for(int number : numbers) {
      total += number;
    }
    return total;
  }

  // Determine the percentile in an array of integers
  public static int percentile(int[] numbers, int percentileNum) {
    float totalNum = numbers.length;
    float percentilePosition = totalNum/100 * percentileNum;
    int position = (int) percentilePosition -1;
    return numbers[position];
  }
}
