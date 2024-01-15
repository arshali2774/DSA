// Given a 'sorted integer array' arr, two integers k and x, return the 'k closest integers' to x in the array. The result should also be sorted in ascending order.
// An integer a is closer to x than an integer b if:
// |a - x| < |b - x|, or
// |a - x| == |b - x| and a < b

import java.util.ArrayList;
import java.util.List;

public class FindKClosestEle {
    public static void main(String[] args) {
        // test case 1
        int arr[] = { 1, 2, 3, 4, 5 };
        int k = 4, x = 6;
        // test case 2
        int arr2[] = { 3, 5, 8, 10 };
        int k2 = 2, x2 = 15;
        // answer test case 1
        List<Integer> ans1 = findClosestElements(arr, k, x);
        System.out.println("Two pointer approach answer test case 1");
        for (int i : ans1) {
            System.out.print(i + " ");
        }
        System.out.println();
        // answer test case 1
        System.out.println("Binary Search Approach answer test case 1");
        List<Integer> ans2 = binarySearchApproach(arr, k, x);
        for (int i : ans2) {
            System.out.print(i + " ");
        }
        System.out.println();
        // answer test case 2
        List<Integer> ans1_1 = findClosestElements(arr2, k2, x2);
        System.out.println("Two pointer approach answer test case 2");
        for (int i : ans1_1) {
            System.out.print(i + " ");
        }
        System.out.println();
        // answer test case 2
        System.out.println("Binary Search Approach answer test case 2");
        List<Integer> ans2_2 = binarySearchApproach(arr2, k2, x2);
        for (int i : ans2_2) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static List<Integer> binarySearchApproach(int[] arr, int k, int x) {
        List<Integer> answer = new ArrayList<>();
        int closestElementTox = binarySearchLowerBound(arr, x);
        int l = closestElementTox - 1, h = closestElementTox;
        while (k != 0) {
            if (l < 0)
                h++;
            else if (h >= arr.length)
                l--;
            else {
                int diff1 = Math.abs(arr[l] - x);
                int diff2 = Math.abs(arr[h] - x);
                if (diff1 > diff2)
                    h++;
                else
                    l--;
            }
            k--;

        }
        for (int i = l + 1; i < h; i++) {
            answer.add(arr[i]);
        }
        return answer;
    }

    public static int binarySearchLowerBound(int arr[], int x) {
        int i = 0, j = arr.length - 1;
        while (i <= j) {
            int mid = (i + j) >> 1;
            if (arr[mid] == x) {
                return mid;
            } else if (arr[mid] < x) {
                i = mid + 1;
            } else {
                j = mid - 1;
            }
        }
        return i;
    }

    public static List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> answer = new ArrayList<>();
        int i = 0, j = arr.length - 1;
        while (j - i >= k) {
            int diff1 = Math.abs(arr[i] - x);
            int diff2 = Math.abs(arr[j] - x);
            if (diff1 > diff2)
                i++;
            else
                j--;
        }
        for (int z = i; z <= j; z++) {
            int value = arr[z];
            answer.add(value);
        }
        // List<Integer> answer = new ArrayList<>(Arrays.asList(Arrays.copyOfRange(arr,
        // i, j + 1)));
        return answer;
    }
}
