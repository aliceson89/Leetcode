package Tree;

import java.util.*;

/**
 *
 *  [Minimum depth - no.111]
 *  URL : https://leetcode.com/problems/binary-tree-level-order-traversal/
 *  Question:
 *  Given a binary tree, find its minimum depth.
 *
 *  The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
 *
 *  Note: A leaf is a node with no children.
 *
 *
 *
 * Example 1:
 * Input: root = [3,9,20,null,null,15,7]
 * Output: 2
 *
 * Example 2:
 * Input: root = [2,null,3,null,4,null,5,null,6]
 * Output: 5
 *
 *
 *
 * Constraints:
 *
 *     The number of nodes in the tree is in the range [0, 105].
 *     -1000 <= Node.val <= 1000
 *
 */
public class MinDepthTree {

    /** Solution 1: DFS
     * Key point:
     * if a node only has one child -> MUST return the depth of the side with child, i.e. MAX(left, right) + 1
     * if a node has two children on both side -> return min depth of two sides, i.e. MIN(left, right) + 1
     * */

    public static int minDepth(TreeNode root) {
        if(root == null) return 0;
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        /**
         *  case of (left == 0 || right == 0 ) = True
         *  1) left == 0 and right != 0 : root's left does not have children
         *  2) left != 0 and right == 0 : root's right does not have children
         *  3) left == 0 and right == 0 : root does not have children
         *
         *  case of (left == 0 || right == 0 ) = False
         *  1) left == 0 and right == 0
         *  2) left > 0 and right > 0
         */
        return (left == 0 || right == 0) ? left + right + 1: Math.min(left,right) + 1;

    }

    public static int minDepth2(TreeNode root){
        if (root == null)
            return 0;

        // Base case : Leaf Node. This accounts for height = 1.
        if (root.left == null && root.right == null)
            return 1;

        // If left subtree is NULL, recur for right subtree
        if (root.left == null)
            return minDepth2(root.right) + 1;

        // If right subtree is NULL, recur for left subtree
        if (root.right == null)
            return minDepth2(root.left) + 1;

        return Math.min(minDepth2(root.left),
                minDepth2(root.right)) + 1;
    }

    public int minDepthDFS(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = minDepthDFS(root.left);
        int right = minDepthDFS(root.right);
        if (left == 0 || right == 0) {
            return Math.max(left, right) + 1;
        }
        else {
            return Math.min(left, right) + 1;
        }
    }


    /** Solution 2: BFS level order traversal */
    public int minDepthBFS1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int level = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode curNode = queue.poll();
                if (curNode.left == null && curNode.right == null) {
                    return level;
                }
                if (curNode.left != null) {
                    queue.offer(curNode.left);
                }
                if (curNode.right != null) {
                    queue.offer(curNode.right);
                }
            }
            level++;
        }
        return level;
    }

    public int minDepthBFS2(TreeNode root) {
        Queue<TreeNode> queue=new java.util.LinkedList<TreeNode>();
        int depth=0;
        int prevdepth=0;
        if(root!=null) {
            queue.add(root);
            while(!queue.isEmpty()) {
                int size=queue.size();
                depth++;
                for(int i=0;i<size;i++) {
                    TreeNode n=queue.remove();
                    if(n.left==null && n.right==null) return depth;
                    if(n.left!=null) queue.add(n.left);
                    if(n.right!=null) queue.add(n.right);
                }

            }
        }
        return depth;
    }

    public static void main (String[] args){
        // Test 1
        TreeNode root1 = new TreeNode(3);
        root1.left= new TreeNode(9);
        root1.right = new TreeNode(20);
        root1.left.left = null;
        root1.left.right = null;
        root1.right.left = new TreeNode(15);
        root1.right.right = new TreeNode(7);

        System.out.println(minDepth(root1));


    }
}
