package hackerearth.karomi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

/**
 * @author : ssuddhapally
 * @since : 29/05/21, Sat
 **/
public class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int itr = Integer.parseInt(br.readLine());
    for (int i = 0; i < itr; i++) {
      int len = Integer.parseInt(br.readLine());
      int n = Integer.parseInt(br.readLine());
      String[] arr = br.readLine().split(" ");
      Integer[] intArr = new Integer[len];
      for (int j = 0; j < len; j++) {
        intArr[j] = Integer.parseInt(arr[j]);
      }
      Arrays.sort(intArr, Collections.reverseOrder());
      char[] max = getBinary(n);
      int ind = 0;
      long ans = 0;
      while (ind < intArr.length) {
        int temp = intArr[ind];
        char[] binary = getBinary(temp);
        double computeAj = 0;
        int pow2 = 0;
        for (int z = 0; z < binary.length && z < max.length; z++) {
          if (binary[z] != max[z] && binary[z] == '0') {
            computeAj = computeAj + Math.pow(2, pow2);
            max[z] = '0';
          }
          pow2++;
        }
        int currXor = (int) computeAj ^ temp;
        ans += currXor;
        intArr[ind] = currXor;
        int intValue = Integer.parseInt(String.valueOf(max));
        ind++;
        if (intValue == 0) break;
      }
      while (ind < intArr.length) {
        ans += intArr[ind++];
      }
      System.out.println(ans);
    }
  }

  public static char[] getBinary(int numMod) {
    StringBuilder sb = new StringBuilder();
    while (numMod > 0) {
      int temp = numMod % 2;
      sb.append(temp);
      numMod = numMod / 2;
    }
    return sb.toString().toCharArray();
  }
}
