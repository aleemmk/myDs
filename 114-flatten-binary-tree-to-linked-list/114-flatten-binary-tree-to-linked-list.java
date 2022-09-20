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
 
 Recursive Approach :
 we process the right sub tree ,then left subtree then node (postorder)
 
 maintained the previous pointer  root.right -> prev 

 This problem can be solved with morris traversal ;
*/
class Solution {
    private TreeNode prev = null;
    public void flatten(TreeNode root) {
         if(root == null)
             return ;
        
        
        flatten(root.right);
        flatten(root.left);
        
        root.right = prev;
        root.left = null;
        
        prev = root;
        
        
    }
}