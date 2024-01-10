/**
 * FindUnique
 * Given an array of integers. All numbers occur twice except one number which
 * occurs once. Find the number in O(n) time & constant extra space.
 */
public class FindUnique {

    public static void main(String[] args) {
        int arr[] = { 2, 3, 5, 4, 5, 3, 4 };
        int arrLength = arr.length;

        int answer = arr[0];
        for (int i = 1; i < arrLength; i++) {
            answer = answer ^ arr[i];
        }
        System.out.println();
        System.out.println("Unique Element is: " + answer);
        System.out.println();
    }
}