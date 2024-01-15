package FirstAndLastPositionInArray;

/**
 * FirstAndLastPositionInArray
 * We have to return first and last index of an element in the array.
 * We can do this by searching using binary search and finding the lower bound
 * of the target element.
 * And then we can search for the element just greater than target i.e.
 * target+1. For this also we need to find the lower bound and after receiving
 * it we need to subtract 1 from it to get the last index of the element.
 */
public class FirstAndLastPositionInArray {

    public static void main(String[] args) {
        int arr1[] = { 5, 7, 7, 8, 8, 10 };
        int target1 = 8;
        int arr2[] = { 5, 7, 7, 8, 8, 10 };
        int target2 = 6;
        int arr3[] = {};
        int target3 = 0;
        int arr4[] = { 1 };
        int target4 = 1;
        /* --------------------------------- Answers -------------------------------- */
        int answer1[] = Solution(arr1, target1);
        int answer2[] = Solution(arr2, target2);
        int answer3[] = Solution(arr3, target3);
        int answer4[] = Solution(arr4, target4);
        System.out.println("Answer 1");
        for (int x : answer1) {
            System.out.print(x + " ");
        }
        System.out.println();
        System.out.println("Answer 2");
        for (int x : answer2) {
            System.out.print(x + " ");
        }
        System.out.println();
        System.out.println("Answer 3");
        for (int x : answer3) {
            System.out.print(x + " ");
        }
        System.out.println();
        System.out.println("Answer 4");
        for (int x : answer4) {
            System.out.print(x + " ");
        }
        System.out.println();
    }

    public static int[] Solution(int[] arr, int target) {
        int result[] = { -1, -1 };
        if (arr.length < 1) {
            return result;
        }
        int firstIndex = BS(arr, target);
        if (firstIndex == arr.length || arr[firstIndex] != target) {
            return result;
        }
        int lastIndex = BS(arr, target + 1) - 1;
        result[0] = firstIndex;
        result[1] = lastIndex;
        return result;
    }

    public static int BS(int[] arr, int target) {
        int low = 0;
        int high = arr.length;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] >= target) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
}