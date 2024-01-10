/**
 * FindDuplicateElement
 * Given an array arr[] containing n + 1 integers where each integer is between
 * 1 and n (inclusive). There is only one duplicate element, find the duplicate
 * element in O(n) time complexity and O(1) space.
 */
public class FindDuplicateElement {
    public static void main(String[] args) {
        int arr[] = { 1, 3, 2, 1 };
        int arrLength = arr.length;
        System.out.println();
        int answer = 0;
        for (int i = 0; i < arrLength; i++) {
            System.out.print("Before XOR operation " + answer);
            answer = answer ^ arr[i];
            System.out.print(" After XOR operation " + answer);
            System.out.println();
        }
        System.out.println();
        for (int i = 1; i < arrLength; i++) {
            System.out.print("Before XOR operation " + answer);
            answer = answer ^ i;
            System.out.print(" After XOR operation " + answer);
            System.out.println();
        }
        System.err.println();
        System.err.println("Duplicate Element is: " + answer);
        System.err.println();
    }

}