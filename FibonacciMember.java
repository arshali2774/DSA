/**
 * FibonacciMember
 */
public class FibonacciMember {

    public static void main(String[] args) {
        int n = 6;
        boolean isNFibbonacciNumber = isFibonacciNumber(n);
        System.out.println(isNFibbonacciNumber + " ");
    }

    public static boolean isFibonacciNumber(int n) {
        if (n == 0 || n == 1) {
            return true;
        }
        int f1 = 1, f2 = 1;
        while (true) {
            int temp = f1 + f2;
            f1 = f2;
            f2 = temp;
            if (temp == n) {
                return true;
            } else if (temp > n) {
                return false;
            }
        }
    }
}