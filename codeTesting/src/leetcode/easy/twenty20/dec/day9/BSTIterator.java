package leetcode.easy.twenty20.dec.day9;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : ssuddhapally
 * @since : 09/12/20, Wed
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

public class BSTIterator {
  TreeNode root;
  List<TreeNode> ansList = new ArrayList<>();
  int curr;

  public BSTIterator(TreeNode root) {
    inOrder(root);
    curr = 0;
  }

  public int next() {
    return ansList.get(curr++).val;
  }

  public boolean hasNext() {
    if (curr < ansList.size()) {
      return true;
    }
    return false;
  }

  public void inOrder(TreeNode root) {
    if (root != null) {
      inOrder(root.left);
      ansList.add(root);
      inOrder(root.right);
    }
  }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */