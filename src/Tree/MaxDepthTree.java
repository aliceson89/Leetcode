package Tree;

import apple.laf.JRSUIUtils;

import java.util.List;

/**
 *  [Maximum depth - no.104]
 *  URL : https://leetcode.com/problems/binary-tree-level-order-traversal/
 *  Ref : https://www.geeksforgeeks.org/write-a-c-program-to-find-the-maximum-depth-or-height-of-a-tree/
 *
 *  [Terminology]
 *  Height of a node is the number of edges on the longest path from the node to a leaf.
 *  Depth of a node is the number of edges from the node to the tree's root node.
 *
 *   As far as height and depth of tree are concerned-
 *
 *   Height of a tree is height of root node and Depth of a tree is depth of deepest node since both of them
 *   will be same we generally don’t talk about depth of tree we use Height to refer that and As Height and
 *   Depth of Nodes can be different we use both terms for nodes.
 *
 *
 *  maxDepth()
 *  1. If tree is empty then return 0
 *  2. Else
 *      (a) Get the max depth of left subtree recursively  i.e.,
 *           call maxDepth( tree->left-subtree)
 *      (b) Get the max depth of right subtree recursively  i.e.,
 *           call maxDepth( tree->right-subtree)
 *      (c) Get the max of max depths of left and right
 *           subtrees and add 1 to it for the current node.
 *          max_depth = max(max dept of left subtree,
 *                              max depth of right subtree)
 *                              + 1
 *      (d) Return max_depth
 *
 *
 *     See the below diagram for more clarity about execution of the recursive function maxDepth() for above example tree.
 *
 *             maxDepth('1') = max(maxDepth('2'), maxDepth('3')) + 1
 *                                = 1 + 1
 *                                   /    \
 *                                 /         \
 *                               /             \
 *                             /                 \
 *                           /                     \
 *                maxDepth('2') = 1                maxDepth('3') = 0
 *        = max(maxDepth('4'), maxDepth('5')) + 1
 *        = 1 + 0   = 1
 *                    /    \
 *                  /        \
 *                /            \
 *              /                \
 *            /                    \
 *  maxDepth('4') = 0     maxDepth('5') = 0
 *
 *
 *  Question:
 *  Given the root of a binary tree, return its maximum depth.
 *
 *  A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 *
 *
 *
 * Example 1:
 * Input: root = [3,9,20,null,null,15,7]
 * Output: 3
 *
 * Example 2:
 *
 * Input: root = [1,null,2]
 * Output: 2
 *
 * Example 3:
 *
 * Input: root = []
 * Output: 0
 *
 * Example 4:
 *
 * Input: root = [0] -> Only root -> height 1
 * Output: 1
 *
 * Constraints:
 *
 *     The number of nodes in the tree is in the range [0, 104].
 *     -100 <= Node.val <= 100
 *
 *  Time Complexity: O(n) where n is number of nodes in the binary tree
 *  Space Complexity: O(n) where n is number of nodes in the binary tree, the space cost incurred on the stack size because of recursion calls
 *                    In some programming languages, the maximum size of the call stack is much less than the space available in the heap,
 *                    and recursive algorithms tend to require more stack space than iterative algorithms. Consequently,
 *                    these languages sometimes place a limit on the depth of recursion to avoid stack overflows;
 *                    Python is one such language.[16] Note the caveat below regarding the special case of tail recursion.
 *
 */
public class MaxDepthTree extends TreeNode{

    //start from bottom
    //ask : what is the level you are in?

    /**
     * Way 1 : DFS , postorder traversal
     * @param root
     * @return
     */
    public static int maxDepth1(TreeNode root) {

        if (root == null)
            return 0;


        int leftDepth = maxDepth1(root.left);
        int rightDepth = maxDepth1(root.right);


        return Math.max(leftDepth,rightDepth)+1;


    }


    public int maxDepth2(TreeNode root) {
        if (root == null) return 0;
        int leftMax = root.left == null ? 0 : maxDepth2(root.left);
        int rightMax = root.right == null ? 0 : maxDepth2(root.right);
        return 1 + Math.max(leftMax, rightMax);
    }

    public int maxDepth3(TreeNode root) {
        if(root==null){
            return 0;
        }
        return 1+Math.max(maxDepth3(root.left),maxDepth3(root.right));
    }

    /**
     * One line code
     * public int maxDepth(TreeNode root) {
     *         return (root == null)? 0 : Math.max(maxDepth(root.left), maxDepth(root.right))+1;
     *     }
     *
     */

    public static void main (String[] args){
        // Test 1
        TreeNode root1 = new TreeNode(3);
        root1.left= new TreeNode(9);
        root1.right = new TreeNode(20);
        root1.left.left = null;
        root1.left.right = null;
        root1.right.left = new TreeNode(15);
        root1.right.right = new TreeNode(7);

        System.out.println(maxDepth1(root1));


    }
}
