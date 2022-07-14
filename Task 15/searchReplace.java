import java.util.Scanner;

public class searchReplace {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter a string: ");
        String sentence = input.nextLine();
        System.out.println("Please enter the substring you wish to find: ");
        String subString = input.nextLine().toLowerCase();
        System.out.println("Please enter a string to replace the given substring: ");
        String replaceString = input.nextLine().toLowerCase();
        System.out.println(replace(sentence, subString, replaceString));
        input.close();
    }
    public static String replace(String sentence, String subString, String newString) {
        if(!sentence.toLowerCase().contains(subString)) {
            return sentence.substring(0,1).toUpperCase() + sentence.substring(1);
        }
        else {
            return replace(sentence.toLowerCase().replace(subString,newString),
                           subString, newString);
        }
    }
}
