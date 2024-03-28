package SquareRootPrecision_09;

import java.text.DecimalFormat;

/**
 * SquareRootPrecision
 * to limit the decimal precision either use
 * Decimal format like below
 * Or use String.format(%.5f,ans)
 * or use Big decimal
 */
public class SquareRootPrecisionCode {
  private static final DecimalFormat df = new DecimalFormat("0.00000");

  public static void main(String[] args) {
    int target = 51;
    String sqrt = sqrtPrecision(target);
    System.out.println(sqrt);
  }

  public static String sqrtPrecision(int target) {
    double ans = sqrt(target);
    double step = 0.1;
    int precision = 5;
    for (int i = 0; i < precision; i++) {
      double j = ans;
      while (j * j <= target) {
        ans = j;
        j += step;
      }
      step /= 10;
    }
    return df.format(ans);
  }

  public static int sqrt(int target) {
    int low = 1, high = target;
    while (low <= high) {
      int mid = low + (high - low) / 2;
      if (mid * mid == target) {
        return mid;
      } else if (mid * mid < target) {
        low = mid + 1;
      } else {
        high = mid - 1;
      }
    }
    return high;
  }
}