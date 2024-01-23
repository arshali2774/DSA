package NumberOfLaserBeamsInBank;

import java.util.ArrayList;
import java.util.List;

/**
 * NumberOfLaserBeansInBank
 */
public class NumberOfLaserBeansInBank {

  public static void main(String[] args) {
    String bank[] = { "011001", "000000", "010100", "001000" };
    System.out.println(numberOfBeams(bank));
    System.out.println(numberOfBeamsOptimized(bank));
  }

  public static int numberOfBeamsOptimized(String[] bank) {
    int ans = 0;
    int prevOnes = 0;
    for (String row : bank) {
      int ones = (int) row.chars().filter(c -> c == '1').count();
      if (ones > 0) {
        ans += prevOnes * ones;
        prevOnes = ones;
      }
    }
    return ans;
  }

  public static int numberOfBeams(String[] bank) {
    List<Integer> numOfSecurityDeviceInARow = new ArrayList<>();
    for (String s : bank) {
      int countSecDev = 0;
      for (char c : s.toCharArray()) {
        if (c == '1') {
          countSecDev++;
        }
      }
      if (countSecDev > 0)
        numOfSecurityDeviceInARow.add(countSecDev);

    }
    int i = 0, j = 1;
    int ans = 0;
    while (j < numOfSecurityDeviceInARow.size()) {
      ans += numOfSecurityDeviceInARow.get(i) * numOfSecurityDeviceInARow.get(j);
      i++;
      j++;
    }
    return ans;
  }
}