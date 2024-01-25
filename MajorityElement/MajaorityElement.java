package MajorityElement;

import java.util.Arrays;

/**
 * MajaorityElement
 * leetcode 169
 */
public class MajaorityElement {

  public static void main(String[] args) {
    int nums[] = { 3, 2, 3 };
    System.out.println(usingBS(nums));
  }

  public static int usingBS(int[] arr) {
    // so we can simply sort the element and apply binary search to find first and
    // last occurence of every element. and then we can count the element's freq.
    // in the question it is guaranteed that there will be a majority element.
    // so the n/2 element will always be the majority element but in sorted array.
    Arrays.sort(arr);
    int mid = 0 + ((arr.length - 1) - 0) / 2;
    return arr[mid];
  }
}