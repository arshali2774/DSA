package BookAllocationProblem_04;

import java.util.Arrays;

public class Revise {
  public static void main(String[] args) {
    int books = 4;
    int pagesArr[] = { 12, 34, 67, 90 };
    int students = 2;
    System.out.println(solve(books, pagesArr, students));
  }

  public static int solve(int books, int pagesArr[], int students) {
    int answer = -1;
    if (students > books) {
      return answer;
    }
    // pages can be from 1 to sum of all pages in array
    // so starting page can be 1 and its index will be 0
    int start = 0;
    // end will be the sum of all pages minus 1 but we can ignore the minus part.
    int end = Arrays.stream(pagesArr).sum();
    while (start <= end) {
      int mid = start + (end - start) / 2;
      boolean isPossibleSolution = isPossibleSolutionFunc(books, pagesArr, students, mid);
      if (isPossibleSolution) {
        answer = mid;
        end = mid - 1;
      } else {
        start = mid + 1;
      }
    }
    return answer;
  }

  public static boolean isPossibleSolutionFunc(int books, int[] pagesArr, int students, int minPageRequired) {
    int studentCount = 1;
    int pagesCount = 0;
    for (int i = 0; i < books; i++) {
      if (pagesArr[i] > minPageRequired) {
        return false;
      }
      if (pagesCount + pagesArr[i] > minPageRequired) {
        studentCount++;
        pagesCount = pagesArr[i];
        if (studentCount > students) {
          return false;
        }
      } else {
        pagesCount += pagesArr[i];
      }
    }
    return true;
  }
}
