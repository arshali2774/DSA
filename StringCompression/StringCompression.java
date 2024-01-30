package StringCompression;

/**
 * StringCompression
 */
public class StringCompression {

  public static void main(String[] args) {
    char chars1[] = { 'a', 'a', 'b', 'b', 'c', 'c', 'c' };
    char chars2[] = { 'a' };
    char chars3[] = { 'a', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b' };
    System.out.println(compress(chars1));
    System.out.println(compress(chars2));
    System.out.println(compress(chars3));
  }

  public static int compress(char[] chars) {
    int ans = 0;
    for (int i = 0; i < chars.length;) {
      char letter = chars[i];
      int count = 0;
      while (i < chars.length && letter == chars[i]) {
        count++;
        i++;
      }
      chars[ans++] = letter;
      if (count > 1) {
        for (char c : String.valueOf(count).toCharArray()) {
          chars[ans++] = c;
        }
      }
    }
    return ans;
  }

}