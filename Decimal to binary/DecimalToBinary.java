
/**
 * DecimalToBinary
 */
public class DecimalToBinary {

    public static void main(String[] args) {
        int n1 = 6;
        int binary1 = DecimalToBinaryIterative(n1);
        System.out.println(binary1);
        int n2 = 10;
        DecimalToBinaryBitwise(n2);
    }

    public static void DecimalToBinaryBitwise(int n) {
        for (int i = 8; i >= 0; i--) {
            int k = n >> i;
            if ((k & 1) > 0) {
                System.out.print("1");
            } else {
                System.out.print("0");
            }
        }
        System.out.println();
    }

    public static int DecimalToBinaryIterative(int n) {
        int binary = 0;
        int placesCount = 0;
        while (n != 0) {
            int remainder = n % 2;
            double c = Math.pow(10, placesCount);
            binary = (int) (binary + remainder * c);
            placesCount++;
            n /= 2;
        }
        return binary;
    }
}