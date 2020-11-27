import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
  /*
3
1
1
2
2
1 2
2 1
2
1 1
2 2

   */
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    for (int i = 0; i < n; i++) {
      int size = Integer.parseInt(br.readLine());
      String[] first = br.readLine().split(" ");
      String[] second = br.readLine().split(" ");
      int[] A = new int[size];
      int[] B = new int[size];
      for (int j = 0; j < size; j++) {
        A[j] = Integer.parseInt(first[j]);
        B[j] = Integer.parseInt(second[j]);

      }
      Map<Integer, Integer> aMap = new TreeMap<>();
      Map<Integer, Integer> bMap = new TreeMap<>();
      for (int j = 0; j < size; j++) {
        aMap.putIfAbsent(A[j], 0);
        aMap.put(A[j], aMap.get(A[j]) + 1);
      }
      for (int j = 0; j < size; j++) {
        Integer aval = aMap.get(B[j]);
        if (aval != null) {
          if (aval > 1) {
            aval--;
            aMap.put(B[j],aval);
          }
          else aMap.remove(B[j]);

        } else {
          bMap.putIfAbsent(B[j], 0);
          bMap.put(B[j], bMap.get(B[j]) + 1);
        }
      }

      ArrayList<Pair> aPairs = new ArrayList<>();
      ArrayList<Pair> bPairs = new ArrayList<>();
//            int countA = 0;
//            int countB = 0;
      long count =0;
      boolean fail = false;
      for (Map.Entry<Integer, Integer> entry : aMap.entrySet()) {
        if (entry.getValue() % 2 != 0) {
          fail = true;
          break;
        }
        //countA += entry.getValue() / 2;
        aPairs.add(new Pair(entry.getKey(),entry.getValue()));
      }
      if (!fail) {
        for (Map.Entry<Integer, Integer> entry : bMap.entrySet()) {
          if (entry.getValue() % 2 != 0) {
            fail = true;
            break;
          }
          //countB += entry.getValue() / 2;
          bPairs.add(new Pair(entry.getKey(),entry.getValue()));
        }
      }
      // System.out.println(aPairs.toArray().toString());
      if (fail) System.out.println("-1");
      else {
        if(aPairs.size() !=0 && bPairs.size()!=0){
          if(aPairs.get(0).getKey()<bPairs.get(0).getKey()){
            //count = reduceArraysAndReturnCount(aPairs, bPairs, count);
            count = aPairs.get(0).getKey();
          }
          else{
            //count = reduceArraysAndReturnCount(bPairs,aPairs,count);
            count = bPairs.get(0).getKey();
          }
        }
        System.out.println(count);
      }
    }
  }

  private static long reduceArraysAndReturnCount(ArrayList<Pair> aPairs, ArrayList<Pair> bPairs, long count) {
    int newA = aPairs.get(0).getValue()-2;
    int newB = bPairs.get(bPairs.size()-1).getValue()-2;
    count +=  aPairs.get(0).getKey();
    if(newA>0){
      aPairs.get(0).setValue(newA);
    }
    else{
      aPairs.remove(0);
    }
    if(newB>0){
      bPairs.get(bPairs.size()-1).setValue(newB);
    }
    else{
      bPairs.remove(bPairs.size()-1);
    }
    return count ;
  }
}
class Pair{
  Integer key;

  Integer value;
  Pair(Integer key,Integer value){
    this.key = key;
    this.value = value;
  }
  Integer getKey(){ return key;}
  Integer getValue(){ return value;}
  void setKey(Integer key){
    this.key = key;
  }
  void setValue(Integer value){this.value = value;}


}

