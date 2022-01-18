package leetcode.year2k22.jan17;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * https://leetcode.com/problems/word-pattern/
 * @author : ssuddhapally
 * @since : 17/01/22, Mon
 **/
class Solution {
  public boolean wordPattern(String pattern, String s) {
    int i = 0;
    int j = 0;
    Set<Character> set = new HashSet<>();
    String[] splited = s.split(" ");
    if (pattern.length() != splited.length) return false;
    Map<String, Character> map = new HashMap<>();
    while (i < splited.length) {
      if (!set.contains(pattern.charAt(j))) {
        set.add(pattern.charAt(j));
        map.putIfAbsent(splited[i], pattern.charAt(j));
        if (pattern.charAt(j++) != map.get(splited[i])) return false;
      } else {
        if (map.get(splited[i]) == null || map.get(splited[i]) != pattern.charAt(j++)) return false;

      }
      i++;
    }
    return true;
  }
}