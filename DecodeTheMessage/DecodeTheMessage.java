package DecodeTheMessage;

/**
 * DecodeTheMessage
 */
public class DecodeTheMessage {

  public static void main(String[] args) {
    String key = "the quick brown fox jumps over the lazy dog";
    String message = "vkbs bs t suepuv";
    System.out.println(decodeMessage(key, message));
  }

  public static String decodeMessage(String key, String message) {
    char start = 'a';
    char mapping[] = new char[280];// must be >=256
    for (char c : key.toCharArray()) {
      if (c != ' ' && mapping[c] == 0) {
        mapping[c] = start;
        start++;
      }
    }
    StringBuilder ans = new StringBuilder();
    for (char c : message.toCharArray()) {
      if (c == ' ') {
        ans.append(' ');
      } else {
        char decodedCharacter = mapping[c];
        ans.append(decodedCharacter);
      }

    }
    return ans.toString();
  }
}