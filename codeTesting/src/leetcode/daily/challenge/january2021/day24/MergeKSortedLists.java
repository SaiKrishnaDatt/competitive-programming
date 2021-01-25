package leetcode.daily.challenge.january2021.day24;

/**
 * @author : ssuddhapally
 * @since : 25/01/21, Mon
 **/

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class ListNode {
  int val;
  ListNode next;

  ListNode() {
  }

  ListNode(int val) {
    this.val = val;
  }

  ListNode(int val, ListNode next) {
    this.val = val;
    this.next = next;
  }
}

class MergeKSortedLists {
  public ListNode mergeKLists(ListNode[] lists) {
    int k = lists.length;
    ListNode ansRoot = null;
    if (k == 0) return null;
    ListNode last = lists[0];
    List<Integer> temp = new ArrayList<>(k);
    for (int i = 0; i < k; i++) {
      ListNode curr = lists[i];


      while (curr != null) {
        if (ansRoot == null) ansRoot = curr;
        temp.add(curr.val);
        last = curr;
        curr = curr.next;
      }

      if (last != null && i + 1 < k && lists[i + 1] != null) {
        last.next = lists[i + 1];
      }
    }
    Collections.sort(temp);

    int ele = 0;
    ListNode curr = ansRoot;
    for (int i = 0; i < temp.size(); i++) {

      curr.val = temp.get(i);
      curr = curr.next;
    }
    return ansRoot;

  }
}