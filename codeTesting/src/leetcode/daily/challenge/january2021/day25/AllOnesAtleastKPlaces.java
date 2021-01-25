package leetcode.daily.challenge.january2021.day25;

/**
 * @author : ssuddhapally
 * @since : 25/01/21, Mon
 **/

class AllOnesAtleastKPlaces {
  public boolean kLengthApart(int[] nums, int k) {
    int atleast = 100000;
    if (nums.length == 0 && k == 0) return true;
    int currDist = 0;
    int i = 0;
    while (i < nums.length && nums[i] != 1) i++;
    for (i = i + 1; i < nums.length; i++) {
      if (nums[i] == 1) {
        atleast = Math.min(atleast, currDist);
        currDist = 0;
      } else {
        currDist++;
      }
    }
    //System.out.println(atleast);
    if (atleast < k) return false;
    return true;
  }
}