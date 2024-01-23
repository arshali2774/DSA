package FindAndReplacePattern;

import java.util.ArrayList;
import java.util.List;

/**
 * Findandreplacepattern
 */
public class Findandreplacepattern {

  public static void main(String[] args) {
    String[] words = { "abc", "deq", "mee", "aqq", "dkd", "ccc" };
    String pattern = "moo";
    List<String> ans = findAndReplacePattern(words, pattern);
    for (String s : ans) {
      System.out.println(s);
    }
    List<String> ans1 = findAndReplacePattern2(words, pattern);
    for (String s : ans1) {
      System.out.println(s);
    }
  }

  public static List<String> findAndReplacePattern2(String[] words, String pattern) {
    List<String> list = new ArrayList<>();
    for (String word : words) {
      if (isCheck(word, pattern)) {
        list.add(word);
      }
    }
    return list;
  }

  public static boolean isCheck(String word, String pattern) {
    for (int i = 0; i < word.length(); i++) {
      if (pattern.indexOf(pattern.charAt(i)) != word.indexOf(word.charAt(i))) {
        return false;
      }
    }
    return true;
  }

  public static List<String> findAndReplacePattern(String[] words, String pattern) {

    List<String> list = new ArrayList<>();
    // normalize the pattern
    String normalizedPattern = mapping(pattern);
    for (String s : words) {
      String normalizedString = mapping(s);
      if (normalizedString.matches(normalizedPattern)) {
        list.add(s);
      }
    }
    return list;
  }

  // normalizes all the strings via mapping and it makes it easy to compare.
  public static String mapping(String s) {
    char start = 'a';
    char[] patternMapping = new char[256];
    // mapping
    for (char c : s.toCharArray()) {
      if (patternMapping[c] == 0) {
        patternMapping[c] = start;
        start++;
      }
    }
    // update the string
    StringBuilder str = new StringBuilder();
    for (char c : s.toCharArray()) {
      str.append(patternMapping[c]);
    }
    return str.toString();
  }
}