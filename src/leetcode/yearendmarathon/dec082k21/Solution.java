package leetcode.yearendmarathon.dec082k21;

/**
 * @author : ssuddhapally
 * @since : 08/12/21, Wed
 **/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */

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

public class Solution {
  int tiltAns = 0;

  public int findTilt(TreeNode root) {
    if (root == null) return 0;
    int left = getSum(root.left);
    int right = getSum(root.right);
    tiltAns += Math.abs(left - right);
    //System.out.println(left + " " + right);
    return tiltAns;

  }

  int getSum(TreeNode root) {
    if (root == null) return 0;
    if (root.left == null && root.right == null) return root.val;
    int ans = 0;
    if (root.left == null) {
      int right = getSum(root.right);
      ans = root.val + right;
      root.val = Math.abs(right);
      // System.out.println(root.val);
    } else if (root.right == null) {
      int left = getSum(root.left);
      ans = root.val + left;
      root.val = Math.abs(left);
      //  System.out.println(root.val);
    } else {
      int left = getSum(root.left);
      int right = getSum(root.right);
      // System.out.println(left + " " + right);
      ans = root.val + left + right;
      root.val = Math.abs(left - right);
    }
    tiltAns += root.val;
    // System.out.println(root.val);
    return ans;
  }
}