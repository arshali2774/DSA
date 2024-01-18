package CharacterArray.ReverseString;

/**
 * ReverseString
 */
public class ReverseString {

    public static void main(String[] args) {
        char ch[] = { 'A', 'r', 's', 'h' };
        reversedStringFunc(ch);
        System.out.println(new String(ch));
    }

    public static void reversedStringFunc(char ch[]) {
        int i = 0;
        int length = ch.length;
        int j = length - 1;
        while (i <= j) {
            swap(ch, i, j);
            i++;
            j--;
        }
    }

    public static void swap(char ch[], int i, int j) {
        char temp = ch[i];
        ch[i] = ch[j];
        ch[j] = temp;
    }
}