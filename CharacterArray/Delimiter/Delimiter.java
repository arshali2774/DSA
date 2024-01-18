package CharacterArray.Delimiter;

import java.util.Scanner;

/**
 * Delimiter
 */
public class Delimiter {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        // to take input with space we need to use
        String s = sc.nextLine();
        char ch1[] = s.toCharArray();
        System.out.println(new String(ch1));
        System.out.println(ch1.length);
        // there are certain characters which will stop taking input once it hit the
        // delimiter.
        // here we entered a space seperated string and the input stops after taking the
        // first word
        char ch[] = sc.next().toCharArray();
        System.out.println(new String(ch));

        sc.close();

    }
}