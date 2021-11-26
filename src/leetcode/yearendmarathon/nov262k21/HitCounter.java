package leetcode.yearendmarathon.nov262k21;

import java.util.LinkedList;

class Pair<U, V> {
  public U first;
  public V second;

  public Pair(U first, V second) {
    this.first = first;
    this.second = second;
  }
}

public class HitCounter {
  private static final int COUNTER_TIME_RANGE = 300;
  LinkedList<Pair<Integer, Integer>> timeline;
  int counter;

  public HitCounter() {
    timeline = new LinkedList<>();
  }

  public void hit(int timestamp) {
    boolean noMatch = true;
    if (!timeline.isEmpty()) {
      Pair<Integer, Integer> lastEntry = timeline.getLast();
      if (lastEntry.first == timestamp) {
        lastEntry.second = lastEntry.second + 1;
        noMatch = false;
      }
    }
    if (noMatch) {
      timeline.add(new Pair<Integer, Integer>(timestamp, 1));
    }
    counter++;
  }

  public int getHits(int timestamp) {
    while (timeline.size() > 0) {
      Pair<Integer, Integer> entry = timeline.getFirst();
      System.out.println(timestamp - entry.first);
      if (timestamp - entry.first > COUNTER_TIME_RANGE) {
        counter = counter - entry.second;
        timeline.removeFirst();
      } else {
        break;
      }
    }
    return counter;
  }
}

class HitCounterMain {
  public static void main(String[] args) {
    HitCounter hitCounter = new HitCounter();
    hitCounter.hit(1);       // hit at timestamp 1.
    hitCounter.hit(2);       // hit at timestamp 2.
    hitCounter.hit(3);       // hit at timestamp 3.
    hitCounter.getHits(4);   // get hits at timestamp 4, return 3.
    hitCounter.hit(300);     // hit at timestamp 300.
    hitCounter.getHits(300); // get hits at timestamp 300, return 4.
    hitCounter.getHits(301); // get hits at timestamp 301, return 3.
  }
}
