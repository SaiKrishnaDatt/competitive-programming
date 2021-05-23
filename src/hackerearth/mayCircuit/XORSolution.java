package hackerearth.mayCircuit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author : ssuddhapally
 * @since : 22/05/21, Sat
 **/
public class XORSolution {
  public static void main(String[] args)  throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int loop = Integer.parseInt(br.readLine());
    for (int i = 0; i < loop; i++) {
      int res =0;
      int n = Integer.parseInt(br.readLine());
//      for (int j = 1; j <= n; j++) {
//        res = res ^ j;
//      }
      if( n%4==0) res = n;
      if( n%4==1) res =1;
      if( n %4 == 2) res = n+1;
      if( n%4 ==0 ) res = 0;
      if( res !=0 ) {
        if (res <= n) {
          System.out.println("1 " + res);
        }
        else{
          System.out.println("2 " + n +" 1" );
        }
      }
      else
      {
        System.out.println("0");
      }
    }

  }
}
