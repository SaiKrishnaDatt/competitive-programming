package codeforces.div3.r697;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author : ssuddhapally
 * @since : 25/01/21, Mon
 **/
public class PolyCrap {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int itr = Integer.parseInt(br.readLine());
    for (int i = 0; i < itr; i++) {
      boolean found = false;
      int val = Integer.parseInt(br.readLine());
      //x2020+y2021 == val
      for (int j = 0; j * 2020 <= val; j++) {
        if (val - j * 2020 == 0 || (val - j * 2020) % 2021 == 0) {
          System.out.println("YES");
          found = true;
          break;
        }
      }
      if (!found)
        System.out.println("NO");
    }
  }
}
