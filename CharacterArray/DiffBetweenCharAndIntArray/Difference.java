package CharacterArray.DiffBetweenCharAndIntArray;

import java.util.Scanner;

/**
 * Difference is that we don't need to use for loop to take input or print a
 * char array.
 */
public class Difference {
    public static void main(String[] args) {
        // in c++ we can just take one line input and print in one line, with out using
        // for loop.
        // char ch[10]; cin >> ch; cout<<ch;
        // to that in java we do this.
        Scanner sc = new Scanner(System.in);
        char ch[] = sc.next().toCharArray(); // here we can take input in one line.
        System.out.println(new String(ch));// but we have to print the char array after converting to string.
        // if we don't want to convert it to String then we have to use the for loop to
        // print each character.
        sc.close();
    }

}