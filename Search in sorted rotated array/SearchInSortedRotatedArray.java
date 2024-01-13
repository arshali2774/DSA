import java.util.ArrayList;

/**
 * SearchInSortedRotatedArray
 */
public class SearchInSortedRotatedArray {

    public static int search(ArrayList<Integer> nums, int target) {
        int l = 0, r = nums.size() - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums.get(mid) == target)
                return mid;
            else if (nums.get(l) <= nums.get(mid)) {
                if (nums.get(l) <= target && target < nums.get(mid))
                    r = mid - 1;
                else
                    l = mid + 1;
            } else {
                if (nums.get(mid) < target && target <= nums.get(r))
                    l = mid + 1;
                else
                    r = mid - 1;
            }
        }
        return -1; // No need to debug this line.
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(0);
        list.add(1);
        list.add(2);
        int target = 0;
        int result = search(list, target);
        System.out.println(result);
    }
}