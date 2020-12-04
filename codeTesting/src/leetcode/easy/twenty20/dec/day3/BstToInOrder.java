package leetcode.easy.twenty20.dec.day3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author : ssuddhapally
 * @since : 04/12/20, Fri
 **/

//Definition for a binary tree node.
class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;

  TreeNode() {
  }

  TreeNode(int val) {
    this.val = val;
  }

  TreeNode(int val, TreeNode left, TreeNode right) {
    this.val = val;
    this.left = left;
    this.right = right;
  }
}

class BstToInOrder {
  public TreeNode increasingBST(TreeNode root) {
    List<Integer> arr = new ArrayList<>();
    addElementsToList(root, arr);
    Collections.sort(arr);
    return createInOrderFromArr(arr);
  }

  public TreeNode createInOrderFromArr(List<Integer> arr) {
    int size = arr.size();
    int i = 0;
    TreeNode prev = null;
    TreeNode head = null;
    while (i < size) {
      TreeNode curr = new TreeNode(arr.get(i));
      if (i != 0) {
        prev.right = curr;
        prev = curr;
      } else {
        prev = curr;
        head = curr;
      }
      i++;
    }
    return head;

  }

  public void addElementsToList(TreeNode root, List<Integer> arr) {

    if (root != null) {
      arr.add(root.val);
      addElementsToList(root.left, arr);
      addElementsToList(root.right, arr);
    }
  }
}
