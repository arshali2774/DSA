package ValidPalindrome2;

/**
 * ValidPalindrome2
 */
public class ValidPalindrome2 {
  // remove atmost 1 character to make the string a valid palindrome
  public static void main(String[] args) {
    String s1 = "aba";// no need to remove anything already a valid palindrome
    String s2 = "abca"; // can delete 'c'
    String s3 = "abc"; // can't make palindrome
    System.out.println(isPalindrome(s3));
    System.out.println(isPalindrome(s2));
    System.out.println(isPalindrome(s1));
  }

  public static boolean isPalindrome(String s) {
    int i = 0, j = s.length() - 1;
    while (i <= j) {// here i<j and i<=j no difference both will work
      if (s.charAt(i) == s.charAt(j)) {
        i++;
        j--;
      } else {
        // remove 1 character and check
        // we can remove either ith character
        boolean check1 = checkSubstringForPalindrome(s, i + 1, j);
        // or we can remove the jth character
        boolean check2 = checkSubstringForPalindrome(s, i, j - 1);
        return check1 || check2;
      }
    }
    return true;
  }

  public static boolean checkSubstringForPalindrome(String s, int start, int end) {
    // s = s.substring(start, end);
    while (start <= end) {
      if (s.charAt(start) != s.charAt(end)) {
        return false;
      } else {
        start++;
        end--;
      }
    }
    return true;
  }
}