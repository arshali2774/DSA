package ValidAnagram;

import java.util.Arrays;

/**
 * ValidAnagram
 */
public class ValidAnagram {

  public static void main(String[] args) {
    String s = "anagram", t = "nasaram";
    System.out.println();
    usingSorting(s, t);
    System.out.println();
    usingIndexOfAndDelete(s, t);
    System.out.println();
    boolean ans = usingFreqTable(s, t);
    System.out.println(ans ? "anagram" : "not anagram");
  }

  static boolean usingFreqTable(String s, String t) {
    if (s.length() != t.length())
      return false;
    int freq[] = new int[256];
    for (int c : s.toCharArray()) {
      freq[c]++;
    }
    for (int c : t.toCharArray()) {
      freq[c]--;
    }
    for (int i : freq) {
      if (i != 0)
        return false;
    }
    return true;
  }

  static void usingIndexOfAndDelete(String s, String t) {
    // is tarike main problem ye hai ki hum t ko change kredenge
    if (s.length() != t.length()) {
      System.out.println("Not anagram");
      return;
    }
    StringBuilder str = new StringBuilder(t);
    for (char c : s.toCharArray()) {
      int indexOfCharIn_T = t.indexOf(c);
      if (indexOfCharIn_T >= 0) {
        str.deleteCharAt(indexOfCharIn_T);
        t = str.toString();
      } else {
        System.out.println("Not anagram");
        return;
      }
    }
    System.out.println("anagram");
  }

  static void usingSorting(String s, String t) {
    char[] c = s.toCharArray();
    char[] c1 = t.toCharArray();
    Arrays.sort(c);
    Arrays.sort(c1);
    int i = 0;
    int flag = 0;
    while (i < s.length()) {
      if (c[i] == c1[i]) {
        i++;
      } else {
        flag = 1;
        break;
      }
    }
    System.out.println(flag == 0 ? "anagram" : "not anagram");
  }
}