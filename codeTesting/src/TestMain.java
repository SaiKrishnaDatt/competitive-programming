import java.io.*;
import java.util.*;

public class TestMain {

  public static void main(String[] args) throws IOException {
    /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
    // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    Scanner sc = new Scanner(System.in);
    // BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int t=Integer.parseInt(sc.nextLine());
    while(t>0) {
      // String[] inp = br.readLine().split(" ");
      int n = Integer.parseInt(sc.nextLine());
      Integer[] ar = new Integer[n];
      System.out.print("given array: ");
      for(int i=0;i<n;i++) {
        ar[i] = sc.nextInt();
        System.out.print(ar[i]+" ");
      }
      System.out.println();
      HighComparator hc= new HighComparator();
      Arrays.sort(ar,hc);
      for(int i=0;i<ar.length;i++) {
        System.out.print(ar[i]);
      }
      System.out.print("\n");
      if(t!=1) {
        sc.nextLine();
      }
      // bw.flush();
      // bw.close();
      // br.close();
      t--;
    }
  }
}


class HighComparator implements Comparator<Integer> {
  public int compare(Integer i1, Integer i2) {
    System.out.println("compare method called: ");
    int x=i1;
    int y=i2;
    int dx=(int)Math.floor(Math.log10(x))+1;
    int dy=(int)Math.floor(Math.log10(y))+1;
    int xtemp = (int)Math.pow(10,dx-1);
    int ytemp = (int)Math.pow(10,dy-1);
    for(int i=0;i<Math.min(dx,dy);i++) {
      System.out.println("\titer:"+i+" x:"+x+" y:"+y+" dx:"+dx+" dy:"+dy+" xtemp:"+xtemp+" ytemp:"+ytemp+" x/xtemp:"+x/xtemp+" y/ytemp:"+y/ytemp);
      if(x/xtemp > y/ytemp) {
        return -1;
      }
      else if(x/xtemp < y/ytemp) {
        return 1;
      }
      x=x%xtemp;y=y%ytemp;
      xtemp=xtemp/10;ytemp=ytemp/10;
    }
    return dx-dy;
  }
}