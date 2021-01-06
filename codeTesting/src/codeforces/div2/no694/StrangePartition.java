package codeforces.div2.no694;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author : ssuddhapally
 * @since : 06/01/21, Wed
 **/

/*
2
3 3
3 6 9
3 3
6 4 11
 */
public class StrangePartition {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int itr = Integer.parseInt(br.readLine());
    for (int i = 0; i < itr; i++) {
      String[] s = br.readLine().split(" ");
      int n = Integer.parseInt(s[0]);
      int x = Integer.parseInt(s[1]);
      s = br.readLine().split(" ");
      long sum = 0;
      long max = 0;
      for (int j = 0; j < n; j++) {
        int curr = Integer.parseInt(s[j]);
        sum = sum + curr;
        max = max + Math.round(Math.ceil(((double) curr) / x));
      }
      long min = Math.round(Math.ceil(((double) sum) / x));
      System.out.println(min + " " + max);
    }
  }
}
