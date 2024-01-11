/**
 * FindOddOccuringElement
 * In unsorted array,
 * All elements occurs even number of times except one element which occurs in
 * odd number.
 * Even number of times kaise aate hai - pairs ke form main
 * Koi bhi same pair repeat ni krta hai.
 * ek baar main koi bhi number do baar se zyada ni aa sakta
 * Find that element
 */
public class FindOddOccuringElement {
    public static void main(String[] args) {
        int arr[] = { 1, 1, 5, 5, 2, 2, 3, 3, 2, 4, 4 };
        int arrLength = arr.length;
        System.out.println();
        int resultXOR = usingXOR(arr, arrLength);
        System.out.println("Answer: " + resultXOR);
        System.out.println();

    }

    public static int usingXOR(int arr[], int arrLength) {
        int answer = arr[0];
        for (int i = 1; i < arrLength; i++) {
            answer ^= arr[i];
        }
        return answer;
    }
}