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
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        Stack<TreeNode> st1 = new Stack<>();
        Stack<TreeNode> st2 = new Stack<>();
        List<Integer> ans = new ArrayList<>();
        
        // implement in-order traversal
        while(root1 != null || root2 != null || !st1.empty() || !st2.empty()){
            while(root1 != null){
                st1.push(root1);
                root1 = root1.left;
            }
            while(root2 != null){
                st2.push(root2);
                root2 = root2.left;
            }
            
            // if stack st2 is empty 
            // or top value in st1 is equal or smaller than top value at st2
            if(st2.empty() || (!st1.empty() && st1.peek().val <= st2.peek().val)){
                root1 = st1.pop();
                ans.add(root1.val);
                root1 = root1.right;
            }else{
                root2 = st2.pop();
                ans.add(root2.val);
                root2 = root2.right;
            }
        }
        return ans;
    }
}
// m and n is number of nodes of the trees
// Hm and Hm is the height of the trees
// time: O(m+n)
// space: O(Hm+Hn)