package UpperBound;

/**
 * Upperbound
 */
public class Upperbound {

  public static void main(String[] args) {
    int arr[] = { 1, 1, 2, 2, 2, 4, 4, 7 };
    int target = 7;
    int low = 0, high = arr.length;
    while (low < high && low != arr.length) {
      int mid = low + (high - low) / 2;
      if (arr[mid] <= target)
        low = mid + 1;
      else
        high = mid;
    }
    if (low == arr.length) {
      System.out.println("UpperBound does not exist");
      return;
    }
    System.out.println(low);
  }
}