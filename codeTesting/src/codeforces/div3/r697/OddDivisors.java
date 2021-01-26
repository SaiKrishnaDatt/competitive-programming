package codeforces.div3.r697;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author : ssuddhapally
 * @since : 25/01/21, Mon
 **/
public class OddDivisors {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int itr = Integer.parseInt(br.readLine());
    for (int i = 0; i < itr; i++) {
      long val = Long.parseLong(br.readLine());
      while (val % 2 == 0) {
        val = val / 2;
      }
      if (val == 1) System.out.println("NO");
      else System.out.println("YES");

    }
  }
}
