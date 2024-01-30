package IntegerToRoman;

/**
 * IntegerToRoman
 */
public class IntegerToRoman {

  public static void main(String[] args) {
    int num1 = 3, num2 = 58, num3 = 1994;
    System.out.println(conversion(num1));
    System.out.println(conversion(num2));
    System.out.println(conversion(num3));
  }

  public static String conversion(int num) {
    String romanSymbols[] = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };
    int values[] = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
    StringBuilder ans = new StringBuilder();
    for (int i = 0; i < 13; i++) {
      if (num == 0) {
        break;
      }
      while (num >= values[i]) {
        ans.append(romanSymbols[i]);
        num -= values[i];
      }
    }
    return ans.toString();
  }
}