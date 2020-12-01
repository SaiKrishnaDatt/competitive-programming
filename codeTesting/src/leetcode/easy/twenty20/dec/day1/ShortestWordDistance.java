package leetcode.easy.twenty20.dec.day1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * @author : ssuddhapally
 * @since : 02/12/20, Wed
 **/
class ShortestWordDistance {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] s = br.readLine().split(",");
    String word1 = br.readLine();
    String word2 = br.readLine();
    shortestDistance(s,word1,word2);
  }
  public static int shortestDistance(String[] words, String word1, String word2) {
    List<Integer> w1 = new ArrayList<>();
    List<Integer> w2 = new ArrayList<>();
    for (int i = 0; i < words.length; i++) {
      String word = words[i];
      if (word.equals(word1))
        w1.add(i);
      else if (word.equals(word2))
        w2.add(i);
    }
    int shortdist = words.length;
    shortdist = getShortdist(w1, w2, shortdist);
    shortdist = getShortdist(w2,w1,shortdist);
    return shortdist;
  }

  private static int getShortdist(List<Integer> w1, List<Integer> w2, int shortdist) {
    for (int k = 0, m = 0; k < w1.size() && m < w2.size(); k++) {
      int t1 = w1.get(k);
      int t2 = w2.get(m);
      if (t1 > t2)
        m++;
      shortdist = Math.min(shortdist, Math.abs(t2 - t1));
    }
    return shortdist;
  }
}
