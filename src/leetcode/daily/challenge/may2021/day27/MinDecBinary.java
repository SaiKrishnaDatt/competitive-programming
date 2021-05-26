package leetcode.daily.challenge.may2021.day27;

/**
 * @author : ssuddhapally
 * @since : 27/05/21, Thu
 **/
public class MinDecBinary {
  public int minPartitions(String n) {
    int max = 0;
    for (int i = 0; i < n.length(); i++) {
      max = Math.max(Integer.parseInt("" + n.charAt(i)), max);
    }
    return max;
  }
}