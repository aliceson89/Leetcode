package Tree;
import java.util.*;

/**
 *
 *  [Level Order Traversal - no.102] - Breadth First Traversal
 *  URL : https://leetcode.com/problems/binary-tree-level-order-traversal/
 *
 *  Question:
 *  Given the root of a binary tree, return the level order traversal of its nodes' values.
 *  (i.e., from left to right, level by level).
 *
 *
 *
 * Example 1:
 * Input: root = [3,9,20,null,null,15,7]
 * Output: [[3],[9,20],[15,7]]
 *
 * Example 2:
 *
 * Input: root = [1]
 * Output: [[1]]
 *
 * Example 3:
 *
 * Input: root = []
 * Output: []
 *
 *
 * Constraints:
 *
 *     The number of nodes in the tree is in the range [0, 2000].
 *     -1000 <= Node.val <= 1000
 *
 * Time Complexity: O(n) where n is number of nodes in the binary tree
 * Space Complexity: O(n) where n is number of nodes in the binary tree
 *
 */

public class LevelorderTraversal {

    /**
     * ref : https://www.geeksforgeeks.org/arraylist-of-arraylist-in-java/
     *
     * @param root
     * @return
     */

    public static List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        List<List<Integer>> path = new ArrayList<>();
        while(!queue.isEmpty()){
            int len = queue.size();
            List<Integer> level = new ArrayList<>();
            for (int i = 0 ; i < len; i++){
                //queue.poll() : retrieve the first element and then remove
                TreeNode node = queue.poll();
                if (node != null){
                    level.add(node.val);
                    //queue can't insert null
                    queue.add(node.left);
                    queue.add(node.right);

                }
            }
            if ( !level.isEmpty()){
                path.add(level);
            }

        }
        return path;
    }

    public static void main (String[] args){
        // Test 1
        TreeNode root1 = new TreeNode(2);
        root1.left= new TreeNode(9);
        root1.right = new TreeNode(20);
        root1.right.left = new TreeNode(15);
        root1.right.right = new TreeNode(7);

        List<List<Integer>> path = levelOrder(root1);

        for (int i = 0; i < path.size(); i++) {
            System.out.print("level"+i+": ");
            for (int j = 0; j < path.get(i).size(); j++) {
                System.out.print(path.get(i).get(j) + " ");
            }
            System.out.println();
        }

    }




}