package StringsDS.DebugExercise;

/**
 * Debug
 */
public class Debug {

  public static void main(String[] args) {
    String s = "123abc12p";
    System.out.println(mystoi(s));
    System.out.println(intToRoman(2234));
    System.out.println(addBinary("101", "111"));
  }

  public static double mystoi(String s) {
    int len = s.length();
    int num = 0;
    int i = 0;
    while (i < len && s.charAt(i) == ' ') {
      i++;
    }
    boolean negative = s.charAt(i) == '-';
    i = negative == true ? i++ : i;
    while (i < len && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
      num = num * 10 + (s.charAt(i) - '0');
      i++;
    }
    num = negative ? -num : num;
    num = (num > Integer.MAX_VALUE) ? Integer.MAX_VALUE : num;
    num = (num < Integer.MIN_VALUE) ? Integer.MIN_VALUE : num;
    return num;
  }

  static String intToRoman(int num) {
    String ones[] = { "", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX" };
    String tens[] = { "", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC" };
    String hrns[] = { "", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM" };
    String ths[] = { "", "M", "MM" };

    return ths[num / 1000] + hrns[(num % 1000) / 100] + tens[(num % 100) / 10] + ones[num % 10];
  }

  static String addBinary(String a, String b) {
    StringBuilder ans = new StringBuilder();
    int carry = 0;
    int i = a.length() - 1;
    int j = b.length() - 1;

    while (i >= 0 || j >= 0 || carry > 0) {
      if (i >= 0)
        carry += a.charAt(i--) - '0';
      if (j >= 0)
        carry += b.charAt(j--) - '0';
      ans.append(carry % 2);
      carry /= 2;
    }

    return ans.reverse().toString();
  }
}