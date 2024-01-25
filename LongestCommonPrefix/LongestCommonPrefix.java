package LongestCommonPrefix;

/**
 * LongestCommonPrefix
 */
public class LongestCommonPrefix {

  public static void main(String[] args) {
    String[] strs = { "flow", "flight", "flower" };
    System.out.println(longestCommonPrefix(strs));
  }

  public static String longestCommonPrefix(String[] strs) {
    // if array is empty
    if (strs.length == 0)
      return "";
    // picking first string and looping over it.
    for (int i = 0; i < strs[0].length(); ++i)
      // starting from second string in array and checking if characters from first
      // string matches the second string characters.
      // also i should not be greater than the length of the second string we are
      // checking.
      for (int j = 1; j < strs.length; ++j)
        if (i == strs[j].length() || strs[j].charAt(i) != strs[0].charAt(i))
          return strs[0].substring(0, i);

    return strs[0];
  }
}