package CharacterArray.CheckPalindrome;

/**
 * CheckPalindrome
 */
public class CheckPalindrome {

    public static void main(String[] args) {
        // char ch[] = "racecar".toCharArray();
        char ch[] = "Lion".toCharArray();
        int i = 0;
        int j = ch.length - 1;
        boolean flag = false;
        while (i <= j) {
            if (ch[i] == ch[j]) {
                i++;
                j--;
                flag = true;
            } else {
                flag = false;
                break;
            }
        }
        System.out.println(flag ? "Palindrome" : "Not Palindrome");
    }
}