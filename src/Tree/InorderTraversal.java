package Tree;
import apple.laf.JRSUIUtils;

import java.util.*;

/**
 * [In Order Traversal - no.94]
 * URL : https://leetcode.com/problems/binary-tree-inorder-traversal/
 * left -> root -> right
 * Question:
 * Given the root of a binary tree, return the inorder traversal of its nodes' values.
 *
 * Example 1:
 * Input: root = [1,null,2,3]
 * Output: [1,3,2]
 *
 * Example 2:
 *
 * Input: root = []
 * Output: []
 *
 * Example 3:
 *
 * Input: root = [1]
 * Output: [1]
 *
 *
 */

public class InorderTraversal extends TreeNode{

    /**
     * Way 1 : using iterative - Recursive
     * @param root
     * @return
     *
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Binary Tree Inorder Traversal.
     * Memory Usage: 37.3 MB, less than 47.25% of Java online submissions for Binary Tree Inorder Traversal.
     *
     * ************************************************************************************************************
     * Time Complexity : O(n). n = the number of nodes
     * Space complexity : O(h) = height of trees
     * which stores exactly n elements
     */
    public static List<Integer> inorderTraversal1(TreeNode root) {
        List<Integer> path = new ArrayList<>();
        traverse (root, path);
        return path;
    }

    public static void traverse (TreeNode root, List<Integer> path){
        if (root == null)
            return;
        traverse(root.left,path); //left end
        path.add(root.val);
        traverse(root.right,path);
    }

    /**
     * Way2 : Stack
     * @param root
     * @return
     *
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Binary Tree Inorder Traversal.
     * Memory Usage: 36.9 MB, less than 89.23% of Java online submissions for Binary Tree Inorder Traversal.
     */
    public static List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> path = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode current = root;

        while (current != null || !stack.empty()){
            while(current != null){
                stack.add(current);
                current = current.left;
            }
            current = stack.pop();
            path.add(current.val);
            current = current.right;

        }
        return path;
    }



    public static void main(String[] args){


        TreeNode root = new TreeNode(1);
        root.left= null;
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);

        List<Integer> traversal1 = inorderTraversal1(root);
        traversal1.forEach(System.out::println);

        List<Integer> traversal2 = inorderTraversal2(root);
        traversal2.forEach(System.out::println);

    }

}
