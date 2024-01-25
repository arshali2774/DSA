package ReverseOnlyLetters;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * ReverseOnlyLetters
 */
public class ReverseOnlyLetters {

  public static void main(String[] args) {
    String s = "Test1ng-Leet=code-Q!";
    String s1 = "ab-cd";
    ReverseOnlyLetters obj1 = new ReverseOnlyLetters();
    String res = obj1.reverseOnlyLetters(s);
    String res1 = obj1.reverseOnlyLetters(s1);
    System.out.println(res);
    System.out.println(res1);
    String res2 = obj1.swappingTwoPointer(s);
    String res3 = obj1.swappingTwoPointer(s1);
    System.out.println(res2);
    System.out.println(res3);
  }

  public String swappingTwoPointer(String s) {
    int i = 0, j = s.length() - 1;
    StringBuilder str = new StringBuilder(s);
    while (i < j) {
      if (Character.isAlphabetic(s.charAt(i)) && Character.isAlphabetic(s.charAt(j))) {
        str.setCharAt(i, s.charAt(j));
        str.setCharAt(j, s.charAt(i));
        i++;
        j--;
      } else if (!Character.isAlphabetic(s.charAt(i))) {
        i++;
      } else {
        j--;
      }
    }
    return str.toString();
  }

  public String reverseOnlyLetters(String s) {
    List<Integer> list = new ArrayList<>();
    List<Character> listChar = new ArrayList<>();
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) < 'A' || (s.charAt(i) > 'Z' && s.charAt(i) < 'a') || s.charAt(i) > 'z') {
        // kuch krna hai
        list.add(i);
        listChar.add(s.charAt(i));
      }
    }
    System.out.println(list);
    System.out.println(listChar);
    StringBuilder withoutNonLetters = new StringBuilder();
    int start = 0;
    for (int i : list) {
      withoutNonLetters.append(s.substring(start, i));
      start = i + 1;
    }
    withoutNonLetters.append(s.substring(start));
    withoutNonLetters.reverse();
    System.out.println(withoutNonLetters);
    for (int i = 0; i < list.size(); i++) {
      int pos = list.get(i);
      withoutNonLetters.insert(pos, listChar.get(i));
    }
    return withoutNonLetters.toString();
  }
}