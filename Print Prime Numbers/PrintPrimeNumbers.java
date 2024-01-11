/**
 * PrintPrimeNumbers
 */
public class PrintPrimeNumbers {

    public static void main(String[] args) {
        // printing prime numbers between 2 and 50
        int n = 10, flag = 1;
        for (int i = 2; i <= n; i++) {
            flag = 1;
            for (int j = 2; j <= i / 2; j++) {
                if (i % j == 0) {
                    flag = 0;
                }
            }
            if (flag == 1) {
                System.out.print(i + " ");
            }
        }

        System.out.println();
    }
}