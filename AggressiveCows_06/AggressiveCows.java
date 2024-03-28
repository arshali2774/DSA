package AggressiveCows_06;

import java.util.Arrays;

/**
 * AggressiveCows
 * You are given an array consisting of n integers which denote the position of
 * a stall. You are also given an integer k which denotes the number of
 * aggressive cows. You are given the task of assigning stalls to k cows such
 * that the minimum distance between any two of them is the maximum possible.
 * The first line of input contains two space-separated integers n and k.
 * The second line contains n space-separated integers denoting the position of
 * the stalls.
 *
 * Input:
 * n=5
 * k=3
 * stalls = [1 2 4 8 9]
 * Output:
 * 3
 * Explanation:
 * The first cow can be placed at stalls[0],
 * the second cow can be placed at stalls[2] and
 * the third cow can be placed at stalls[3].
 * The minimum distance between cows, in this case, is 3,
 * which also is the largest among all possible ways.
 *
 * Your Task:
 * Complete the function int solve(), which takes integer n, k, and a vector
 * stalls with n integers as input and returns the largest possible minimum
 * distance between cows.
 *
 * Expected Time Complexity: O(n*log(10^9)).
 * Expected Auxiliary Space: O(1).
 *
 * Constraints:
 * 2 <= n <= 10^5
 * 2 <= k <= n
 * 0 <= stalls[i] <= 10^9
 */
/* -------------------------------- Solution -------------------------------- */
// Sort the array first.
// For e.g. [10,1,2,7,5] --> [1,2,5,7,10].
// These are the places that are available for the cows to fill.
// On a number line if we see this:
// 0 '1' '2' 3 4 '5' 6 '7' 8 9 '10'
// now k=3, so we have to find the arrangement so that the min distance between
// them is maximum.
// matlab ye ki hum cows ko position 1,2,5 pr rakh sakte hai and unke beech ka
// min distance hoga 1(2-1) & 3(5-2)
// which can be an answer but we have to maximize this answer.
// so we have to think like ki saare cows ke beech atleast 1 unit distance hona
// chaiye, and we have to check is it possible to do that.
// if we can then we will increase the distance and check again till we can't
// maintain alteast x unit of distance between cows.
// so wahi case hua if possible solution then low = mid +1 else high = mid -1;
public class AggressiveCows {

    public static void main(String[] args) {
        int stalls[] = { 10, 1, 2, 7, 5 };
        int n = 5;
        int k = 3;
        // answer should be 4.
        int answer = solve(n, k, stalls);
        System.out.println("Answer " + answer);
    }

    public static int solve(int n, int k, int[] stalls) {
        // sort the array first.
        Arrays.sort(stalls);
        int low = 0;
        int high = stalls[n - 1] - stalls[0]; // maxPos - minPos
        // here we have maxPos = 10 and minPos = 1
        // then high = 9
        // so we have the indexes and the stalls number, i.e.
        // 1 2 3 4 5 6 7 8 9 10 --> stalls number
        // 0 1 2 3 4 5 6 7 8 9 --> indexes
        int answer = -1;

        while (low <= high) {
            // this mid is the atleast x unit of distance between cows.
            int mid = low + (high - low) / 2;
            boolean isPossibleSolution = isPossibleSolutionFunc(stalls, n, k, mid);
            if (isPossibleSolution) {
                answer = mid;
                low = mid + 1;
            } else
                high = mid - 1;
        }
        return answer;
    }

    public static boolean isPossibleSolutionFunc(int[] stalls, int n, int k, int atLeastDistance) {
        int count = 1;
        int pos = stalls[0];
        for (int i = 1; i < n; i++) {
            if (stalls[i] - pos >= atLeastDistance) {
                count++;
                pos = stalls[i]; // one more cow has been placed
            }
            if (count == k)
                return true; // all cows are placed with atleastDistance between them.
        }
        return false; // if we were unable to maintain atleastDistance between them
    }
}