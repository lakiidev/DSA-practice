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
    public int rob(TreeNode root) {
        int[] res= dfs(root);

        // O
        return Math.max(res[0],res[1]);
    }

    //S
    private int[] dfs(TreeNode node)
    {
        //B
        if(node==null) return new int[]{0,0};
        //T
        int[] left = dfs(node.left);
        int[] right = dfs(node.right);

        // R
        int robbed=node.val + left[1]+right[1];

        //r
        int skipped = Math.max(left[0],left[1])+Math.max(right[0],right[1]);

        return new int[]{robbed,skipped};
    }
}