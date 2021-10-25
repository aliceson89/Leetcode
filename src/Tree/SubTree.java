package Tree;
import java.util.*;
/**
 * [Lowest Common Ancestor - no.572] - traversal
 * URL : https://leetcode.com/problems/subtree-of-another-tree
 * Question :
 * Given the roots of two binary trees root and subRoot,
 * return true if there is a subtree of root with the same structure and node values of subRoot and false otherwise.
 *
 * A subtree of a binary tree tree is a tree that consists of a node in tree and
 * all of this node's descendants. The tree tree could also be considered as a subtree of itself.
 *
 *
 *
 * Example 1:
 * Input: root = [3,4,5,1,2], subRoot = [4,1,2]
 * Output: true
 *
 * Example 2:
 * Input: root = [3,4,5,1,2,null,null,0], subRoot = [4,1,2]
 * Output: false
 *
 * Constraints:
 *
 *     The number of nodes in the root tree is in the range [1, 2000].
 *     The number of nodes in the subRoot tree is in the range [1, 1000].
 *     -104 <= root.val <= 104
 *     -104 <= subRoot.val <= 104
 *
 */
public class SubTree {

    /**
     * Approach1
     *
     *
     * ******************************************************************************************************
     * [Complexity Analysis]
     *     Time complexity : O(m∗n). In worst case(skewed tree) traverse function takes O(m∗n) time.
     *
     *     Space complexity : O(n). The depth of the recursion tree can go upto n.
     *     n refers to the number of nodes in s.
     * @param root
     * @param subTree
     * @return
     */
    public static boolean isSubtree1(TreeNode root, TreeNode subTree) {

        //Case 1 : "root is null" means can't compare with subTree
        if(root == null)
            return false;
        //Case 2 : root and subTree are identical
        if(isEqual(root, subTree))
            return true;

        //Case 3 : root's right tree or left tree are identical with subTree.
        return isEqual(root.left,subTree) || isEqual(root.right,subTree);

    }

    public static boolean isEqual(TreeNode root, TreeNode subTree){
        //Case 1 : root and subTree both are null -> 2 nodes are same
        if (root == null && subTree == null)
            return true;
        //Case 2 :
        // 1) root is null and subTree is not null -> 2 nodes are different
        // 2) root is not null and subTree is null -> 2 nodes are different
        if (root == null || subTree == null)
            return false;
        //Case 3 :
        // root is not null and subTree is not null + root.val != subTree.val
        if (root.val != subTree.val)
            return false;
        // Condition
        // root is not null and subTree is not null + root.val == subTree.val
        // Plus) the left node and right side node also Equal.
        return isEqual(root.left, subTree.left) && isEqual(root.right, subTree.right);
    }



    HashSet < String > trees = new HashSet < > ();
    public static boolean isSubtree2(TreeNode s, TreeNode t) {
        String tree1 = preorder(s, true);
        String tree2 = preorder(t, true);
        return tree1.indexOf(tree2) >= 0;
    }
    public static String preorder(TreeNode t, boolean left) {
        if (t == null) {
            if (left)
                return "lnull";
            else
                return "rnull";
        }
        return "#"+t.val + " " +preorder(t.left, true)+" " +preorder(t.right, false);
    }


    public static void main(String[] args){
        // Test 1
        TreeNode root = new TreeNode(3);
        root.left= new TreeNode(4);
        root.right =new TreeNode(5);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(2);

        TreeNode subTree = new TreeNode(4);
        subTree.left= new TreeNode(1);
        subTree.right =new TreeNode(2);

        System.out.println(isSubtree1(root,subTree));
        System.out.println(isSubtree2(root,subTree));

    }


}
