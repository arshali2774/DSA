package RemoveAllAdjacentDuplicateStrings;

/**
 * RemoveAllAdjcentDupStrings
 */
public class RemoveAllAdjcentDupStrings {

  public static void main(String[] args) {
    String s = "abbaca";
    // output = "ca"
    System.out.println("Original String " + s);
    System.out.println("New string: " + removeDupStringBuffer(s));
    System.out.println("New String: " + removeDupStringBuilder(s));
    // ab
  }

  public static String removeDupStringBuilder(String s) {
    StringBuilder str = new StringBuilder();
    // for each loop on a string that is converted to char array
    for (char c : s.toCharArray()) {
      int n = str.length();
      if (n > 0 && str.charAt(n - 1) == c) {
        str.deleteCharAt(n - 1);
      } else {
        str.append(c);
      }
    }
    return str.toString();
  }

  public static String removeDupStringBuffer(String s) {
    StringBuffer str = new StringBuffer(s);
    int i = 0, j = 1;
    while (j < str.length()) {
      if (str.charAt(i) == str.charAt(j)) {
        str.delete(i, j + 1);
        i = 0;
        j = i + 1;
      } else {
        i++;
        j++;
      }
    }
    return str.toString();
  }
}