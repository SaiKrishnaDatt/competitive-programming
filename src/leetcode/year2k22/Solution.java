package leetcode.year2k22;

import java.util.Map;
import java.util.TreeMap;

/**
 * @author : ssuddhapally
 * @since : 06/01/22, Thu
 **/
class Solution {
  public boolean carPooling(int[][] trips, int capacity) {
    Map<Integer, Integer> timestamp = new TreeMap<>();
    for (int[] trip : trips) {
      int startPassenger = timestamp.getOrDefault(trip[1], 0) + trip[0];
      timestamp.put(trip[1], startPassenger);

      int endPassenger = timestamp.getOrDefault(trip[2], 0) - trip[0];
      timestamp.put(trip[2], endPassenger);
    }
    int usedCapacity = 0;
    for (int passengerChange : timestamp.values()) {
      usedCapacity += passengerChange;
      if (usedCapacity > capacity) {
        System.out.println("false");
        return false;
      }
    }
    return true;
  }

  public static void main(String[] args) {
    Solution sol = new Solution();
    sol.carPooling(new int[][]{{2,1,5},{5,5,5}},4);
   // sol.carPooling(new int[][]{{2,1,5}},4);
  }
}