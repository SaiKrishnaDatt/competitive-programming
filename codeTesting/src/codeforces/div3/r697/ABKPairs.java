package codeforces.div3.r697;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author : ssuddhapally
 * @since : 25/01/21, Mon
 **/
public class ABKPairs {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int itr = Integer.parseInt(br.readLine());
    for (int i = 0; i < itr; i++) {
      String[] s = br.readLine().split(" ");
      int a = Integer.parseInt(s[0]);
      int b = Integer.parseInt(s[1]);
      int k = Integer.parseInt(s[2]);
      String[] aArr = br.readLine().split(" ");
      //List<Integer> boys = new ArrayList<>(k);
      int[] boys = new int[a];
      String[] bArr = br.readLine().split(" ");
      //List<Integer> girls = new ArrayList<>(k);
      int[] girls = new int[b];
      for (int j = 0; j < k; j++) {
        boys[(Integer.parseInt(aArr[j]) - 1)]++;
        girls[Integer.parseInt(bArr[j]) - 1]++;
      }
      long ans = 0;
      for (int j = 0; j < k; j++) {
        ans += k - boys[(Integer.parseInt(aArr[j]) - 1)] - girls[Integer.parseInt(bArr[j]) - 1] + 1;
      }
      System.out.println(ans / 2);
    }
  }
}
