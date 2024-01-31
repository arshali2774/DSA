package zigzagConv;

/**
 * zigzagconv
 */
public class zigzagconv {

  public static void main(String[] args) {
    String s = "PAYPALISHIRING";
    int numberOfRows = 3;
    System.out.println(convert(s, numberOfRows));
  }

  public static String convert(String s, int numberOfRows) {
    if (numberOfRows == 1)
      return s;

    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < numberOfRows; i++) {
      int j = i;
      int nicheJao = 2 * (numberOfRows - 1 - i);
      int uparJao = 2 * (i);
      boolean direction = true; // true to niche, false to upar.
      while (j < s.length()) {
        sb.append(s.charAt(j));
        if (i == 0) {
          j += nicheJao;
        } else if (i == numberOfRows - 1) {
          j += uparJao;
        } else {
          if (direction) {
            j += nicheJao;
          } else {
            j += uparJao;
          }
          direction = !direction;
        }
      }
    }
    return sb.toString();
  }
}