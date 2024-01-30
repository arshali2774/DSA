package IsomorphicString;

import java.util.HashMap;
import java.util.Map;

/**
 * IsomorphicString
 */
public class IsomorphicString {

  public static void main(String[] args) {
    String s = "paper", t = "title";
    System.out.println(isIsomorphic(s, t));
    System.out.println(isIsomorphicUsingMap(s, t));
  }

  public static boolean isIsomorphicUsingMap(String s, String t) {
    // 1 test case failed
    Map<Character, Integer> sCharMap = new HashMap<>();
    Map<Character, Integer> tCharMap = new HashMap<>();
    for (int i = 0; i < s.length(); i++) {
      if (sCharMap.put(s.charAt(i), i) != tCharMap.put(t.charAt(i), i)) {
        return false;
      }
    }
    return true;
  }

  public static boolean isIsomorphic(String s, String t) {
    char hash[] = new char[256];
    boolean istCharacterMapped[] = new boolean[256];

    for (int i = 0; i < s.length(); i++) {
      if (hash[s.charAt(i)] == 0 && istCharacterMapped[t.charAt(i)] == false) {
        hash[s.charAt(i)] = t.charAt(i);
        istCharacterMapped[t.charAt(i)] = true;
      }
    }

    for (int i = 0; i < s.length(); i++) {
      if (hash[s.charAt(i)] != t.charAt(i)) {
        return false;
      }
    }

    return true;
  }
}