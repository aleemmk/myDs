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


  /**
      Recursive version of preorder traversal uses recusive stack to remember the parent nodes.
      
      1. iterative solution:
      =================
      most intutive iterative solution is to use stack data structure . 
      TC =   O(n)
      space complexity O(n)
      so complexity is same as recursive version if we count recursive stack as a space .
      
      2. Iterative solution :
      Moris traversal , the intution behind this is to maintain threaded binary tree.
      
      cases1 :  if left == null
             just print curr node and come to right;
             
             case2: if left !=null
             go to the left and move to the extreme right most guy and build a tread. so that we can                remember when we back;
             
             as soon as we buid thred print curr (preorder ) then move left .
             
               TC =   O(n)
               space complexity O(1)
               
               difference in inorder and preorder morris traversal
               
               inorder we print root node after trvesing left tree when we come back in second time
               in preorder as first we print then move to the left 
      
      
    */
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
         List<Integer> preorder = new ArrayList<>();
        
        TreeNode curr = root;
        
        while(curr != null){
            
            if(curr.left == null){
                preorder.add(curr.val);
                curr = curr.right;
            }else{
                
                TreeNode prev = curr.left;
                
                while(prev.right !=null && prev.right !=curr){
                    prev = prev.right;
                }
                
                if(prev.right == null){
                    // we need to make a thread to curr here 
                    
                    prev.right = curr;
                    preorder.add(curr.val);  // add this line for preorder
                    curr = curr.left;
                    
                }else{
                    // already have connected with thread , disconnect it
                    
                    prev.right = null;
                    
                    //inorder.add(curr.val);  remove this line as it is used in inorder
                    
                    curr = curr.right;
                    
                }
            }
        }
        return preorder;
    }
}