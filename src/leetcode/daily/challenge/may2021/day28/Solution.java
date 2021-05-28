package leetcode.daily.challenge.may2021.day28;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : ssuddhapally
 * @since : 28/05/21, Fri
 **/

class Solution {
  public int maxProduct(String[] words) {
    int max = 0;
    for (int i = 0; i < words.length; i++) {
      String curr = words[i];
      Map<Character, Integer> eleMap = new HashMap<>();
      for (int j = 0; j < curr.length(); j++) {
        eleMap.putIfAbsent(curr.charAt(j), 0);
        eleMap.put(curr.charAt(j), eleMap.get(curr.charAt(j)) + 1);
      }
      for (int j = i + 1; j < words.length; j++) {
        String second = words[j];
        boolean canProduct = true;
        for (int k = 0; k < second.length(); k++) {
          if (null != eleMap.get(second.charAt(k))) {
            canProduct = false;
            break;
          }
        }
        if (canProduct)
          max = Math.max(max, curr.length() * second.length());
      }
    }
    return max;
  }

  public static void main(String[] args) {
    String[] arr = {"abcw", "baz", "foo", "bar", "xtfn", "abcdef"};
    Solution solution = new Solution();
    solution.maxProduct(arr);
  }
}
