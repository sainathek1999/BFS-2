   /**
    Time Complexity : O(N)
    Explanation:
    We traverse the tree once using DFS to locate both nodes
    and record their parent and level.

    Space Complexity : O(H)
    Explanation:
    Recursion stack can go up to the height of the tree (H).
    In worst case (skewed tree) it can be O(N).

    Did this code successfully run on LeetCode : Yes

    Any problem you faced while coding this :
    Initially confused about the exact condition for cousins.
    Later clarified that two nodes are cousins if:
        1) They are at the same level
        2) They have different parents
    So while traversing the tree, I stored parent and level
    for both nodes and compared them at the end.
    */

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {

    int xparent = 0;
    int yparent = 0;
    int xlevel = 0;
    int ylevel = 0;

    public boolean isCousins(TreeNode root, int x, int y) {

        dfs(root, 0, x, y);

        if (xlevel == ylevel) {
            return xparent != yparent;
        }

        return false;
    }

    private void dfs(TreeNode root, int level, int x, int y) {

        if (root == null) return;

        // Check if x is child of current node
        if ((root.left != null && root.left.val == x) ||
            (root.right != null && root.right.val == x)) {

            xparent = root.val;
            xlevel = level + 1;
        }

        // Check if y is child of current node
        if ((root.left != null && root.left.val == y) ||
            (root.right != null && root.right.val == y)) {

            yparent = root.val;
            ylevel = level + 1;
        }

        dfs(root.left, level + 1, x, y);
        dfs(root.right, level + 1, x, y);
    }
}