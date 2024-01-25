package LowerBound;

/**
 * LowerBound
 */
public class LowerBound {

  public static void main(String[] args) {
    int arr[] = { 1, 1, 2, 2, 2, 3, 4 };
    int target = 6;
    // finding lowerbound using binary search;
    int low = 0, high = arr.length;
    while (low < high) { // normally we write low<=high
      int mid = low + (high - low) / 2;
      // normally we write three condition if arr[mid]==target, arr[mid]<target,
      // arr[mid]>target
      // and change the low and high respectively, return mid, low = mid + 1, high =
      // mid - 1
      if (arr[mid] >= target)
        high = mid;
      else
        low = mid + 1;
    }
    // now low points towards the lowerbound of the target element
    // but before that we have one case if the target is not present in array
    // there can be two things if the target is not present and is greater than the
    // largest element of the array then we return the index which is just greater
    // than the last index.
    // in case of above array if 5 was target then the output will be 7.
    if (low < arr.length && arr[low] < target)
      low++;
    // but if the target element is not in the array and is smaller than the
    // smallest element in the array then we return 0.
    System.out.println(low);
  }
}