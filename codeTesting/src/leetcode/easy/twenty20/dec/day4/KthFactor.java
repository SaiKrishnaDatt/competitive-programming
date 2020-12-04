package leetcode.easy.twenty20.dec.day4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author : ssuddhapally
 * @since : 04/12/20, Fri
 **/

class KthFactor {
  public int kthFactor(int n, int k) {
    List<Integer> list = new ArrayList();
    for (int i = 1; i * i <= n; i++) {
      if (n % i == 0) {
        list.add(i);
        if (i != n / i)
          list.add(n / i);
      }
    }
    Collections.sort(list);
    if (list.size() < k) return -1;
    return list.get(k - 1);
  }
}