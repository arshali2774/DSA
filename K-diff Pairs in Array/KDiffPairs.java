import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * KDiffPairs
 * Given an array of integers nums and an integer k, return the number of unique
 * k-diff pairs in the array.
 * k diff pair is an integer pair (nums[i],nums[j]), on following condition
 * - i>=0 && j<nums.length
 * - i!= j
 * - |nums[i]-nums[j]|==k
 * 
 */
/*
 * -------------------------------- Intuition --------------------------------
 * use two for loops to find pairs.
 * but this will result in O(n^2) time complexity.
 * 
 * /* ----------------------------- Optimization -----------------------------
 * Sort array and use two pointer approach
 * time complexity = O(nlogn);
 * but here is catch that if we provide the target k=0 then we will get same
 * element as pair.
 * In the given array we will get [(1,1),(3,3),(4,4),(5,5)] so count = 4.
 * Which is incorrect to get correct answer we need to add a check if (i==j)
 * j++;
 * One more edge case would be that if all elements of an array are same.
 * [1,1,1,1,1] in this case we will get pairs which are not on same index wise
 * that is we will get (1,1) pairs but there indexes will be different
 * But our answer will be wrong as we know that we can't count same pairs.
 * To change this we need to check that the elements should not be zero.
 * /* --------------------------- Using Binary Search --------------------------
 * Since we sorted the array we can use binary search.
 * Ab we know that |x1-x2| = k, so we can say that x2 = k + x1;
 * we know value of k and x1.
 * where x1 will be the ith element of the array.
 * now we want to calculate x2 and search x2 in the array.
 * excluding x1 from the array.
 * 
 */

public class KDiffPairs {
    static class Pair<K, V> {
        K key;
        V value;

        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    public static void main(String[] args) {
        int nums[] = { 3, 1, 4, 1, 5 };
        int nums2[] = { 1, 1, 1, 1, 1 };
        int nums3[] = { 1, 2, 3, 4, 5 };
        int nums4[] = { 0, 0, 0 };
        int k = 0;
        int k2 = 1;
        // Intuition(nums, k);
        int numberOfPairs = IntuitionCount(nums, k);
        System.out.println("Number of pairs test case 1= " + numberOfPairs);
        int numberOfPairsBetter = BetterCount(nums, k);
        System.out.println("Number of pairs test case 1 = " + numberOfPairsBetter);
        int numberOfPairs2 = IntuitionCount(nums2, k);
        System.out.println("Number of pairs test case 2 = " + numberOfPairs2);
        int numberOfPairsBetter2 = BetterCount(nums2, k);
        System.out.println("Number of pairs test case 2= " + numberOfPairsBetter2);
        int numberOfPairs3 = IntuitionCount(nums3, k2);
        System.out.println("Number of pairs test case 3= " + numberOfPairs3);
        int numberOfPairsBetter3 = BetterCount(nums3, k2);
        System.out.println("Number of pairs test case 3= " + numberOfPairsBetter3);
        int numberOfPairsBetterSet = BetterCount(nums4, k);
        System.out.println("Number of pairs test case 4= " + numberOfPairsBetterSet);

        int binarySearchMethod = BinarySearchMethod(nums4, k);
        System.out.println("numberOfPairs test case 1= " + binarySearchMethod);
    }

    public static int BinarySearchMethod(int nums[], int k) {
        int count = 0;
        int x1 = 0, x2 = 0;
        Arrays.sort(nums);
        Set<List<Integer>> uniquePairs = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            x1 = nums[i];
            x2 = k + x1;
            boolean isX2InNums = binarySearch(nums, i + 1, nums.length - 1, x2);
            if (isX2InNums) {
                List<Integer> pair = Arrays.asList(x1, x2);
                uniquePairs.add(pair);
            }
        }

        count = uniquePairs.size();
        return count;
    }

    public static boolean binarySearch(int nums[], int i, int j, int target) {
        boolean ans = false;
        while (i <= j) {
            int mid = (i + j) >> 1;
            if (target == nums[mid]) {
                ans = true;
                return ans;
            } else if (nums[mid] < target) {
                i = mid + 1;
            } else {
                j = mid - 1;
            }
        }
        return ans;
    }

    public static int BetterCountUsingSet(int nums[], int k) {
        int count = 0;
        int i = 0, j = 1;
        Arrays.sort(nums);
        Set<Pair<Integer, Integer>> ans = new HashSet<>();
        while (j < nums.length) {
            int diff = nums[j] - nums[i];
            if (diff == k) {
                ans.add(new Pair<Integer, Integer>(nums[i], nums[j]));
                i++;
                j++;
            } else if (diff < k) {
                i++;
            } else {
                j++;
            }
            if (i == j)
                j++;
        }
        count = ans.size();
        return count;
    }

    public static int BetterCount(int nums[], int k) {
        int count = 0;
        int i = 0, j = 1;
        // yaha pr hum x1=0 and x2=0 le rahe the lekin for edge case [0,0,0] and k=0
        // case phs raha tha
        // phir humn1 x1=-1 and x2=-1 liya to edge case [-1,-1,1,1] and k=0 case phs rha
        // tha
        // isiliye humne ye values li hai iske jagah hum Integer.MAX_VALUE bhi le sakte
        // hai
        // but ye sahi tareek nahi hai because x1 and x2 ki value bhi aasakti hai kisi
        // test case main.
        int x1 = Integer.MIN_VALUE, x2 = Integer.MIN_VALUE;
        Arrays.sort(nums);
        while (j < nums.length) {
            if (nums[j] - nums[i] == k) {
                if (x1 != nums[i] || x2 != nums[j]) // yaha pr hum check kr rahe hai ki jo pair humne count kiya tha
                                                    // kahin same pair to nahi hai.
                    count++;
                // ye updation hume i++ and j++ krne se pehle krna padega
                x1 = nums[i]; // yaha hum apne pair ke elements ko update kr rahe hai
                if (j < nums.length) // yaha j out of bounds jaa sakta hai to hum check laga rahe hai.
                    x2 = nums[j];
                i++;
                j++;

            } else if (nums[j] - nums[i] < k) {
                j++;
            } else {
                i++;
            }
            if (i == j)
                j++;
        }
        return count;
    }

    public static int IntuitionCount(int nums[], int k) {
        int count = 0;
        int x1 = 0, x2 = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (Math.abs(nums[i] - nums[j]) == k) {
                    if (x1 != nums[i] || x2 != nums[j]) {
                        count++;
                    }
                    x1 = nums[i];
                    x2 = nums[j];
                }
            }
        }
        return count;
    }

    public static void Intuition(int nums[], int k) {
        for (int i = 0; i < nums.length - 1; i++) {
            int x1 = 0, x2 = 0;
            for (int j = i + 1; j < nums.length; j++) {
                if (Math.abs(nums[i] - nums[j]) == k) {
                    x1 = nums[i];
                    x2 = nums[j];
                }
                System.out.println("for i = " + i + " and j = " + j + " x1 = " + x1 + ", x2 = " + x2);
            }
        }
    }
}