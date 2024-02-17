package BubbleSort;

/**
 * BubbleSort
 */
public class BubbleSort {

    public static void main(String[] args) {
        int arr[] = { 4, 5, 1, 3, 2 };
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1])
                    swap(arr, j, j + 1);
            }
        }
        for (int x : arr) {
            System.out.print(x + " ");
        }
    }

    public static void swap(int arr[], int x, int y) {
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }
}