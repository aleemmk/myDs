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


/**
 brute force solution 
 
 GIven : array of head pointer of list
 
 make a list of integer that contains val of all list , need to add all ist val one by one
 
 sort above list
 make a fresh linked list by pick value from sorted list .
 
 return head pointer of that list.
 
 TC
 =====
 k list
 n log n soluton
 
*/
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        
        List<Integer> list = new ArrayList<>();
        
        for(ListNode listNode:lists){
            
            ListNode head = listNode;
            
            while(head  != null){
                list.add(head.val);
                head = head.next;
            }
        }
        
        Collections.sort(list);
        
        ListNode newList = new ListNode(0);
        
        ListNode head = newList;
        
        for(Integer val:list){
            ListNode listNode = new ListNode(val);
            head.next = listNode;
            head = listNode;
        }
        
        
        return newList.next;
        
    }
    
    
    
    
    
}