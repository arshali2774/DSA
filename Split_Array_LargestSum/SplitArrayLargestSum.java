package Split_Array_LargestSum;

import java.util.Arrays;

/**
 * SplitArrayLargestSum
 */

/* ---------------------------- Problem statement --------------------------- */
// Given an integer array nums and an integer k, split nums into k non-empty
// subarrays such that the largest sum of any subarray is minimized.
// Return the minimized largest sum of the split.
// A subarray is a contiguous part of the array.

// Example 1:

// Input: nums = [7,2,5,10,8], k = 2
// Output: 18
// Explanation: There are four ways to split nums into two subarrays.
// The best way is to split it into [7,2,5] and [10,8], where the largest sum
// among the two subarrays is only 18.

// Example 2:

// Input: nums = [1,2,3,4,5], k = 2
// Output: 9
// Explanation: There are four ways to split nums into two subarrays.
// The best way is to split it into [1,2,3] and [4,5], where the largest sum
// among the two subarrays is only 9.

// Constraints:

// 1 <= nums.length <= 1000
// 0 <= nums[i] <= 106
// 1 <= k <= min(50, nums.length)

public class SplitArrayLargestSum {

    public static void main(String[] args) {
        // testcase 1 - answer = 18
        int arr1[] = { 7, 2, 5, 10, 8 };
        int k1 = 2;
        // testcase 2 - answer = 9
        int arr2[] = { 1, 2, 3, 4, 5 };
        int k2 = 2;
        // testcase 3 - answer = 4
        int arr3[] = { 1, 4, 4 };
        int k3 = 3;
        /* ---------------------------- Answer Testcase 1 --------------------------- */
        System.out.println();
        int answer1 = splitArray(arr1, k1);
        System.out.println("Answer 1 " + answer1);
        System.out.println();
        /* ---------------------------- Answer Testcase 2 --------------------------- */
        System.out.println();
        int answer2 = splitArray(arr2, k2);
        System.out.println("Answer 2 " + answer2);
        System.out.println();
        /* ---------------------------- Answer Testcase 3 --------------------------- */
        System.out.println();
        int answer3 = splitArray(arr3, k3);
        System.out.println("Answer 3 " + answer3);
        System.out.println();
    }

    public static int splitArray(int arr[], int k) {
        int answer = -1;
        int low = Arrays.stream(arr).max().getAsInt();
        // humne 0 se isliye shuru nahi kiya because, hum 0 se shuru krte
        // to hume wo sums ko bhi check krna padta jo humare array ke
        // largest element se bhi chota hai which is not needed. As we
        // have to minimize the maximum sum and not find the minimum sum
        int high = Arrays.stream(arr).sum() + 1;
        // yaha pr hum +1 isliye kiye hai taaki humara answer miss na ho jaye as we know
        // that humara answer array ke saare elements ke barabar bhi ho sakta hai in
        // that case we must add +1 so that humara answer out of bounds ya miss na ho
        // jaye.
        while (low <= high) {
            int mid = low + (high - low) / 2;
            boolean isPossibleSolution = isPossibleSolutionFunc(arr, k, mid);
            if (isPossibleSolution) {
                answer = mid;
                high = mid - 1;
            } else
                low = mid + 1;
        }
        return answer;
    }

    public static boolean isPossibleSolutionFunc(int[] arr, int k, int mid) {
        int count = 1;
        int sum = 0;
        for (int x : arr) {
            if (sum + x <= mid) {
                sum += x;
            } else {
                count++;
                sum = x;

            }
        }
        if (count > k)
            return false;
        return true;
    }
}