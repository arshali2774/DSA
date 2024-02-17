package AggressiveCows;

import java.util.Arrays;

public class Revise {
  public static int allocatingStalls(int n, int k, int stalls[]) {
    Arrays.sort(stalls);
    int low = 0;
    int high = stalls[n - 1] - stalls[0];
    int answer = -1;
    // range nikal aayi
    while (low <= high) {
      int mid = low + (high - low) / 2;
      boolean isPossibleSolution = isPossibleSolutionFunc(n, k, stalls, mid);
      if (isPossibleSolution) {
        answer = mid;
        low = mid + 1;
      } else {
        high = mid - 1;
      }
    }
    return answer;
  }

  public static boolean isPossibleSolutionFunc(int n, int k, int stalls[], int leastDist) {
    int cowsPlaced = 1;
    int posPlaced = stalls[0];
    for (int i = 1; i < n; i++) {
      if (stalls[i] - posPlaced >= leastDist) {
        cowsPlaced++;
        posPlaced = stalls[i];
      }
      if (cowsPlaced == k) {
        return true;
      }
    }
    return false;
  }

  public static void main(String[] args) {
    // array with n integers, these integers are the position of stalls
    // assign k cows
    // S.T. min distance between any two cows is max possible
    int n = 5;
    int k = 3;
    int stalls[] = { 1, 2, 4, 8, 9 };
    System.out.println(allocatingStalls(n, k, stalls));
  }
}
