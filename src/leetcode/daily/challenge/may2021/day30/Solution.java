package leetcode.daily.challenge.may2021.day30;

import java.util.Arrays;

/**
 * @author : ssuddhapally
 * @since : 01/06/21, Tue
 **/
class Solution {
  public int maximumGap(int[] nums) {
    int max =0;
    if( nums.length <2) return max;
    Arrays.sort(nums);
    for(int i=1;i<nums.length;i++){
      max = Math.max(nums[i]-nums[i-1],max);
    }
    return max;
  }
}