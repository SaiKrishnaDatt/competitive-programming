package hackerearth.mayCircuit;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @author : ssuddhapally
 * @since : 22/05/21, Sat
 **/
public class Solution {
  public static void main(String args[]) throws Exception {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] values = br.readLine().split(" ");
    int n = Integer.parseInt(values[0]);
    int a = Integer.parseInt(values[1]);
    long x = Long.parseLong(values[2]);
    long oneCount = n-a;
    if( oneCount * a <x) {
      System.out.println("-1");
    }else {
//      int count =0;
//      int oneCountUsed =0;
//      for(int i =0; x > oneCount && i<x % oneCount;i++)
//      {
//        oneCountUsed++;
//        count++;
//        System.out.print("1 ");
//      }
//      for (int i = 1; i < a && count <n; i++) {
//        count++;
//        System.out.print("0 ");
//      }
//      for (int i =oneCountUsed ; i < oneCount && count < n; i++) {
//        count++;
//        oneCountUsed++;
//        System.out.print("1 ");
//      }
//      if(count<n){
//        count++;
//        System.out.print("0 ");
//      }
//      for(int i = count; i< n;i++){
//        System.out.print("1 ");
//      }
      // we know x, oneCount, zeroCount
      long zeroCount = a;
      if( zeroCount * oneCount == x) System.out.print("0 ");
      for (int i = 0; i < n; i++) {
        if( (zeroCount -1)  * oneCount >= x ){
          System.out.print("0 ");
          //x is unchanged
          //zeroCount dec
          zeroCount--;
        }
        else {
          System.out.print("1 ");
          //oneCount dec
          oneCount--;
          //x is changed
          x = x - zeroCount;
        }
      }
    }
  }
}
