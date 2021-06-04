package leetcode.daily.challenge.June2021.day3;

import java.util.Arrays;

/**
 * @author : ssuddhapally
 * @since : 03/06/21, Thu
 **/
class Solution {
  public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
    int maxHor = 0;
    int maxVertical = 0;

    maxHor = maxDist(horizontalCuts, h);
    maxVertical = maxDist(verticalCuts, w);

    return maxHor * maxVertical;

  }

  public int maxDist(int[] horizontalCuts, int h) {
    Arrays.sort(horizontalCuts);
    int maxHor = 0;
    for (int i = 0; i < horizontalCuts.length; i++) {
      int j = i + 1;
      if (j < horizontalCuts.length) {
        maxHor = Math.max(maxHor, Math.abs(horizontalCuts[i] - horizontalCuts[j]));
      }
    }
    maxHor = Math.max(maxHor, Math.abs(horizontalCuts[0]));
    if (horizontalCuts[horizontalCuts.length - 1] < h) {
      maxHor = Math.max(maxHor, Math.abs(horizontalCuts[horizontalCuts.length - 1] - h + 1));
    }
    return maxHor;
  }
  /*

  5
4
[3,1]
[3]

   */

  public static void main(String[] args) {
    int h = 5;
    int w = 4;
    int[] hCuts = {3, 1};
    int[] vCuts = {1};

    Solution solution = new Solution();
    System.out.println(solution.maxArea(h, w, hCuts, vCuts));

  }
}