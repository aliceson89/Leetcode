package Tree;

import java.sql.SQLOutput;
import java.util.*;

/**
 * [Lowest Common Ancestor - no.236]
 * URL : https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
 * Question :
 *
 * Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.
 *
 * According to the definition of LCA on Wikipedia:
 * “The lowest common ancestor is defined between two nodes p and q as the lowest node in T
 * that has both p and q as descendants (where we allow a node to be a descendant of itself).”
 *
 * Example 1:
 * Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 * Output: 3
 * Explanation: The LCA of nodes 5 and 1 is 3.
 *
 * Example 2:
 * Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
 * Output: 5
 * Explanation: The LCA of nodes 5 and 4 is 5, since a node can be a descendant of itself according to the LCA definition.
 *
 * Example 3:
 * Input: root = [1,2], p = 1, q = 2
 * Output: 1
 *
 * Constraints:
 *
 *     The number of nodes in the tree is in the range [2, 105].
 *     -109 <= Node.val <= 109
 *     All Node.val are unique.
 *     p != q
 *     p and q will exist in the tree.
 *
 *
 */
public class LowestCommonAncestor {
    /**
     * Approach 1 : Recursive, postorder
     * [Algorithm]
     *
     * Start traversing the tree from the root node.
     * If the current node itself is one of p or q,
     * we would mark a variable mid as True and continue the search
     * for the other node in the left and right branches.
     *
     * If either of the left or the right branch returns True, t
     * his means one of the two nodes was found below.
     * If at any point in the traversal,
     * any two of the three flags left,
     * right or mid become True, this means we have found the lowest common ancestor for the nodes p and q.
     *
     * 1 --> 2 --> 4 --> 8
     * BACKTRACK 8 --> 4
     * 4 --> 9 (ONE NODE FOUND, return True)
     * BACKTRACK 9 --> 4 --> 2
     * 2 --> 5 --> 10
     * BACKTRACK 10 --> 5
     * 5 --> 11 (ANOTHER NODE FOUND, return True)
     * BACKTRACK 11 --> 5 --> 2
     *
     * 2 is the node where we have left = True and right = True and hence it is the lowest common ancestor
     *
     * ******************************************************************************************************
     * [Complexity Analysis]
     *
     *     Time Complexity: O(N), where N is the number of nodes in the binary tree.
     *     In the worst case we might be visiting all the nodes of the binary tree.
     *
     *     Space Complexity: O(N), This is because the maximum amount of space utilized by the recursion stack
     *     would be N since the height of a skewed binary tree could be N
     *
     *
     * @param currentNode
     * @param p
     * @param q
     * @return
     */

    public static TreeNode recurseTree(TreeNode currentNode, TreeNode p, TreeNode q) {


        if (currentNode == null || currentNode == p || currentNode ==q)
            return currentNode;

        //recursion until find the p or q or the leaf
        TreeNode left = recurseTree(currentNode.left,p,q);
        TreeNode right = recurseTree(currentNode.right,p,q);

        //p,q exist below different subtrees;
        if (left != null && right != null){
            return currentNode;
        }

        //p,q exist below the same subtree;
        return left != null ? left : right;

    }


    public static TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {

        return recurseTree(root,p,q);
    }

    public static TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {

        // Stack for tree traversal
        Deque<TreeNode> stack = new ArrayDeque<>();

        // HashMap for parent pointers
        Map<TreeNode, TreeNode> parent = new HashMap<>();

        parent.put(root, null);
        stack.push(root);

        // Iterate until we find both the nodes p and q
        while (!parent.containsKey(p) || !parent.containsKey(q)) {

            TreeNode node = stack.pop();

            // While traversing the tree, keep saving the parent pointers.
            if (node.left != null) {
                parent.put(node.left, node);
                stack.push(node.left);
            }
            if (node.right != null) {
                parent.put(node.right, node);
                stack.push(node.right);
            }
        }

        // Ancestors set() for node p.
        Set<TreeNode> ancestors = new HashSet<>();

        // Process all ancestors for node p using parent pointers.
        while (p != null) {
            ancestors.add(p);
            p = parent.get(p);
        }

        // The first ancestor of q which appears in
        // p's ancestor set() is their lowest common ancestor.
        while (!ancestors.contains(q))
            q = parent.get(q);
        return q;
    }




    public static void main (String[] args){
        // Test 1
        TreeNode root1 = new TreeNode(3);
        root1.left= new TreeNode(5);
        root1.left.left =new TreeNode(6);
        root1.left.left.left = null;
        root1.left.left.right = null;
        root1.left.right =new TreeNode(2);
        root1.left.right.left =new TreeNode(7);
        root1.left.right.right =new TreeNode(4);
        root1.right = new TreeNode(1);
        root1.right.left = new TreeNode(0);
        root1.right.right = new TreeNode(8);

        TreeNode p1 = root1.left;
        TreeNode q1 = root1.right;

        TreeNode p2 = root1.left;
        TreeNode q2 = root1.left.right.right;

        int LCA1 = lowestCommonAncestor1(root1,p1,q1).val;
        int LCA2 = lowestCommonAncestor2(root1,p2,q2).val;
        System.out.println(LCA1);
        System.out.println(LCA2);
    }
}
