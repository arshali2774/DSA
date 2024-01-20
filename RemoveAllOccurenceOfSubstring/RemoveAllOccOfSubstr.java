package RemoveAllOccurenceOfSubstring;

public class RemoveAllOccOfSubstr {
  public static void main(String[] args) {
    String s1 = "daabcbaabcbc", part1 = "abc"; // "dab"
    String s2 = "axxxxyyyyb", part2 = "xy"; // "ab"
    System.out.println("Answer 1: " + removeSubstr(s2, part2));
    System.out.println("Answer 2: " + removeSubString(s1, part1));
  }

  public static String removeSubString(String s, String part) {
    int pos = s.indexOf(part);
    while (pos != -1) {
      s = s.substring(0, pos) + s.substring(pos + part.length());
      pos = s.indexOf(part);
    }
    return s;
  }

  public static String removeSubstr(String s, String part) {
    StringBuilder str = new StringBuilder(s);
    // make a copy of string
    int j = 0; // pointer for str
    for (int i = 0; i < s.length(); i++) {
      str.setCharAt(j, s.charAt(i));// setting character from string s at index i to string str at index j
      j++;
      if (j >= part.length() && str.substring(j - part.length(), j).toString().equals(part)) {
        // if j>= length of substring and same length ki substring agar str main milti
        // hai to hum j ko utna length peeche bhej denge taaki hum waha ith character
        // rakh sake.
        // for the case of a x x x x y y y y b,when we reach i=5 (on first y) then,
        // we set 'y' on index 5 as j is also 5 from previous iteration.
        // now j = 6 and j>=2 as target substring length is 2.
        // now we find substring in the big string, from index 4 to index 6. which is xy
        // and therefore we get true
        // now we change j = 4, and j is pointing here, a x x x 'x' y y y y b.
        // on next iteration we will set this character as 'y' as i=6 and pointing at
        // 'y'.
        // now we get the string a x x x y 'y' y y y b, and j is at index 5.
        // same thing j>= 2 and substring from index 2 to 4 is matched therefore, j=3;
        // we set that to y and so on.
        // when we i reaches at last character 'b', j will be at index 1.
        // so we will set index as b and increase j but our substring will not match and
        // for loop will end.
        j -= part.length();
      }
    }
    // at end we will get string abyyyyyyyb, while j is at index 2 since we did j++.
    return str.substring(0, j).toString();
  }
}
