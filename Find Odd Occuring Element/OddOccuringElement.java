/**
 * OddOccuringElement
 * In unsorted array,
 * All elements occurs even number of times except one element which occurs in
 * odd number.
 * Even number of times kaise aate hai - pairs ke form main
 * Koi bhi same pair repeat ni krta hai.
 * ek baar main koi bhi number do baar se zyada ni aa sakta
 * Find that element
 */
public class OddOccuringElement {
    public static void main(String[] args) {
        int arr[] = { 10, 10, 2, 2, 5, 5, 2, 5, 5, 20, 20 };
        int arrLength = arr.length;
        int left = 0;
        int right = arrLength - 1;
        int answer = 0;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            // single element array
            if (left == right) {
                answer = arr[left];
                break;
            }
            if ((mid & 1) == 1) {
                // if mid index is odd
                if (mid - 1 >= 0 && arr[mid] == arr[mid - 1]) {
                    // hum left side main hain, right main jao.
                    left = mid + 1;
                } else {
                    // hum right side main hain, left main jao.
                    right = mid - 1;
                }
            } else {
                // if mid index is even
                if (mid + 1 < arrLength && arr[mid] == arr[mid + 1]) {
                    // left part main hai, right main jao.
                    left = mid + 2;
                } else {
                    // right main hai ya answer pr hai.
                    // e = mid - 1 se answer lost ho skta hai.
                    right = mid;
                }
            }
        }
        System.out.println();
        System.out.println("Answer: " + answer);
        System.out.println();
    }
}