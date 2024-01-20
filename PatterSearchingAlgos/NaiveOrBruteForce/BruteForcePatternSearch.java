package PatterSearchingAlgos.NaiveOrBruteForce;

/**
 * BruteForcePatternSearch
 */
public class BruteForcePatternSearch {

  public static void main(String[] args) {
    String s = "AABAACAADAABAAABAA", pattern = "AABA";
    int m = s.length();
    int n = pattern.length();
    for (int i = 0; i <= m - n; i++) {
      int j;
      for (j = 0; j < n; j++) {
        if (s.charAt(i + j) != pattern.charAt(j))
          break;
      }
      if (j == n) {
        System.out.println("Pattern Found at index " + i);
      }
    }
  }
}