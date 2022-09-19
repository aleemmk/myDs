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
   We can have two pointer , slow and fast 
   run fast pointer with double pace and compared to slow . if the meet some where it means cycle else not
   
*/
public class Solution {
    public boolean hasCycle(ListNode head) {
        
        if (head == null) return false;
        ListNode slow = head;
        ListNode fast = head;
        
        while(fast != null && fast.next != null){
            
            slow = slow.next;
            fast = fast.next.next;
            
            if(slow == fast) return true;
            
            
        }
        return false;
    }
}