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
    public int goodNodes(TreeNode root) {
        return goodNodesCounter(root,root.val);
    }
    private final int goodNodesCounter(TreeNode node,int maxSoFar)
    {
        if(node==null) return 0;
        int newMax = Math.max(maxSoFar, node.val);
        int count = goodNodesCounter(node.left, newMax) + goodNodesCounter(node.right, newMax);
        return node.val >= maxSoFar ? ++count : count;    
    }
}
