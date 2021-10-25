package Tree;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * [Pre Order Traversal - no.144]
 *  URL : https://leetcode.com/problems/binary-tree-preorder-traversal/
 * root -> left -> right
 * Question :Given the root of a binary tree, return the postorder traversal of its nodes' values.
 *
 * Example 1:
 * Input: root = [1,null,2,3]
 * Output: [1,2,3]
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
 * Constraints:
 *
 *     The number of nodes in the tree is in the range [0, 100].
 *     -100 <= Node.val <= 100
 *
 *
 */


public class PreorderTraversal extends TreeNode{

    /**
     * Way 1
     * @param root
     * @return
     *
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Binary Tree Preorder Traversal.
     * Memory Usage: 37.2 MB, less than 47.36% of Java online submissions for Binary Tree Preorder Traversal.
     *
     * ************************************************************************************************************
     * Time Complexity : O(n). n = the number of nodes
     * Space complexity : O(h) = height of trees
     */
    public static List<Integer> preorderTraversal1(TreeNode root) {
        List<Integer> path = new ArrayList<>();
        traverse(root,path);
        return path;
    }

    public static void traverse(TreeNode root, List<Integer> path){
        if (root == null)
            return;
        path.add(root.val);
        traverse(root.left,path);
        traverse(root.right,path);
    }

    /**
     * Way2
     * @param root
     * @return
     *
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Binary Tree Preorder Traversal.
     * Memory Usage: 37.2 MB, less than 63.40% of Java online submissions for Binary Tree Preorder Traversa
     *
     */
    public static List<Integer> preorderTraversal2(TreeNode root) {
        List<Integer> path = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<TreeNode>();

        while( root != null){
            path.add(root.val);
            if (root.right != null){
                stack.push(root.right);
            }
            root = root.left;
            if ( root == null && !stack.isEmpty()){
                root = stack.pop();
            }

        }

        return path;

        /**
         *     List<Integer> res =  new LinkedList();
         *     if(root == null) return res;
         *     Stack<TreeNode> stack = new Stack();
         *     TreeNode cur = null;
         *     stack.push(root);
         *
         *     while(!stack.isEmpty()){
         *         cur = stack.pop();
         *         while(cur != null){
         *             res.add(cur.val);
         *             if(cur.right != null) stack.push(cur.right);
         *             cur = cur.left;
         *         }
         *     }
         *     return res;
         */

        /**
         *         List<Integer> path = new ArrayList<>();
         *         if(root == null) return path;
         *         Stack<TreeNode> stack = new Stack<>();
         *         while(!stack.isEmpty() || root!=null) {
         *             while(root!=null) {
         *                 path.add(root.val);
         *                 stack.push(root);
         *                 root=root.left;
         *             }
         *             root = stack.pop();
         *             root = root.right;
         *         }
         *         return path;
         */
    }

    public static void main (String[] args){
        // Test 1
        TreeNode root1 = new TreeNode(1);
        root1.left= null;
        root1.right = new TreeNode(2);
        root1.right.left = new TreeNode(3);

        preorderTraversal1(root1).forEach(System.out::println);
        preorderTraversal2(root1).forEach(System.out::println);

        //Test 2
        TreeNode root2 = new TreeNode(1);
        root2.left= null;
        root2.right = new TreeNode(2);

        preorderTraversal1(root2).forEach(System.out::println);
        preorderTraversal2(root2).forEach(System.out::println);


        //Test 3
        TreeNode root3 = new TreeNode(1);
        root3.left = new TreeNode(2);

        preorderTraversal1(root3).forEach(System.out::println);
        preorderTraversal2(root3).forEach(System.out::println);




    }


}
