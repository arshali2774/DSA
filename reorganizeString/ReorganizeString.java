package reorganizeString;

import java.util.HashMap;
import java.util.Map;

/**
 * ReorganizeString
 * priority queue is used to make the time complexity nlogn
 *
 */

/* ----------------------------- greedy approach ---------------------------- */
// jis character ki freq sabse zyada hai usko place kro with 1 letter gap
// e.g s = aaab then we have 4 places since number of characters are 4
// so we need to place 'a' with gaps a_a_ but we can't as the will be
// consecutive
// lets take another example s = 'aaabbef'.
// a_a_a__ now we take b since it has freq is high
// a_a_a_b and we place it after 1 gap to 'a'
// aba_a_b now 'e' and 'f'
// abaeafb this is our answer.
public class ReorganizeString {

  public static void main(String[] args) {
    String s1 = "aab", s2 = "aaab", s3 = "aaabbef";
    System.out.println(reorganize(s1));
    System.out.println(reorganize(s2));
    System.out.println(reorganize(s3));
  }

  public static String reorganize(String s) {
    StringBuilder mutableString = new StringBuilder(s);
    int hashMap[] = new int[26];
    for (Character c : s.toCharArray()) {
      hashMap[c - 'a']++;
    }
    // find the most freq character
    char most_freq_char = ' ';
    int maxFreq = Integer.MIN_VALUE;
    for (int i = 0; i < hashMap.length; i++) {
      if (hashMap[i] > maxFreq) {
        maxFreq = hashMap[i];
        most_freq_char = (char) (i + 'a');
      }
    }

    int index = 0;
    while (maxFreq > 0 && index < s.length()) {
      mutableString.setCharAt(index, most_freq_char);
      maxFreq--;
      index += 2;
    }

    if (maxFreq != 0) {
      return "";
    }

    hashMap[most_freq_char - 'a'] = 0;

    // place rest of characters

    for (int i = 0; i < hashMap.length; i++) {
      while (hashMap[i] > 0) {
        index = index >= s.length() ? 1 : index;
        mutableString.setCharAt(index, (char) (i + 'a'));
        hashMap[i]--;
        index += 2;
      }
    }
    return mutableString.toString();
  }
}