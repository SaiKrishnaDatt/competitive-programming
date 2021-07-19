package leetcode.daily.challenge.july.one8;


/**
 * @author : ssuddhapally
 * @since : 18/07/21, Sun
 **/
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


public class LinkedList {
  public static void main(String[] args) {
    ListNode head = new ListNode(1);
    ;
    ListNode ele1 = head;
    for (int i = 2; i <= 5; i++) {
      ListNode ele = new ListNode(i);
      ele1.next = ele;
      ele1 = ele1.next;
    }
    LinkedList ll = new LinkedList();
    ll.reverseKGroup(head, 3);
    System.out.println(head);
  }

  public ListNode reverseKGroup(ListNode head, int k) {
    ListNode prev = null;
    ListNode curr = head;
   boolean headChanged=false;
    ListNode prevLoopHead =new ListNode();
    while (curr != null) {
      int count = 0;
      ListNode loopStart=curr;
      prev =null;
      while (curr != null && count < k) {
        ListNode temp = curr.next;
        curr.next = prev;
        prev = curr;
        curr = temp;
        count++;
      }
      if(!headChanged){
        headChanged = true;
        head = prev;
      }
      else{
        prevLoopHead.next = prev;
      }
      if (count > 1 && count < k) {
        prev = null;
        curr = prevLoopHead.next;
        while (curr != null) {
          ListNode nextTemp = curr.next;
          curr.next = prev;
          prevLoopHead.next = curr;
          prev = curr;
          curr = nextTemp;
        }
      }
      else
      prevLoopHead = loopStart;
    }
    return head;
  }


}