package PaintersPartitionProblem_05;
/* ---------------------------- Problem Statement --------------------------- */

import java.util.Arrays;

// Dilpreet wants to paint his dog's home that has 'n' boards with different lengths. The length of 'ith' board is given by arr[i] where arr[] is an array of n integers. He hired 'k' painters for this work and each painter takes 1 unit time to paint 1 unit of the board.

// The problem is to find the minimum time to get this job done if all painters start together with the constraint that any painter will only paint continuous boards, say boards numbered {2,3,4} or only board {1} or nothing but not boards {2,4,5}.

/* -------------------------------- Example 1 ------------------------------- */

// Input:
// n = 5
// k = 3
// arr[] = {5,10,30,20,15}
// Output: 35
// Explanation: The most optimal way will be:
// Painter 1 allocation : {5,10}
// Painter 2 allocation : {30}
// Painter 3 allocation : {20,15}
// Job will be done when all painters finish
// i.e. at time = max(5+10, 30, 20+15) = 35

/* -------------------------------- Your task ------------------------------- */

// Your task is to complete the function minTime() which takes the integers n and k and the array arr[] as input and returns the minimum time required to paint all partitions.

/* ------------------------------- Complexity ------------------------------- */

// Expected Time Complexity: O(n log m) , m = sum of all boards' length
// Expected Auxiliary Space: O(1)

/* ------------------------------- Constraints ------------------------------ */
// 1 ≤ n ≤ 105
// 1 ≤ k ≤ 105
// 1 ≤ arr[i] ≤ 105

public class PaintersPartition {
    public static void main(String[] args) {
        int n = 5;
        int k = 3;
        int arr[] = { 5, 10, 30, 20, 15 };
        long result = minTime(arr, n, k);
        System.out.println("Result: " + result);
    }

    public static long minTime(int arr[], int n, int k) {
        long answer = -1L;
        long low = 0, high = Arrays.stream(arr).sum();
        while (low <= high) {
            long mid = low + (high - low) / 2;
            boolean isPossibleSolution = isPossibleSolutionFunc(arr, n, k, mid);
            if (isPossibleSolution) {
                answer = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return answer;
    }

    public static boolean isPossibleSolutionFunc(int[] arr, int n, int k, long mid) {
        long timeSum = 0;
        int count = 1;
        for (int i = 0; i < n; i++) {
            if (arr[i] > mid)
                return false;
            if (arr[i] + timeSum > mid) {
                count++;
                timeSum = arr[i];
                if (count > k)
                    return false;
            } else
                timeSum += arr[i];
        }
        return true;
    }
}
