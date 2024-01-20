package MinimumAmtOfTimeToCollectGarbage;

/**
 * MinAmtTimeCollectGarbage
 */
public class MinAmtTimeCollectGarbage {

  public static void main(String[] args) {
    String[] garbage = { "G", "P", "GP", "GG" };
    int[] travel = { 2, 4, 3 };
    String[] garbage1 = { "MMM", "PGM", "GP" };
    int[] travel1 = { 3, 10 };
    System.out.println(garbageCollection(garbage, travel));
    System.out.println(garbageCollection(garbage1, travel1));
  }

  // public static int optimizedGarbageCollection(String[] garbage, int[] travel)
  // {
  // int prefixArray[] = new int[travel.length];
  // prefixArray[0] = travel[0];
  // for (int i = 1; i < prefixArray.length; ++i) {
  // prefixArray[i] += prefixArray[i - 1] + travel[i];
  // }
  // int timeM = getTime(garbage, prefixArray, 'M');
  // int timeG = getTime(garbage, prefixArray, 'G');
  // int timeP = getTime(garbage, prefixArray, 'P');
  // return timeG + timeM + timeP;
  // }

  // public static int getTime(String[] garbage, int prefixArray[], char
  // truckType) {

  // }

  public static int garbageCollection(String[] garbage, int[] travel) {
    // time taken by each truck to pick up their garbages
    int glassTruckPick = 0;
    int paperTruckPick = 0;
    int metalTruckPick = 0;
    // travel time by each truck
    int glassTruckTravel = 0;
    int paperTruckTravel = 0;
    int metalTruckTravel = 0;
    // last position of the truck, last time kis ghr pr tha
    int lastGlassTruck = 0;
    int lastPaperTruck = 0;
    int lastMetalTruck = 0;

    int garbagePickingTime = 1; // given in question
    for (int i = 0; i < garbage.length; i++) {
      char[] ch = garbage[i].toCharArray();
      for (char c : ch) {
        if (c == 'G') {
          glassTruckPick++;
          lastGlassTruck = i;
        } else if (c == 'P') {
          paperTruckPick++;
          lastPaperTruck = i;
        } else if (c == 'M') {
          metalTruckPick++;
          lastMetalTruck = i;
        }
      }
    }
    // travel time till last postion of truck
    for (int i = 0; i < lastGlassTruck; i++) {
      glassTruckTravel += travel[i];
    }
    for (int i = 0; i < lastPaperTruck; i++) {
      paperTruckTravel += travel[i];
    }
    for (int i = 0; i < lastMetalTruck; i++) {
      metalTruckTravel += travel[i];
    }
    int totalTime = (glassTruckPick + glassTruckTravel) + (paperTruckPick + paperTruckTravel)
        + (metalTruckPick + metalTruckTravel);
    return totalTime;
  }
}