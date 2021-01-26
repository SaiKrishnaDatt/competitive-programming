package leetcode.daily.challenge.january2021.day26;

import java.util.LinkedList;

/**
 * @author : ssuddhapally
 * @since : 27/01/21, Wed
 **/

class PathWithMinimumEfforts {
  public int minimumEffortPath(int[][] heights) {
    int n = heights.length, m = heights[0].length;
    int l = 0, r = 1000000;
    while (l < r) {
      int mid = (l + r - 1) / 2;
      if (bfs(heights, n, m, mid))
        r = mid;
      else
        l = mid + 1;
    }
    return l;
  }

  boolean isSafe(int x, int y, int n, int m) {
    return x < n && x >= 0 && y < m && y >= 0;
  }

  boolean bfs(int[][] heights, int n, int m, int val) {
    boolean visited[][] = new boolean[n][m];
    LinkedList<Pair> queue = new LinkedList<>();
    visited[0][0] = true;
    queue.add(new Pair(0, 0));
    while (queue.size() != 0) {
      Pair s = queue.poll();
      int x = s.first;
      int y = s.second;
      if (x == n - 1 && y == m - 1) return true;
      if (isSafe(x + 1, y, n, m) && !visited[x + 1][y] && Math.abs(heights[x][y] - heights[x + 1][y]) <= val) {
        visited[x + 1][y] = true;
        queue.add(new Pair(x + 1, y));
      }
      if (isSafe(x - 1, y, n, m) && !visited[x - 1][y] && Math.abs(heights[x][y] - heights[x - 1][y]) <= val) {
        visited[x - 1][y] = true;
        queue.add(new Pair(x - 1, y));
      }
      if (isSafe(x, y + 1, n, m) && !visited[x][y + 1] && Math.abs(heights[x][y] - heights[x][y + 1]) <= val) {
        visited[x][y + 1] = true;
        queue.add(new Pair(x, y + 1));
      }
      if (isSafe(x, y - 1, n, m) && !visited[x][y - 1] && Math.abs(heights[x][y] - heights[x][y - 1]) <= val) {
        visited[x][y - 1] = true;
        queue.add(new Pair(x, y - 1));
      }

    }
    return false;
  }

  static class Pair {
    int first, second;

    Pair(int first, int second) {
      this.first = first;
      this.second = second;
    }
  }
}
