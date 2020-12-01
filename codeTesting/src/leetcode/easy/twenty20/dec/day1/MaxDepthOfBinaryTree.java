package leetcode.easy.twenty20.dec.day1;

/**
 * @author : ssuddhapally
 * @since : 02/12/20, Wed
 **/

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

class MaxDepthOfBinaryTree {
  public int maxDepth(TreeNode root) {
    return heightOfSubTree(root);
  }

  public int heightOfSubTree(TreeNode root) {
    if (root == null) {
      return 0;
    } else {
      return Math.max(heightOfSubTree(root.left), heightOfSubTree(root.right)) + 1;
    }
  }
}
