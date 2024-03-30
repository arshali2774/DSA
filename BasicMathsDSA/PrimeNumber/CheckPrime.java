package BasicMathsDSA.PrimeNumber;

/**
 * CheckPrime
 */
public class CheckPrime {

  public static void main(String[] args) {
    int num1 = 5, num2 = 1, num3 = 2, num4 = 10, num5 = 29;
    System.out.println(checkPrime(num1));
    System.out.println(checkPrime(num2));
    System.out.println(checkPrime(num3));
    System.out.println(checkPrime(num4));
    System.out.println(checkPrime(num5));
  }

  public static boolean checkPrime(int num) {
    if (num == 1)
      return false;
    for (int i = 2; i < num; i++) {
      if (num % i == 0) {
        return false;
      }
    }
    return true;
  }
}