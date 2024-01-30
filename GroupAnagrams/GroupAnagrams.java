package GroupAnagrams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * GroupAnagrams
 */
public class GroupAnagrams {

  public static void main(String[] args) {
    String[] strs = { "eat", "tea", "tan", "ate", "nat", "bat" };
    System.out.println(groupAnagrams(strs));
    System.out.println(grpAnagramsWithoutSorting(strs));
  }

  private static String key(String s) {
    char[] arr = new char[26];
    for (char c : s.toCharArray()) {
      arr[c - 'a']++;
    }
    return new String(arr);
  }

  public static List<List<String>> grpAnagramsWithoutSorting(String[] strs) {

    Map<String, List<String>> map = new LinkedHashMap<>();
    List<List<String>> result = new ArrayList<>();
    for (String s : strs) {
      String key = key(s);
      if (map.get(key) != null) {
        map.get(key).add(s);
      } else {
        List<String> list = new ArrayList<>();
        list.add(s);
        map.put(key, list);
        result.add(list);
      }
    }
    return result;
  }

  public static List<List<String>> groupAnagrams(String[] strs) {
    Map<String, List<String>> mapKey = new HashMap<>();
    for (String str : strs) {
      char[] ch = str.toCharArray();
      Arrays.sort(ch);
      String key = String.valueOf(ch);
      // Check if key is already present in the map
      // if (mapKey.containsKey(key)) {
      // // Key is present, get the existing list and add the current string
      // List<String> anagramList = mapKey.get(key);
      // anagramList.add(str);
      // } else {
      // // Key is not present, create a new list, add the current string, and put it
      // in
      // // the map
      // List<String> anagramList = new ArrayList<>();
      // anagramList.add(str);
      // mapKey.put(key, anagramList);
      // }
      // above commented lines is a way to write the same thing written below
      mapKey.computeIfAbsent(key, k -> new ArrayList<>()).add(str);
    }
    return new ArrayList<>(mapKey.values());
  }
}