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
    ListNode start;
    public boolean isPalindrome(ListNode head) {
        start = head;
        return  dfs(head);
        
        
    }
    
    private boolean dfs(ListNode head){
        
        if(head.next != null) 
            if(!dfs(head.next)) return false;
        
                  if(start.val != head.val)  return false;
                  start = start.next;
               
               return true;
        
    }
}