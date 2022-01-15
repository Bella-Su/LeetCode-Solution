/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    private ListNode head;

    public Solution(ListNode head) {
        this.head = head;
    }
    
    public int getRandom() {
        int chosenValue = 0;
        
        // create a current pointer to point to the head node
        ListNode curr = this.head;
        // create an varible to trace the position of the current node
        int scope = 1;
        
        while(curr != null){
            // returns double type number 0.0 <= x < 1.0
            // (1/scope) returns a value 0.0 < x <= 1.0
            if(Math.random() < (1.0 / scope))
                chosenValue = curr.val;
            
            // move to the next node by increasing the position and move current pointer to the next node
            scope += 1;
            curr = curr.next;
        }
        return chosenValue;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */