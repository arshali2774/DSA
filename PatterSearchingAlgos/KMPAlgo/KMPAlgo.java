package PatterSearchingAlgos.KMPAlgo;

/**
 * KMPAlgo
 */
public class KMPAlgo {
  void KMPSearch(String pat, String txt) {
    int M = pat.length();
    int N = txt.length();

    int lps[] = new int[M];
    int j = 0;
    computeLPSArray(pat, M, lps);
    int i = 0;
    while (i < N) {
      if (pat.charAt(j) == txt.charAt(i)) {
        j++;
        i++;
      }
      if (j == M) {
        System.out.println("Found pattern " + "at index " + (i - j));
        j = lps[j - 1];
      }
      // mismatch after j matches
      else if (i < N && pat.charAt(j) != txt.charAt(i)) {
        if (j != 0)
          j = lps[j - 1];
        else
          i = i + 1;
      }
    }
  }

  void computeLPSArray(String pat, int M, int lps[]) {
    int len = 0;// length of previous longest prefix suffix
    int i = 1;
    lps[0] = 0; // lps[0] is always 0.

    // calculate lps[i] for i=1 to M-1
    while (i < M) {
      if (pat.charAt(i) == pat.charAt(len)) {
        // agar characters same hai to len badhao i badhao aur lps[i] ko set kro len
        // barabar.
        len++;
        lps[i] = len;
        i++;
      } else {
        // (pat[i] != pat[len])
        // This is tricky. Consider the example.
        // AAACAAAA and i = 7. The idea is similar
        // to search step.
        if (len != 0) {
          len = lps[len - 1];
          // Also, note that we do not increment i here
        } else { // if (len == 0)
          lps[i] = len;
          i++;
        }
      }
    }

  }

  public static void main(String[] args) {
    String txt = "ABABDABACDABABCABAB";
    String pat = "ABABCABAB";
    new KMPAlgo().KMPSearch(pat, txt);
  }
}