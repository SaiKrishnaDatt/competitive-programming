package hackerearth.amagi;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * @author : krishnaDutt
 * @since : 08/08/20, Sat
 *
Input
6
1 1 -3 2 -4 3
 Output
 5 7

 **/

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    String arr[] = br.readLine().split(" ");
    int[] intArr = new int[arr.length];
    for (int i = 0; i < arr.length ; i++) {
      intArr[i] = Integer.parseInt(arr[i]);
    }
    solve(n, intArr);
  }

  private static void solve(int n, int[] intArr) {
    boolean prevSign = intArr[0]>0? true:false;
    List<Integer> list = new ArrayList<>();
    int pcount =0;
    int ncount =0;
    long grandPos =0;
    long grandNeg =0;
    int prevSum =intArr[0];
    int maxNeg1=0,maxNeg2=0,maxPos1=0,maxPos2=0;
    for (int i = 1; i < n; i++) {
      boolean currSign = intArr[i]>0? true:false;
      if(currSign==prevSign)
      {
       prevSum+=intArr[i];
      }
      else
      {
        list.add(prevSum);
        prevSign = currSign;
        if(currSign)  {
          pcount++;
          if(maxNeg1>prevSum)
          {
            maxNeg2=maxNeg1;
            maxNeg1=prevSum;
          }
          else if(maxNeg2>prevSum){
            maxNeg1=prevSum;
          }
          grandNeg+=prevSum;
        }
        else {
          ncount++;
          if(maxPos1<prevSum)
          {
            maxPos2=maxPos1;
            maxPos1=prevSum;
          }
          else if(maxPos2<prevSum){
            maxPos2=prevSum;
          }
          grandPos+=prevSum;

        }
        prevSum=intArr[i];
      }

    }
    list.add(prevSum);
    if(intArr[intArr.length-1]>0)  {
      pcount++;
      if(maxNeg1>prevSum)
      {
        maxNeg2=maxNeg1;
        maxNeg1=prevSum;
      }
      else if(maxNeg2>prevSum){
        maxNeg1=prevSum;
      }
      grandPos+=prevSum;
    }
    else {
      ncount++;
      if(maxPos1<prevSum)
      {
        maxPos2=maxPos1;
        maxPos1=prevSum;
      }
      else if(maxPos2<prevSum){
        maxPos2=prevSum;
      }
      grandNeg+=prevSum;
    }
    System.out.print(list.size());
    if(pcount==0 || maxPos2 ==0) System.out.print(" " + Math.abs(grandNeg-maxPos1));
    else if(ncount ==0 || maxNeg2 ==0) System.out.print(" " + Math.abs(grandPos+maxNeg1));
    else if(grandPos> -1 *grandNeg  ) System.out.print(" " + Math.abs(grandPos+maxNeg1+maxNeg2));
    else System.out.print(" " + Math.abs(grandNeg+maxPos1+maxPos2));
  }
}