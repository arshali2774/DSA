/**
 * FindMinInRotatedSortedArray
 */
public class FindMinInRotatedSortedArray {

    public static void main(String[] args) {
        int arr[] = { 3, 4, 5, 1, 2 };
        int n = arr.length;
        int start = 0, end = n - 1;
        int ans = start;
        while (arr[start] > arr[end]) {
            int mid = (start + end) >> 1;
            if (arr[mid] <= arr[start] && arr[mid] <= arr[end])
                end = mid;
            else if (arr[mid] >= arr[start] && arr[mid] >= arr[end])
                start = mid + 1;
            else {
                System.out.println(arr[mid]);
                return;
            }
            ans = start;
        }
        System.out.println(arr[ans]);
        return;

    }
}