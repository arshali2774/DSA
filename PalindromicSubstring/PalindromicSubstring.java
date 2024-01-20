package PalindromicSubstring;

/**
 * PalindromicSubstring
 */
public class PalindromicSubstring {

  public static void main(String[] args) {
    String s1 = "abc";// output = 3, 'a','b','c' // oddlength ki 3 substring
    String s2 = "aaa";// output=6, 'a','a','a','aa','aa','aaa' //odd length ki 4 substring, even
                      // lemgth ki 2

    System.out.println(countSubstring(s1));
    System.out.println(countSubstring(s2));
  }

  public static int countSubstring(String s) {
    int count = 0;
    for (int center = 0; center < s.length(); center++) {
      // odd substrings jo palindromes hai
      int oddSubstrPalindromeCount = expand(s, center, center);
      // even substring jo palindrome hai
      int evenSubstrPalindromeCount = expand(s, center, center + 1);
      count += oddSubstrPalindromeCount + evenSubstrPalindromeCount;
    }
    return count;
  }

  public static int expand(String s, int i, int j) {
    int countSubstring = 0;
    while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
      countSubstring++;
      i--;
      j++;
    }
    return countSubstring;
  }
}