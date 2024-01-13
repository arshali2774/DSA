/**
 * FindPeakElement
 */
public class FindPeakElement {

    public static void main(String[] args) {
        int nums[] = { 1, 2, 1, 3, 5, 6, 4 };
        int n = nums.length;
        int low = 0, high = n - 1;
        while (low < high) {
            int mid = (low + high) >> 1;
            if (nums[mid] > nums[mid + 1])
                high = mid;
            else
                low = mid + 1;
        }
        System.out.println(low);
    }
}