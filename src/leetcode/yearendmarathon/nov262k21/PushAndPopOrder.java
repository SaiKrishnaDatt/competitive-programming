package leetcode.yearendmarathon.nov262k21;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : ssuddhapally
 * @since : 26/11/21, Fri
 **/

class PushAndPopOrder {
  public boolean validateStackSequences(int[] pushed, int[] popped) {
    List<Integer> list = new ArrayList<>();
    int pushIndex = 0;
    for (int i = 0; i < popped.length; i++) {
      if (!list.isEmpty() && (popped[i] == list.get(list.size() - 1))) {
        list.remove(list.get(list.size() - 1));
        continue;
      }

      while (pushIndex < pushed.length) {
        if (popped[i] != pushed[pushIndex]) {
          list.add(pushed[pushIndex]);
          pushIndex++;
        } else {
          pushIndex++;
          break;
        }
      }

    }
    return list.isEmpty();
  }
}