package codeforces.div2.no688;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * @author : ssuddhapally
 * @since : 05/12/20, Sat
 **/

/***
 * inputCopy
 * 3
 * 1 2
 * 1
 * 3 4
 * 1 3 4
 * 2 4
 * 9 14
 * 2 7 16 28 33 57 59 86 99
 * 3 9 14 19 25 26 28 35 41 59 85 87 99 100
 * outputCopy
 * 0
 * 1
 * 3
 */
public class CancelTheTrains {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int itr = Integer.parseInt(br.readLine());
    for (int i = 0; i < itr; i++) {
      String[] s = br.readLine().split(" ");
      int n = Integer.parseInt(s[0]);
      int m = Integer.parseInt(s[1]);
      Map<Integer, Integer> map = new HashMap<>();
      putBottomToTopTrainsToMap(br, n, map);
      int count = getMinimumTrainsToGetCancelledCount(br, m, map);
      System.out.println(count);
    }
  }

  private static int getMinimumTrainsToGetCancelledCount(BufferedReader br, int m, Map<Integer, Integer> map) throws IOException {
    String[] s;
    int count = 0;
    s = br.readLine().split(" ");
    for (int j = 0; j < m; j++) {
      if (map.get(Integer.parseInt(s[j])) != null) {
        count++;
      }
    }
    return count;
  }

  private static void putBottomToTopTrainsToMap(BufferedReader br, int n, Map<Integer, Integer> map) throws IOException {
    String[] s;
    s = br.readLine().split(" ");
    for (int j = 0; j < n; j++) {
      map.put(Integer.parseInt(s[j]), 1);
    }
  }
}
