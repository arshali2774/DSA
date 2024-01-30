package ReverseVowels;

import java.util.Arrays;
import java.util.Collections;

/**
 * ReverseVowels
 */
public class ReverseVowels {

  public static void main(String[] args) {
    String str = "leetcode";
    System.out.println(reverseVowels(str));

  }

  public static boolean isVowel(char c) {
    String vowelString = "aeiouAEIOU";
    int index = vowelString.indexOf(c);
    if (index != -1)
      return true;
    else
      return false;
  }

  public static String reverseVowels(String s) {
    StringBuilder str = new StringBuilder(s);
    int i = 0, j = s.length() - 1;
    while (i < j) {
      if (isVowel(s.charAt(i)) && isVowel(s.charAt(j))) {
        str.setCharAt(i, s.charAt(j));
        str.setCharAt(j, s.charAt(i));
        i++;
        j--;
      } else if (!isVowel(s.charAt(i))) {
        i++;
      } else if (!isVowel(s.charAt(j))) {
        j--;
      }
    }
    return str.toString();
  }
}