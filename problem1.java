   /**
    Time Complexity : O(N)
    Explanation:
    We perform a level-order traversal (BFS) and visit each node once.

    Space Complexity : O(N)
    Explanation:
    The queue may contain up to one level of the tree at a time.
    In the worst case (complete tree) it can store about N/2 nodes.

    Did this code successfully run on LeetCode : Yes

    Any problem you faced while coding this :
    Initially unsure how to capture the rightmost node of each level.
    Solved it by performing BFS level by level and storing the last
    node encountered in each level traversal.
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

 

    public List<Integer> rightSideView(TreeNode root) {

        Queue<TreeNode> q = new LinkedList<>();
        List<Integer> li = new ArrayList<>();

        if (root == null) return li;

        q.add(root);

        while (!q.isEmpty()) {

            int size = q.size();
            int last = 0;

            for (int i = 0; i < size; i++) {

                TreeNode t = q.poll();
                last = t.val;

                if (t.left != null) q.add(t.left);
                if (t.right != null) q.add(t.right);
            }

            // The last node processed at this level is the rightmost
            li.add(last);
        }

        return li;
    }
}