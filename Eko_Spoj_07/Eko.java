package Eko_Spoj_07;

import java.util.Arrays;

/**
 * Eko
 * Lumberjack Mirko needs to chop down M metres of wood. It an easy job for him,
 * since he has a nifty new woodcutting machine that can take own forests like
 * wildfire.
 * However Mirko is only allowed to cut a single row of tree.
 * Mirko-s machine works as follows:
 * Mirko sets a height parameter H (in metres),
 * and the machine raises a giant sawblade to that height and cuts off all tree
 * parts higher than H (Of course. trees not higher than H meters remain
 * intact).
 * Mirko then takes the parts that were cut off.
 * For example: if the tree row contains trees with heights of 20, 15,10 and 17
 * metres. and Mirko raises his sawblade to 15 metres, the remaining tree
 * heights after cutting will be 15, 15, 10 and 15 metres, respectively, while
 * Mirko Will take 5 metres off the first tree and 2 metres off the fourth tree
 * (7 metres of wood in total).
 * Mirko is ecologically minded. so he doesn't want to cut off more wood than
 * necessary. That's why he wants to set his sawblade as high as possible. Help
 * Mirko find the maximum integer height of the sawblade that still allows him
 * to cut off at least M metres of wood,
 * Input
 * The first line of input contains two space-separated positive integers, N
 * (the number of trees. 1 <=N <=1,000,000) and M
 * (Mirko•s required wood amount, 1<=M<=2,000,000,000).
 * The second line of input contains N space•separated positive integers less
 * than 1 000 000 000. the heights of each tree
 * (in metres). The sum of all heights Will exceed M, thus Mirko Will always be
 * able to obtain the required amount of wood.
 * Output
 * The first and only line of output must contain the required height setting.
 */
/* -------------------------------- Solution -------------------------------- */
// In this we need to give alteast x meters of wood when we set the height of
// sawblade.
// We need to find the height of sawblade that gives atleast x meters of wood.

public class Eko {
    public static void main(String[] args) {
        int numberOfTrees = 4;
        int requiredWood = 7;
        int heightsOfTrees[] = { 20, 15, 10, 17 };
        int heightOfSawblade = heightOfSawbladeFunc(heightsOfTrees, requiredWood, numberOfTrees);
        System.out.println("Height of saw blade " + heightOfSawblade);
    }

    public static int heightOfSawbladeFunc(int[] heightsOfTrees, int requiredWood, int numberOfTrees) {
        int answer = -1;
        int low = 0;
        int high = Arrays.stream(heightsOfTrees).max().getAsInt();
        while (low <= high) {
            int mid = low + (high - low) / 2;
            boolean isPossibleSolution = isPossibleSolutionFunc(heightsOfTrees, requiredWood, numberOfTrees, mid);
            if (isPossibleSolution) {
                answer = mid;
                low = mid + 1;
            } else
                high = mid - 1;
        }
        return answer;
    }

    public static boolean isPossibleSolutionFunc(int[] heightsOfTrees, int requiredWood, int numberOfTrees,
            int possibleHeightOfSawBlade) {
        int sumOfChoppedWood = 0;

        for (int i = 0; i < numberOfTrees; i++) {
            if (heightsOfTrees[i] > possibleHeightOfSawBlade) {
                sumOfChoppedWood += heightsOfTrees[i] - possibleHeightOfSawBlade;
            }
        }
        if (sumOfChoppedWood >= requiredWood) {
            return true;
        } else {
            return false;
        }
    }
}