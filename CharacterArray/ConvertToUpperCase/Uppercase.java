package CharacterArray.ConvertToUpperCase;

import java.util.Scanner;

/**
 * Uppercase
 */
public class Uppercase {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        char[] ch = s.toCharArray();
        convertToUpperCase(ch);
        System.out.println(new String(ch));
    }

    public static void convertToUpperCase(char[] ch) {
        int i = 0;
        while (i < ch.length) {
            if (ch[i] >= 'a' && ch[i] <= 'z') {
                ch[i] -= 'a';
                ch[i] += 'A';
            }
            i++;
        }
    }
}