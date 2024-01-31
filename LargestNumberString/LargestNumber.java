package LargestNumberString;

import java.util.Arrays;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * LargestNumber
 */
public class LargestNumber {

  public static void main(String[] args) {
    int nums1[] = { 10, 2 }, nums2[] = { 3, 30, 34, 5, 9 };
    System.out.println(largestNumber(nums1));
    System.out.println(largestNumber(nums2));
    System.out.println(largestNumber2(nums1));
    System.out.println(largestNumber2(nums2));
  }

  // not one liner
  public static String largestNumber2(int[] nums) {
    String[] str = new String[nums.length];
    // converting each int to string
    for (int i = 0; i < nums.length; i++) {
      // one way
      // str[i] = nums[i] + "";
      // second way
      str[i] = String.valueOf(nums[i]);
    }
    // custom comparator
    Arrays.sort(str, (a, b) -> {
      return (b + a).compareTo(a + b);
    });
    StringBuilder sb = new StringBuilder();
    for (String s : str) {
      sb.append(s);
    }
    if (sb.charAt(0) == '0')
      return "0";
    return sb.toString();
  }

  // one line answer
  public static String largestNumber(int[] nums) {
    // what this line is doing
    // sabse pehle hum array ko stream main convert kr rahe hai
    // uske baad hum har number ko uske string representation se map kr rahe hai
    // desc order main sort kr rahe hai, lekin wo concat string lexicographially
    // largest honi chaiye
    // uske baad hum sorted string ko collect kr rahe hai hai ek single string main
    // aur join aise kr rahe hai ki usme koi delimiter na ho.
    String s = Arrays.stream(nums).mapToObj(String::valueOf).sorted((a, b) -> (b + a).compareTo(a + b))
        .collect(Collectors.joining(""));
    // Agar string 00 se shuru ho rahi hai to largest number 0 hi hoga
    return s.startsWith("00") ? "0" : s;
  }
}