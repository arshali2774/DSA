package StringsDS.StringMethods;

/**
 * StringMethods
 */
public class StringMethods {

    public static void main(String[] argsStrings) {
        String s = "Hello World";
        System.out.println();
        print("Printing String: ");
        print(s);
        System.out.println();
        System.out.println();
        print("Printing character at an index in the string: ");
        print(s.charAt(0));
        System.out.println();
        System.out.println();
        print("Printing UNICODE of a character at an index in the string: ");
        print(s.codePointAt(0));
        System.out.println();
        System.out.println();
        print("Printing UNICODE of a character before an index in the string: ");
        print(s.codePointBefore(4));
        System.out.println();
        System.out.println();
        print("Printing number of UNICODE code points of characters between a range of indexes in the string(number of characters between a beginIndex and an endIndex, endIndex is excluded): ");
        print(s.codePointCount(0, 6));
        System.out.println();
        System.out.println();
        print("Printing the comparison by comparing two strings lexicographically (WITH CASE COMPARISONS): ");
        print(s.compareTo("Hello World"));
        System.out.println();
        print("Prints 0 if there is an exact match");
        System.out.println();
        print("Prints POSITIVE number if the given string is smaller lexicographically");
        System.out.println();
        print(s.compareTo("Arsh Ali"));
        System.out.println();
        print("Prints NEGATIVE number if the given string is larger lexicographically");
        System.out.println();
        print(s.compareTo("xxxxxxxxxxx"));
        System.out.println();
        System.out.println();
        print("Printing the comparison by comparing two strings lexicographically (WITHOUT CASE COMPARISONS): ");
        print(s.compareToIgnoreCase("hello world"));
        System.out.println();
        print("Prints 0 if there is an exact match");
        System.out.println();
        print("Prints POSITIVE number if the given string is smaller lexicographically");
        System.out.println();
        print(s.compareToIgnoreCase("Arsh Ali"));
        System.out.println();
        print("Prints NEGATIVE number if the given string is larger lexicographically");
        System.out.println();
        print(s.compareToIgnoreCase("xxxxxxxxxxx"));
        System.out.println();
        System.out.println();
        print("Concatenates the specified string to the end of this string: ");
        print(s.concat(" arsh"));
        System.out.println();
        System.out.println();
        print("Returns true if and only if this string contains the specified sequence of char values: ");
        print(s.contains("orld"));
        System.out.println();
        System.out.println();
        print("Compares this string to the specified CharSequence: ");
        print(s.contains("orld"));
        System.out.println();
        System.out.println();
        print("Compares this string to the specified StringBuffer: ");
        print(s.contentEquals(new StringBuffer("World")));
        System.out.println();
        System.out.println();
        print("Copies value of character array: ");
        // char ch[] = { 'a', 'b' };
        // print(s.copyValueOf(ch));
        System.out.println();
        System.out.println("Original String " + s);
        System.out.println();
        System.out.println();
        print("Check if string ends with specified string: ");
        print(s.endsWith("rld"));
        System.out.println();
        System.out.println();
        print("Returns the index within this string of the first occurrence of the specified character, substring (CASE SENSITIVE): ");
        print(s.indexOf("or"));
        System.out.print(", ");
        print(s.indexOf('w'));
        System.out.print(", ");
        print(s.indexOf('W'));
        System.out.println();
        System.out.println();
        print("Returns the index within this string of the first occurrence of the specified character, substring, starting the search at the specified index: ");
        print(s.indexOf("or", 4));
        System.out.print(", ");
        print(s.indexOf("or", 8));
        System.out.println();
        System.out.println();
        print("Returns the true, if length() is 0: ");
        print(s.isEmpty());
        System.out.println();
        System.out.println();
        print("Similar to indexOf, it return the last occurrence of the specified character or substring: ");
        print(s.lastIndexOf("ll"));
        System.out.println();
        System.out.println();
        print("Similar to indexOf, it return the last occurrence of the specified character or substring, starting backwards from specified index: ");
        print(s.lastIndexOf("ll", 8));
        System.out.print(", ");
        print(s.lastIndexOf("ll", 1));
        System.out.println();
        System.out.println();
        print("Returns a string resulting from replacing all occurrences of target in this string with new input. Here target can be char, string, : ");
        print(s.replace("ll", "ss"));
        System.out.print(", ");
        print(s.replace("ll", "s"));
        System.out.print(", ");
        print(s.replace("ll", " "));
        System.out.println();
        System.out.println();
        print("Insert the given string to an index: ");
        StringBuffer str = new StringBuffer(s);
        str.insert(5, " New");
        print(str.toString());
        System.out.println();
        System.out.println();
        print("Remove the string between range: ");
        str.delete(5, 9);
        print(str.toString());
        System.out.println();
        System.out.println();

    }

    public static void print(String s) {
        System.out.print(s);
    }

    public static void print(char s) {
        System.out.print(s);
    }

    public static void print(int s) {
        System.out.print(s);
    }

    public static void print(boolean s) {
        System.out.print(s);
    }
}