package Tree;
import java.util.*;

/**
 * [Post Order Traversal - no.145]
 * URL : https://leetcode.com/problems/binary-tree-postorder-traversal/
 * left -> right -> root
 * Question:
 * Given the root of a binary tree, return the postorder traversal of its nodes' values.
 *
 * Example 1:
 * Input: root = [1,null,2,3]
 * Output: [3,2,1]
 *
 * Example 2:
 * Input: root = []
 * Output: []
 *
 * Example 3:
 * Input: root = [1]
 * Output: [1]
 *
 * Example 4:
 * Input: root = [1,2]
 * Output: [2,1]
 *
 * Example 5:
 * Input: root = [1,null,2]
 * Output: [2,1]
 *
 * Constraints:
 *
 *     The number of the nodes in the tree is in the range [0, 100].
 *     -100 <= Node.val <= 100
 *
 */
public class PostorderTraversal extends TreeNode{
    /**
     * Way1
     * @param root
     * @return
     *
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Binary Tree Postorder Traversal.
     * Memory Usage: 37.1 MB, less than 78.68% of Java online submissions for Binary Tree Postorder Traversal.
     *
     * ************************************************************************************************************
     * Time Complexity : O(n). n = the number of nodes
     * Space complexity : O(h) = height of trees
     */
    public static List<Integer> postorderTraversal1(TreeNode root) {
        List<Integer> path = new ArrayList<>();
        traversal(root, path);
        return path;

    }

    public static void traversal(TreeNode root, List<Integer> path){
        if(root == null)
            return;
        traversal(root.left, path);
        traversal(root.right,path);
        path.add(root.val);
    }

    public static List<Integer> postorderTraversal2(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root == null) return list;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode pre = null;
        TreeNode current = root;
        while(!stack.isEmpty() || root!=null) {
            while(root!=null) {
                stack.push(root);
                root= root.left;
            }
            current = stack.pop();
            if (current.right != null && pre != current.right){
                stack.push(current);
                current = current.right;
                //continue -> go to while(!stack.isEmpty() || root!=null) 
                continue;

            }
            list.add(current.val);
            pre = current;
            current =null;
        }
        return list;

    }

    /**
     * Deque
     * @param root
     * @return
     *
     * public static List<Integer> postorderTraversal(TreeNode root) {
     *         //LinkedList instead of ArrayList in postorder approach.
     *         // It is because LinkedList will cost O(1) of inserting operation, however, it is O(n) for ArrayList.
     *         LinkedList<Integer> result = new LinkedList<>();
     *         Deque<TreeNode> stack = new ArrayDeque<>();
     *         TreeNode p = root;
     *         while(!stack.isEmpty() || p != null) {
     *             if(p != null) {
     *                 stack.push(p);
     *                 result.addFirst(p.val);  // Reverse the process of preorder
     *                 p = p.right;             // Reverse the process of preorder
     *             } else {
     *                 TreeNode node = stack.pop();
     *                 p = node.left;           // Reverse the process of preorder
     *             }
     *         }
     *         return result;
     *     }
     */


    /**
     * public List<Integer> postorderTraversal(TreeNode root) {
     *         List<Integer> list = new ArrayList<>();
     *         if(root == null) return list;
     *         Stack<TreeNode> stack = new Stack<>();
     *         stack.push(root);
     *         while(!stack.isEmpty()) {
     *             TreeNode curr = stack.pop();
     *             list.add(0,curr.val);
     *             if(curr.left!=null) {
     *               stack.push(curr.left);
     *             }
     *             if(curr.right!=null) {
     *                stack.push(curr.right);
     *             }
     *         }
     *         return list;
     *     }
     *
     */

    public static void main (String[] args){
        // Test 1
        TreeNode root1 = new TreeNode(1);
        root1.left= new TreeNode(2);
        root1.right = new TreeNode(3);
        root1.right.left = new TreeNode(4);
        root1.right.right = new TreeNode(5);

        postorderTraversal1(root1).forEach(System.out::println);
        postorderTraversal2(root1).forEach(System.out::println);

        /**Test 2
        TreeNode root2 = new TreeNode(1);
        root2.left= null;
        root2.right = new TreeNode(2);

        postorderTraversal1(root2).forEach(System.out::println);
        postorderTraversal2(root2).forEach(System.out::println);


        //Test 3
        TreeNode root3 = new TreeNode(1);
        root3.left = new TreeNode(2);

        postorderTraversal1(root3).forEach(System.out::println);
        postorderTraversal2(root3).forEach(System.out::println);

        **/


    }
}
