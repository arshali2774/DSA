/**
 * SelectionSort
 */
public class SelectionSort {
    public static void swap(int arr[], int x, int y) {
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }

    public static void main(String[] args) {
        int arr[] = { 44, 33, 22, 11, 10 };
        int n = arr.length;
        System.out.println();
        for (int i = 0; i < n - 1; i++) { // -44-33-22-11 yahi tak chalega loop
            int minIndex = i; // ith element is smallest;
            System.out.println("minIndex " + minIndex);
            for (int j = i + 1; j < n; j++) { // 33-22-11-10
                if (arr[j] < arr[minIndex]) {
                    minIndex = j; // agar current element chota hai us element se jo minIndex pr tha then update
                                  // min index.
                }
            }
            // j loop se bahar aake swap ith element and minIndex element.
            swap(arr, i, minIndex);
        }
        System.out.println();
        for (int x : arr) {
            System.out.print(x + " ");
        }
        System.out.println();
    }
}