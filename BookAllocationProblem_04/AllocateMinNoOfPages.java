package BookAllocationProblem_04;

import java.util.Arrays;

/* ---------------------------- Problem statement --------------------------- */
// You have N books, each with A[i] number of pages. M students need to be allocated contiguous books, with each student getting at least one book.
// Out of all the permutations, the goal is to find the permutation where the sum of maximum number of pages in a book allotted to a student should be minimum, out of all possible permutations.
// Note: Return -1 if a valid assignment is not possible, and allotment should be in contiguous order (see the explanation for better understanding).
/* -------------------------------- Example 1 ------------------------------- */
// Input:
// N = 4
// A[] = {12,34,67,90}
// M = 2
// Output:113
// Explanation:Allocation can be done in
// following ways:
// {12} and {34, 67, 90} Maximum Pages = 191
// {12, 34} and {67, 90} Maximum Pages = 157
// {12, 34, 67} and {90} Maximum Pages =113.
// Therefore, the minimum of these cases is 113,
// which is selected as the output.
/* -------------------------------- Example 2 ------------------------------- */
// Input:
// N = 3
// A[] = {15,17,20}
// M = 2
// Output:32
// Explanation: Allocation is done as
// {15,17} and {20}
/* ------------------------------- Your Task: ------------------------------- */
// You don't need to read input or print anything. Your task is to complete the function findPages() which takes 2 Integers N, and m and an array A[] of length N as input and returns the expected answer.
/* ----------------------------- Time Complexity ---------------------------- */
// Expected Time Complexity: O(NlogN)
// Expected Auxilliary Space: O(1)
/* ------------------------------ Constraints: ------------------------------ */
// 1 <= N <= 105
// 1 <= A [ i ] <= 106
// 1 <= M <= 105
/* -------------------------------- Approach -------------------------------- */
// First find out the search space.
// min number of pages for 1 student i.e. 0.
// max number of pages for 1 student i.e. sum of all elements of array, i.e. 12+34+67+90 = 203.
// now search for the number of pages you can allocate to a student between 0 and 203.
// if we go linearly we have to check all the elements and check whether we have the possible answer.
// but we can use binary search instead.
// When using binary search we should find mid and try to allocate at most mid number of pages to each student.
// so if we have two student and let say mid = x then we need to allocate at most x pages to student1 and x pages to student 2.
// if we can do that then we need to change our higher bound from high = sumOfAllElements to high = mid-1;
// if we can't do that then we need to change our lower bound from low= 0 to low=mid+1;
// this is because if we can't allocate x number of pages to students then it is impossible that x-1 pages can be allocated.
// similarly if we can allocate x number of pages then x-1 pages may be allocated too.
public class AllocateMinNoOfPages {
    public static void main(String[] args) {
        int A[] = { 12, 34, 67, 90 };
        int N = 4;
        int M = 2;
        int result = findPages(A, N, M);
        System.out.println("Answer " + result);
    }

    public static int findPages(int A[], int N, int M) {
        if (M > N)
            return -1;
        int result = -1;
        int low = 0, high = Arrays.stream(A).sum(); // sum of all elements of array
        while (low <= high) {
            int mid = low + (high - low) / 2;
            boolean isPossibleSolution = isPossibleSolutionFunc(A, N, M, mid);
            if (isPossibleSolution) {
                result = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return result;
    }

    public static boolean isPossibleSolutionFunc(int A[], int N, int M, int mid) {
        int pageSum = 0;
        int count = 1; // count 1 se shuru kiya hai kyunki hum students ko count kr rahe hai, agar
                       // count 0 lete to count>=M check krna padta. waise bhi real life main hum 1 2
                       // aise count krte hai. M is number of students to agar counting 2 se zyada badi
                       // to hum false return krna hai mtlab. We need more students but there are none.
        for (int i = 0; i < N; i++) {
            if (A[i] > mid)
                return false;
            if (pageSum + A[i] > mid) {
                count++;
                pageSum = A[i];
                if (count > M)
                    return false;
            } else {
                pageSum += A[i];
            }
        }
        return true;
    }

}
