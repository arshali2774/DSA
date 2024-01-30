package StringToIntATOI;

/**
 * StringToIntATOI
 */
public class StringToIntATOI {

  public static void main(String[] args) {
    String s = "2147483648";
    System.out.println(conversion(s));
    System.out.println(conversion2(s));
  }

  public static int conversion2(String s) {
    int val = 0, sign = 0, i = 0;
    s = s.trim();
    if (i < s.length() && (s.charAt(i) == '-' || s.charAt(i) == '+')) {
      sign = s.charAt(i) == '+' ? 0 : 1;
      i++;
    }
    while (i < s.length()) {
      if (Character.isDigit(s.charAt(i))) {
        if (val > Integer.MAX_VALUE / 10 || (val == Integer.MAX_VALUE / 10 && s.charAt(i) > '7')) {
          return sign == 0 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        }
        int num = s.charAt(i) - '0';
        val = val * 10 + num;
        System.out.println(val);
        i++;
      } else {
        break;
      }

    }
    if (sign == 1) {
      val = -val;
    }
    return val;

  }

  public static int conversion(String s) {
    // to trim white space we can use string function trim();
    int val = 0, sign = 0, i = 0; // sign=0 than positive, else negative

    while (s.charAt(i) == ' ')
      i++;
    if (i < s.length() && (s.charAt(i) == '-' || s.charAt(i) == '+')) {
      sign = s.charAt(i) == '+' ? 0 : 1;
      i++;
    }
    while (i < s.length()) {
      if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
        // Character.isDigit(s.charAt(i)) to check if the character is digit.
        if (val > Integer.MAX_VALUE / 10 || (val == Integer.MAX_VALUE / 10 && s.charAt(i) > '7')) {
          // why we are not checking for just MAX_VALUE, because hum multiply kr rahe
          // hai to agar humara number multiply krte hi bada hogaya to waha error
          // dega. Islye pehle check kr rahe. adad
          return sign == 1 ? Integer.MIN_VALUE : Integer.MAX_VALUE;

        }
        int num = s.charAt(i) - '0';
        // int ki max value hoti hai 2147483647, aur agar humara number 214748364 hai to
        // usme agar hum 10 multiply krenge to banega 2147483640 ab hum isme 0 se lekar
        // 7 tak hi plus kr sakte hai, agar character 8 ya 9 aayega to out of bounds
        // chala jayega. To upar ek aur condition add hogi
        val = val * 10 + num;
        i++;
      } else {
        break;
      }
    }
    if (sign == 1) {
      val = -val;
    }
    return val;
  }
}