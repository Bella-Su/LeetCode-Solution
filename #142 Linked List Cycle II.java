/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if(head == null)
            return head;
        
        // fast and slow pointer technique
        ListNode fast = head;
        ListNode slow = head;
        boolean start = true;
        // iterate until fast and slow meet the first time
        while(fast != slow || start){
            start = false;
            if(slow != null)
                slow = slow.next;
            if(fast != null)
                fast = fast.next;
            if(fast != null)
                fast = fast.next;
        }
        
        fast = head;
        while(slow != fast){
            if(fast != null)
                fast = fast.next;
            if(slow != null)
                slow = slow.next;
        }
        // after the second meet the fast will point to the beginning of the cycle
        return fast;
    }
}
// a: number of nodes before starting of the cycle
// b: number of nodes between starting of the cycle and the first meet
// c: the rest node to the starting of the cycle
// first meet take: a+b+c+b
// second meet take: a+b
// F = 2S => c=a 