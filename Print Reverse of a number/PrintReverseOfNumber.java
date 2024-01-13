/**
 * PrintReverseOfNumber
 */
public class PrintReverseOfNumber {

    public static void main(String[] args) {
        int n = 1234;
        int a = 0;
        int z = n, digits = 0;
        while (z != 0) {
            z = z / 10;
            digits++;
        }
        while (n != 0) {
            int k = n % 10, places = digits - 1;
            k = (int) (k * Math.pow(10, places));
            a = a + k;
            digits--;
            n = n / 10;
        }
        System.out.println(a);
    }
}