package BinaryToDecimal;

/**
 * BinaryToDecimal
 */
public class BinaryToDecimal {

    public static void main(String[] args) {
        int n = 101, sum = 0, factor = 1;
        while (n != 0) {
            int digit = n % 10;
            sum += digit * factor;
            factor = 2 * factor;
            n = n / 10;
        }
        System.out.println(sum);
    }
}