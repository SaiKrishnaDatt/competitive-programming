package leetcode.daily.challenge.may2021.day30;

import java.util.PriorityQueue;

/**
 * @author : ssuddhapally
 * @since : 30/05/21, Sun
 **/
class Solution {
  public int connectSticks(int[] sticks) {
    int ans = 0;
    PriorityQueue<Integer> pQueue = new PriorityQueue<>();
    if (sticks.length > 0) {
      for (int i = 0; i < sticks.length; i++) {
        pQueue.add(sticks[i]);
      }
      while (pQueue.size() > 1) {
        int x = pQueue.poll();
        int y = pQueue.poll();
        int newEle = x + y;
        ans += newEle;
        pQueue.add(newEle);
      }
    }
    return ans;
  }


  public static void main(String[] args) {
    Solution s = new Solution();
    //int[] arr = {1,8,3,5};
    //int[] arr = {2,3,4};
    int[] arr = {8};
    int i = s.connectSticks(arr);
    System.out.println(i);
  }
}