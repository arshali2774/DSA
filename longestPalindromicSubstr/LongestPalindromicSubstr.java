package longestPalindromicSubstr;

/**
 * LongestPalindromicSubstr
 */
public class LongestPalindromicSubstr {

  public static void main(String[] args) {
    String s = "babad", s2 = "cbbd";
    System.out.println(bruteForeceSolution(s2));
  }

  private static boolean isPalindrome(String s, int i, int j) {
    while (i < j) {
      if (s.charAt(i) != s.charAt(j)) {
        return false;
      }
      i++;
      j--;
    }
    return true;
  }

  public static String bruteForeceSolution(String s) {
    int start = 0;
    int end = 0;
    String ans = "";
    for (int i = 0; i < s.length(); i++) {
      for (int j = i; j < s.length(); j++) {
        if (isPalindrome(s, i, j)) {
          // String t = s.substring(i, j - i + 1);
          // ans = t.length() > ans.length() ? t : ans;
          if (j - i > end - start) {
            start = i;
            end = j;
          }
        }
      }
    }
    ans = s.substring(start, end + 1);
    return ans;
  }

}