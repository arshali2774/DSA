import java.util.ArrayList;

/**
 * FindLargestSubsequence
 */
public class FindLargestSubsequence {

    public static void main(String[] args) {
        int nums[] = { 10, 9, 2, 5, 3, 7, 101, 18 };
        ArrayList<Integer> list = new ArrayList<>();
        list.add(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > list.get(list.size() - 1))
                list.add(nums[i]);
            else {
                int index = binarySearch(list, nums[i]);
                list.set(index, nums[i]);
            }
        }
        System.out.println(list.size());
    }

    public static int binarySearch(ArrayList<Integer> list, int target) {
        int left = 0, right = list.size() - 1;
        while (left <= right) {
            int mid = (left + right) >> 1;
            if (list.get(mid) == target)
                return mid;
            else if (list.get(mid) > target)
                right = mid - 1;
            else
                left = mid + 1;
        }
        return left;
    }
}