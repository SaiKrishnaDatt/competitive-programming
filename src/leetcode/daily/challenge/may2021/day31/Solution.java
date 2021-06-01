package leetcode.daily.challenge.may2021.day31;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author : ssuddhapally
 * @since : 01/06/21, Tue
 **/
class Solution {
  public List<List<String>> suggestedProducts(String[] products, String searchWord) {
    Arrays.sort(products);
    int left = 0, right = products.length - 1;
    List<List<String>> ans = new ArrayList<>();
    for (int i = 0; i < searchWord.length(); i++) {
      char c = searchWord.charAt(i);
      while (left < products.length && (products[left].length() <= i || products[left].charAt(i) < c)) left++;
      while (right >= 0 && (products[right].length() <= i || products[right].charAt(i) > c)) right--;
      List<String> eachRow = new ArrayList<>();
      if (left <= right)
        for (int j = 0; j < 3 & left + j <= right; j++) {
          eachRow.add(products[left + j]);
        }
      ans.add(eachRow);
    }
    return ans;
  }
}
