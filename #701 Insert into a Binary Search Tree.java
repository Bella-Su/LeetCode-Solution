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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root == null)
            return new TreeNode(val);
        
// solution 1
        else if(root.val > val)
            root.left = insertIntoBST(root.left, val);
        else
            root.right = insertIntoBST(root.right, val);
// solution 2
//         TreeNode temp = root;
        
//         // find the condition to break the loop
//         while(true){
//             // move to right tree if root < val
//             if(temp.val < val){
//                 if(temp.right == null){
//                     temp.right = new TreeNode(val);
//                     break;
//                 }
//                 else
//                     temp = temp.right;
//             }
//             // move to left tree if root > val
//             else {
//                 if(temp.left == null){
//                     temp.left = new TreeNode(val);
//                     break;
//                 }
//                 else
//                     temp = temp.left;
//             }
//         }
        
        return root;
    }
}