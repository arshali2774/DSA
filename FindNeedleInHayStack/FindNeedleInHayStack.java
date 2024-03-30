
public class FindNeedleInHayStack {

  public static void main(String[] args) {
    String haystack1 = "butsad", needle1 = "sad";
    String haystack2 = "leetcode", needle2 = "leeto";
    System.out.println(findTheNeedle(haystack1, needle1));
    System.out.println(findTheNeedle(haystack2, needle2));
  }

  public static int findTheNeedle(String haystack, String needle) {
    int ans = -1;
    int n = haystack.length();
    int m = needle.length();

    for (int i = 0; i <= n - m; i++) {
      for (int j = 0; j < m; j++) {
        if (needle.charAt(j) != haystack.charAt(i + j)) {
          break;
        }
        if (j == m - 1) {
          ans = i;
          return ans;
        }
      }
    }
    return ans;
  }
}