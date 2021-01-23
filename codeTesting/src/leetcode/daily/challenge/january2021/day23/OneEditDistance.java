package leetcode.daily.challenge.january2021.day23;

/**
 * @author : krishnaDuttSharma
 * @since : 23/01/21, Sat
 **/

class OneEditDistance {
  public boolean isOneEditDistance(String s, String t) {
    boolean skippedOneTime = false;
    boolean status = true;
    if (s.length() == t.length()) {
      for (int i = 0; i < s.length(); i++) {
        if (s.charAt(i) != t.charAt(i)) {
          if (skippedOneTime) {

            return false;

          } else
            skippedOneTime = true;
        }
      }
      return skippedOneTime;
    } else if (Math.abs(s.length() - t.length()) == 1) {
      for (int i = 0, j = 0; i < s.length() && j < t.length(); i++, j++) {
        if (s.charAt(i) != t.charAt(j)) {
          if (skippedOneTime) {
            return false;
          } else {
            skippedOneTime = true;
            if (s.length() < t.length()) i--;
            else j--;
          }
        }
      }
      return true;

    }
    return false;
  }
}