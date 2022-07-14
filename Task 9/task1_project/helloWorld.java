import java.util.Scanner;

public class helloWorld {

public static void main(String[] args) {

    Scanner input = new Scanner(System.in);

    System.out.println("Git is Awesome");

    System.out.println("Enter a word: ");
    String userWord = input.next();
    System.out.println("You entered the word " + userWord);

    input.close();
}

}