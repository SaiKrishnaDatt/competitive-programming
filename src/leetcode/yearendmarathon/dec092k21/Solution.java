package leetcode.yearendmarathon.dec092k21;

/**
 * @author : ssuddhapally
 * @since : 09/12/21, Thu
 **/
class Solution {

  public boolean canReach(int[] arr, int start) {
    int[] visted = new int[arr.length];
    return backTracking(visted, arr, start);

  }

  public boolean backTracking(int[] vis, int[] arr, int index) {
    if (index < 0 || index >= arr.length) return false;
    if (vis[index] < 0) return false;
    if (arr[index] == 0) return true;
    vis[index] = -1;
    return
            backTracking(vis, arr, index + arr[index]) || backTracking(vis, arr, index - arr[index]);
  }
}
