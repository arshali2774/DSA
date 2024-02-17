package BubbleSort;

public class Revise {
  public static void main(String[] args) {
    int arr[] = { 4, 5, 1, 3, 2 };
    for (int i = 0; i < arr.length; i++) {
      for (int j = 0; j < arr.length - 1 - i; j++) {
        if (arr[j] > arr[j + 1]) {
          int temp = arr[j];
          arr[j] = arr[j + 1];
          arr[j + 1] = temp;
        }
      }
    }
    for (int x : arr) {
      System.out.print(x + " ");

    }
  }
}
