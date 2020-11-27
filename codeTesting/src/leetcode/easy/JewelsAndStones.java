package leetcode.easy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.BrokenBarrierException;

/**
 * @author : krishnaDutt
 * @since : 09/08/20, Sun
 **/
public class JewelsAndStones {

  public static void main(String[] args) {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String J = "aA";
    String S = "aAAbbbb";
    System.out.println(numJewelsInStones(J,S));
  }
  public static  int numJewelsInStones(String J, String S) {
    Map<Character, Integer> map = new HashMap<>();
    for(int i=0 ;i<S.length();i++)
    {
      map.putIfAbsent(S.charAt(i),0);
      map.put(S.charAt(i),map.get(S.charAt(i))+1);
    }
    int count =0;
    for (int i = 0; i <J.length() ; i++) {
      Integer integer = map.get(J.charAt(i));
      if(integer != null)
      {
        count+=integer;
      }
    }
    return count;

  }
}
