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

/**
https://www.geeksforgeeks.org/find-first-node-of-loop-in-a-linked-list/

*/
public class Solution {
    public ListNode detectCycle(ListNode head) {
         if (head == null) return null;
        ListNode slow = head;
        ListNode fast = head;
        
        while(fast != null && fast.next != null){  // slow always behind so check for fast only 
            
            slow = slow.next;
            fast = fast.next.next;
            
            if(slow == fast) {
                ListNode newPointer= head;
              
                while(slow !=newPointer){
                  newPointer = newPointer.next;
                   slow = slow.next;
                }
                
                return slow;
            }
            
            
        }
        return null;
    }
}