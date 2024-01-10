/**
 * BinarySearch in a nearly sorted array.
 * If we know that an element in a sorted array is present at index i.
 * Then we can say that in a partially sorted array it will be present in one of
 * the three places.
 * - either at i-1.
 * - or at i.
 * - or at i+1.
 */
public class BinarySearch {

    public static void main(String[] args) {
        int arr[] = { 20, 10, 30, 50, 40, 70, 60 };
        // this array is nearly sorted.
        int arrLength = arr.length;
        int target = 10;
        int targetIndex = searchNearlySorted(arr, arrLength, target);
        System.err.println(targetIndex == -1 ? "not found" : "found at " + targetIndex);

    }

    public static int searchNearlySorted(int arr[], int arrLength, int target) {
        int ans = -1;
        int left = 0;
        int right = arrLength - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            // since we don't know that mid-1 will be valid or not we added a check to make
            // sure we have a valid index. `mid-1>=0`
            if (mid - 1 >= 0 && arr[mid - 1] == target) {
                ans = mid - 1;
                return ans;
            }
            if (arr[mid] == target) {
                ans = mid;
                return ans;
            }
            // for valid index we added a check for mid+1. `mid + 1<arrLength`
            if (mid + 1 < arrLength && arr[mid + 1] == target) {
                ans = mid + 1;
                return ans;
            }
            // we have three cases above for nearly sorted array.
            if (arr[mid] < target) {
                left = mid + 2;
            } else {
                right = mid - 2;
            }

        }
        return ans;
    }
}