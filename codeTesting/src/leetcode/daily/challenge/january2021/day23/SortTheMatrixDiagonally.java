package leetcode.daily.challenge.january2021.day23;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author : ssuddhapally
 * @since : 23/01/21, Sat
 **/


class SortTheMatrixDiagonally {
  public int[][] diagonalSort(int[][] mat) {
    List<Integer> temp = new ArrayList<>(100);
    for (int i = 0, j = 0; i < mat.length && j < mat[0].length; i++, j++) {
      temp.add(mat[i][j]);
    }
    sortAndAddToDiagonalStartingWithXandY(mat, temp, 0, 0);

    for (int k = 1; k < mat.length; k++) {
      temp.clear();
      for (int i = k, j = 0; i < mat.length && j < mat[0].length; i++, j++) {
        temp.add(mat[i][j]);
      }
      sortAndAddToDiagonalStartingWithXandY(mat, temp, k, 0);
    }

    for (int k = 1; k < mat[0].length; k++) {
      temp.clear();
      for (int i = 0, j = k; i < mat.length && j < mat[0].length; i++, j++) {
        temp.add(mat[i][j]);
      }
      sortAndAddToDiagonalStartingWithXandY(mat, temp, 0, k);
    }
    return mat;

  }

  private void sortAndAddToDiagonalStartingWithXandY(int[][] mat, List<Integer> temp, int x, int y) {
    Collections.sort(temp);
    for (int k = 0; x < mat.length && y < mat[0].length; x++, y++, k++) {
      mat[x][y] = temp.get(k);
    }
  }
}