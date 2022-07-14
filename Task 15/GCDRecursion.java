public class GCDRecursion {


    public static void main(String[] args) {
        System.out.println(gcd(520,80));
    }
    public static int gcd(int num1, int num2)
    {
        if (num2 != 0)
            return gcd(num2, num1 % num2);
        else
            return num1;
    }
}
