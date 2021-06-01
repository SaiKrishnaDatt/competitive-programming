package leetcode.daily.challenge.may2021.day29;

import java.util.HashSet;
import java.util.Set;

/**
 * @author : ssuddhapally
 * @since : 30/05/21, Sun
 **/

class Solution2 {
  int ans;
  int size;

  public int totalNQueens(int n) {
    ans = 0;
    size = n;
    backtrack(0, new HashSet<>(), new HashSet<>(), new HashSet<>());
    return ans;
  }

  private void backtrack(int row, Set<Integer> diagonals, Set<Integer> antiDiagonals, Set<Integer> cols) {
    if (row == size) {
      ans++;
    }
    for (int col = 0; col < size; col++) {
      int currDiagonal = row - col;
      int currAntiDiagnoal = row + col;
      if (cols.contains(col) || diagonals.contains(currDiagonal) || antiDiagonals.contains(currAntiDiagnoal)) {
        continue;
      }
      cols.add(col);
      diagonals.add(currDiagonal);
      antiDiagonals.add(currAntiDiagnoal);

      backtrack(row + 1, diagonals, antiDiagonals, cols);
      cols.remove(col);
      diagonals.remove(currDiagonal);
      antiDiagonals.remove(currAntiDiagnoal);
    }
  }
}