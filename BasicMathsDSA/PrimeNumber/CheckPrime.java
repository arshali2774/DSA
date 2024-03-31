package BasicMathsDSA.PrimeNumber;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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
    // Sieve of Eratosthenes
    System.out.println("Number of primes between 0 and " + num4 + " : " + countPrimes(num4));
    System.out.println("Number of primes between 0 and " + num5 + " : " + countPrimes(num5));
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

  public static boolean checkPrimeSqrt(int num) {
    if (num == 1)
      return false;
    for (int i = 2; i <= Math.sqrt(num); i++) {
      if (num % i == 0) {
        return false;
      }
    }
    return true;
  }

  public static int countPrimes(int num) {
    if (num <= 1)
      return 0;
    List<Boolean> primeNumbersArr = new ArrayList<>(Collections.nCopies(num, true));
    primeNumbersArr.set(0, false);
    primeNumbersArr.set(1, false);
    int ans = 0;
    for (int i = 2; i < num; i++) {
      if (primeNumbersArr.get(i)) {
        ans++;
        int j = 2 * i;
        while (j < num) {
          primeNumbersArr.set(j, false);
          j += i;
        }
      }
    }
    return ans;
  }
}