package leetcode.yearendmarathon.dec292k21;

/**
 * @author : ssuddhapally
 * @since : 29/12/21, Wed
 **/
/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
  public Node connect(Node root) {
    Queue<Node> queue = new LinkedList<Node>();
    Node temp = new Node(10);
    queue.add(root);
    queue.add(temp);
    Node prev = null;
    Node curr = null;
    while(!queue.isEmpty()){
      prev = curr;
      curr = queue.poll();

      if(curr == temp){
        prev = null;
        curr = null;
        if(!queue.isEmpty())
          queue.add(temp);
        continue;
      }
      else if(curr !=null){
        if(curr.left !=null)
          queue.add(curr.left);
        if( curr.right !=null)
          queue.add(curr.right);

      }
      if( prev !=null){
        // System.out.println("prev.next "+prev.val+"->"+curr.val);
        prev.next = curr;

      }


    }
    return root;
  }
}