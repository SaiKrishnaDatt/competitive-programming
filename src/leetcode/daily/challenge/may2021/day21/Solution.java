package leetcode.daily.challenge.may2021.day21;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author : ssuddhapally
 * @since : 21/05/21, Fri
 **/


class Solution {
  public static List<String> findAndReplacePattern(String[] words, String pattern) {

    List<String> ans = new ArrayList<>();
    Map<String, Integer> map = new HashMap<>();
    for (String word : words) {
      Map<String, Integer> current = new HashMap<>();
      int i = 0;
      int index = 0;
      boolean status = true;
      for (; i < pattern.length(); i++) {
        ++index;
        current.putIfAbsent(word.charAt(i) + "", index);
        map.putIfAbsent(pattern.charAt(i) + "", index);
        if (Integer.compare(map.get(pattern.charAt(i) + ""), current.get(word.charAt(i) + "")) !=0) {
          if (map.get(pattern.charAt(i) + "") != current.get(word.charAt(i) + "")) {
          status = false;
          break;
        }
      }
      if (status) {
        ans.add(word);
      }
    }
    return ans;
  }

  public static void main(String[] args) {
    String[] arr = {"abc","deq","mee","aqq","dkd","ccc"};
    String expected = "abb";
    System.out.println(findAndReplacePattern(arr,expected));
  }
}