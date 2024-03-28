package Prata_Spoj_08;

import java.util.Arrays;

/**
 * Prata
 */
/* ---------------------------- Problem Statement --------------------------- */
// IEEE iS having its AGM next week and the president wants to serve cheese
// prata after the meeting. The subcommittee members are asked to go to food
// connection and get P (P<=1000) pratas packed for the function. The stall has
// L cooks (L<=50) and each cook has a rank R (1<=R<=8). A cook With a rank R
// can cook 1 prata in the first R minutes 1 more prata in the next 2R minutes.
// 1 more prata in 3R minutes and so on(he can only cook a complete prata) ( For
// example if a cook is ranked 2 then he will cook one prata in 2 minutes one
// more prata in the next 4 mins an one more in the next 6 minutes hence in
// total 12 minutes he cooks 3 pratas.In 13 minutes also he can cook only 3
// pratas as he does not have enough time for the 4th prata. The webmaster wants
// to know the minimum time to get the order done. Please write a program to
// help him out.
// Input
// The first line tells the number of test cases. Each test case consist of 2
// lines, In the first line of the test case we have P the number of prata
// ordered. In the next line the first integer denotes the number of cooks L and
// L integers follow in the same line each denoting the rank of a cook
// Output
// Print an integer which tells the number of minutes needed to get the order
// done.
public class Prata {
    public static void main(String[] args) {
        // Testcase 1 - answer = 12
        int numberOfPrata1 = 10;
        int numberOfCooks1 = 4;
        int rankOfCooks1[] = { 1, 2, 3, 4 };
        // Testcase 2 - answer = 36
        int numberOfPrata2 = 8;
        int numberOfCooks2 = 1;
        int rankOfCooks2[] = { 1 };
        // Testcase 3 - answer = 1
        int numberOfPrata3 = 8;
        int numberOfCooks3 = 8;
        int rankOfCooks3[] = { 1, 1, 1, 1, 1, 1, 1, 1 };
        /*--------------------------------- Answer Testcase 1 --------------------------------*/
        int answer1 = numOfMinNeeded(rankOfCooks1, numberOfCooks1, numberOfPrata1);
        System.out.println();
        System.out.println("Time needed for test case 1 " + answer1);
        System.out.println();
        /*--------------------------------- Answer Testcase 2 --------------------------------*/
        int answer2 = numOfMinNeeded(rankOfCooks2, numberOfCooks2, numberOfPrata2);
        System.out.println();
        System.out.println("Time needed for test case 2 " + answer2);
        System.out.println();
        /*--------------------------------- Answer Testcase 3 --------------------------------*/
        int answer3 = numOfMinNeeded(rankOfCooks3, numberOfCooks3, numberOfPrata3);
        System.out.println();
        System.out.println("Time needed for test case 3 " + answer3);
        System.out.println();
    }

    public static int numOfMinNeeded(int[] rankOfCooks, int numberOfCooks, int numberOfPrata) {
        // here the search space will be from 0 to max time possible.
        // max time possible will be the time used by highest ranking cook to make all
        // the prata.
        // for test case 1, it will be 4*1 + 4*2 + 4*3 ...4*10 = 4(1+2..10) =
        // 4*{(10*(10-1))/2} = 220.
        // now we need to find the time in which cooks can cook 10 prata and try to
        // minimize it.
        int answer = -1;
        int low = 0;
        int highestRank = Arrays.stream(rankOfCooks).max().getAsInt();
        int high = highestRank * (numberOfPrata * (numberOfPrata + 1)) / 2;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            boolean isTimeEnough = isTimeEnoughFunc(rankOfCooks, numberOfCooks, numberOfPrata, mid);
            if (isTimeEnough) {
                answer = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return answer;
    }

    public static boolean isTimeEnoughFunc(int[] rankOfCooks, int numberOfCooks, int numberOfPrata, int timeGiven) {
        // ! Note - that cooks can work simultaneously so if we use more than one cook
        // !then max time taken by any cook will be the total time taken by cooks to
        // !finish.
        int numberOfPrataCookedCount = 0;
        for (int i = 0; i < numberOfCooks; i++) {
            int timeTaken = 0;
            int rank = rankOfCooks[i];
            int countPrata = 1; // this is 1*rank+2*rank+3*rank ... so the number we are multiplying with the
                                // rank is sort of count. to usi ko variable leliya.
            while (true) {
                // let say cook1 starts then, 0 + 1*1 <= 110, for first iteration.
                if (timeTaken + countPrata * rank <= timeGiven) {
                    numberOfPrataCookedCount++;
                    timeTaken += countPrata * rank; // update time taken
                    countPrata++; // update count of prata.
                } else {
                    // if the timeTaken is greater than timeGiven
                    break;
                }
            }
            if (numberOfPrataCookedCount >= numberOfPrata) {
                return true;
            }
        }
        return false;
    }
}
