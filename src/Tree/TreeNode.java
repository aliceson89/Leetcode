package Tree;

/**
 * Question :
 * Given the root of a binary tree, return the inorder traversal of its nodes' values.
 * <p>
 * Example 1:
 * Input: root = [1,null,2,3]
 * Output: [1,3,2]
 * <p>
 * Example 2:
 * Input: root = []
 * Output: []
 * <p>
 * Input: root = [1]
 * Output: [1]
 * <p>
 * Input: root = [1,2]
 * Output: [2,1]
 * <p>
 * Input: root = [1,null,2]
 * Output: [1,2]
 * <p>
 * Constraints:
 * <p>
 * The number of nodes in the tree is in the range [0, 100].
 * -100 <= Node.val <= 100
 * <p>
 * Constraints:
 * <p>
 * The number of nodes in the tree is in the range [0, 100].
 * -100 <= Node.val <= 100
 */

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
        this.left = null;
        this.right = null;
    }

    TreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right= null;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
