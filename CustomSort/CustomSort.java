package CustomSort;

// import java.util.Collections;

/**
 * CustomSort
 */
public class CustomSort {

  public static void main(String[] args) {
    String order = "cba", s = "abcd";
    String order1 = "cbafg", s1 = "abcd";
    System.out.println(customSortString(order, s));
    System.out.println(customSortString(order1, s1));
    System.out.println(customSortString2(order, s));
    System.out.println(customSortString2(order1, s1));
  }

  public static String customSortString(String order, String s) {
    StringBuilder str = new StringBuilder();
    // since we know that all characters are in lowercase we know that range will be
    // from 'a' to 'z'.
    // either we make a size of count array 123 for range 0 to ASCII of z which is
    // 122
    // or we make it 26 but then we have to make changes elsewhere.
    int count[] = new int[123];
    /* ---------------- Count freq of each character in string s ---------------- */
    for (char c : s.toCharArray()) {
      ++count[c];
    }
    // order main traverse krenge aur count array main order ke character ka freq
    // deakhnge, agar 0 se bada hai to string main append krenge aur uska count--
    // krenge
    // isse hum 's' string ki sorting kr rahe hai by making the new string.
    for (char c : order.toCharArray()) {
      while (count[c] > 0) {
        str.append(c);
        count[c]--;
      }
    }
    // ab bache hue characters ko append krna hai
    for (char c = 'a'; c <= 'z'; c++) {
      while (count[c] > 0) {
        str.append(c);
        count[c]--;
      }
    }
    return str.toString();
  }

  public static String customSortString2(String order, String s) {
    StringBuilder str = new StringBuilder();
    int count[] = new int[26];
    for (char c : s.toCharArray()) {
      ++count[c - 'a'];
    }
    for (char c : order.toCharArray()) {
      while (count[c - 'a'] > 0) {
        str.append(c);
        count[c - 'a']--;
      }
    }
    for (char c = 'a'; c <= 'z'; c++) {
      while (count[c - 'a'] > 0) {
        str.append(c);
        count[c - 'a']--;
      }
    }
    return str.toString();
  }
}