package codeforces.div2.no694;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author : ssuddhapally
 * @since : 08/01/21, Fri
 **/
public class StrangeList {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int itr = Integer.parseInt(br.readLine());
    for (int i = 0; i < itr; i++) {
      String[] s = br.readLine().split(" ");
      int n = Integer.parseInt(s[0]);
      int x = Integer.parseInt(s[1]);
      s = br.readLine().split(" ");
      long sum = 0;
      int[] arr = new int[n];
      for (int j = 0; j < n; j++) {
        arr[j] = Integer.parseInt(s[j]);
      }
      int[] b = new int[n];
      for (int j = 0; j < n; j++) {
        int temp = arr[j];
        while (temp % x == 0) {
          temp = temp / x;
          b[j]++;
        }
      }
      int miniIndex =0;
      int minValue = 100000000;
      for (int j = 0; j < n; j++) {
        if (b[j] < minValue) {
          minValue = b[j];
          miniIndex = j;
        }
      }
      for (int j = 0; j < n; j++) {
        sum += (long) arr[j] * (minValue + 1);
        if (j < miniIndex)
          sum += arr[j];
      }
      System.out.println(sum);
    }
  }
}
