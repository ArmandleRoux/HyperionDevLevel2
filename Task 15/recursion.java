public class recursion {

    public static void main(String[] args) {
        System.out.println(reverse("Hello World!"));
        fibonacciSequence(8);
    }

    public static String reverse(String sentence) {
        if(sentence == null || sentence.length() <=1) {
            return sentence;
        }
        else {
            return reverse(sentence.substring(1)) + sentence.charAt(0);
        }
    }

    public static  void fibonacciSequence(int number) {
        String sequence = "";
        for(int i = 0; i <= number; i++) {
            sequence += fibonacci(i);
            if (i != number) {
                sequence += ",";
            }
        }
        System.out.println(sequence);
    }
    public static int fibonacci(int number) {
        if (number == 0) {
            return number;
        }
        if (number == 1) {
            return number;
        }
        else {
            return fibonacci(number -1) + fibonacci(number-2);
        }
    }
}
