package leetcode.yearendmarathon.nov262k21;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * @author : ssuddhapally
 * @since : 26/11/21, Fri
 **/


//class Pair<U,V> {
//  public U first;
//  public V second;
//
//  public Pair(U first, V second) {
//    this.first = first;
//    this.second = second;
//  }
//}

public class LoggerLimit {
  public Set<String> set;
  public LinkedList<Pair<String, Integer>> msgQueue;

  public LoggerLimit() {
    set = new HashSet<String>();
    msgQueue = new LinkedList<Pair<String, Integer>>();
  }

  public boolean shouldPrintMessage(int timestamp, String message) {
    while (msgQueue.size() > 0) {
      Pair<String, Integer> head = msgQueue.getFirst();
      if (timestamp - head.second >= 10) {
        msgQueue.removeFirst();
        set.remove(head.first);
      } else {
        break;
      }
    }

    if (!set.contains(message)) {
      Pair<String, Integer> newEntry = new Pair<String, Integer>(message, timestamp);
      msgQueue.addLast(newEntry);
      set.add(message);
      return true;
    } else {
      return false;
    }
  }
}