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
    private int totalSum = 0;
    
    public int sumRootToLeaf(TreeNode root) {
        if(root == null)
            return 0;
        
        // passing root and current total sum to the helper function
        sumRootToLeafDFS(root, 0);
        return totalSum;
    }
    
    private void sumRootToLeafDFS(TreeNode root, int currSum){
        // base case
        if(root == null)
            return;
        
        // update the current sum before we check the base case
        currSum = currSum + root.val;
        
        // base case, if the node is a leaf
        if(root.left == null && root.right == null){
            totalSum += currSum;
            return;
        }
        
        sumRootToLeafDFS(root.left, currSum*2);
        sumRootToLeafDFS(root.right, currSum*2);
    }
}