package MinimumTimeDiff;

/**
 * MinimumTimeDifference
 * Given a list of 24-hour clock time points in "HH:MM" format, return the
 * minimum minutes difference between any two time-points in the list.
 * Example 1:
 *
 * Input: timePoints = ["23:59","00:00"]
 * Output: 1
 * Example 2:
 *
 * Input: timePoints = ["00:00","23:59","00:00"]
 * Output: 0
 */
public class MinimumTimeDifference {

  public static void main(String[] args) {
    String arr1[] = { "22:40", "00:00" }; // 60min + 20min
    String arr3[] = { "23:59", "00:00" };
    String arr2[] = { "00:00", "23:59", "00:00" };
    int minTimeDiff = findDiff1(arr3);

    System.out.println(minTimeDiff);
    System.out.println(findDiff1(arr2));
    System.out.println(findDiff1(arr1));
  }

  public static int findDiff1(String arr[]) {
    int ans = 24 * 60; // max value can be this.
    int temp = 24 * 60;
    // making a boolean array
    boolean bucket[] = new boolean[24 * 60];
    for (String i : arr) {
      // Finding the current total minutes
      // 22*60 + 40 = 1320 + 40 = 1360;
      // 0*60 + 0 = 0 + 0 = 0;
      int num = Integer.valueOf(i.substring(0, 2)) * 60 + Integer.valueOf(i.substring(3));
      temp = Math.min(temp, num);// 1360 then it changes to 0
      if (bucket[num])
        return 0;
      bucket[num] = true;
    }
    int prev = temp;// 0
    for (int i = temp + 1; i < bucket.length; i++) {
      if (bucket[i]) {
        ans = Math.min(ans, i - prev);
        prev = i;
      }
    }
    return Math.min(ans, 24 * 60 - prev + temp);
  }
}