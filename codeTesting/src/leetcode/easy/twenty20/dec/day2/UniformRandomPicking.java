package leetcode.easy.twenty20.dec.day2;

/**
 * @author : ssuddhapally
 * @since : 03/12/20, Thu
 **/

import java.util.Random;

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

class UniformRandomPicking {

  ListNode head;
  int size;
  Random random;

  /**
   * @param head The linked list's head.
   *             Note that the head is guaranteed to be not null, so it contains at least one node.
   */
  public UniformRandomPicking(ListNode head) {
    this.head = head;
    size = lengthOfList(head);
    random = new Random();
  }

  /**
   * Returns a random node's value.
   */
  /**
   * Returns a random node's value.
   */
  public int getRandom() {
    ListNode cur = head;
    int rand = random.nextInt(size);
    while (rand-- > 0) {
      cur = cur.next;
    }

    return cur.val;
  }

  public int lengthOfList(ListNode head) {
    int i = 1;
    while (head.next != null) {
      head = head.next;
      i++;
    }
    return i;
  }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */