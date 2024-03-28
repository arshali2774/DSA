package ExponentialSearch_03;
/* ----- Also known as doubling search, galloping search, strazic search ---- */

/* -------------------------- Works on sorted array ------------------------- */
/* ------------------------- Large array application ------------------------ */
// There are two steps in implementing this algo
// First - Identify the sub array where your element must lie.
// Second - Apply binary search on that range.
// To identify the sub array we do folloing things
// - First check is first element of the array is the target
// - if true return the index.
// - if false initialize a variable i=1, i.e. is pointing to index 1 of array.
// - using while loop and condition i<n and arr[i]<=x, run the loop.
// - and increment the loop exponentially i = i*2;
// - once any of the condition in while loop is falsy, then we have our range.
// - the lower bound will be the just previous value of i, i.e. i = i/2.
// - and upper bound value will be minimum of either current value of i or n-1, coz in some case i may exceed the array length. In that case we need to check for index out of bound.
// - now perform binary search BS(arr,i/2,min(i,n-1),x);
/* ------------------------------ Applications ------------------------------ */
// used in unbounded array or infinite array
// it is better algo if x is near beginning.
/* --------- How to implement exponential search in unbounded array --------- */
// - use two pointer approach, i=0 and j=1.
// - then use while loop to find the bounds.
// - while(arr[j]<x){ i = j; j = j*2}
// - then i is lower bound and j is upper bound.
// - apply binary search BS(arr,i,j,x);
public class ExponentialSearch {
    public static void main(String[] args) {
        int arr[] = { 3, 4, 5, 6, 11, 13, 14, 15, 56, 70 };
        int eleToFind = 13;
        int b1 = 0, b2 = 0;
        if (arr[0] == eleToFind) {
            System.out.println("Element found at index " + 0);
            return;
        }
        int i = 1;
        while (i < arr.length && arr[i] <= eleToFind) {
            i = i * 2;
        }
        b1 = i / 2;
        b2 = Math.min(i, arr.length - 1);
        int result = binarySearch(arr, b1, b2, eleToFind);
        if (result == -1) {
            System.out.println("Element not found in array");
        } else {
            System.out.println("Element found at index " + result);
        }
        return;
    }

    public static int binarySearch(int[] arr, int b1, int b2, int x) {
        int result = -1;
        while (b1 <= b2) {
            int mid = (b1 + b2) >> 1;
            if (arr[mid] == x) {
                result = mid;
                return result;
            } else if (arr[mid] < x) {
                b1 = mid + 1;
            } else {
                b2 = mid - 1;
            }
        }
        return result;
    }
}
