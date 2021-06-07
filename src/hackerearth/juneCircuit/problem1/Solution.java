package hackerearth.juneCircuit.problem1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author : ssuddhapally
 * @since : 05/06/21, Sat
 **/

/*

3
100 400 1000 1200
100 450 1000 1350
150 400 1200 1200


 */
public class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int itr = Integer.parseInt(br.readLine());
    for (int i = 0; i < itr; i++) {
      String[] s = br.readLine().split(" ");
      int millPerUnit = Integer.parseInt(s[0]);
      int gramPerUnit = Integer.parseInt(s[1]);
      int reqPerUnit = Integer.parseInt(s[2]);
      int reqGramUnit = Integer.parseInt(s[3]);
      int ceilMilli = (int) Math.ceil((float) reqPerUnit / millPerUnit);
      int ceilGram = (int) Math.ceil((float) reqGramUnit / gramPerUnit);
      System.out.println(ceilMilli + (long) ceilGram);
    }
  }
}
