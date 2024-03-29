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
  Use DFS and keep track of current path max.
*/
class Solution {
    public int goodNodes(TreeNode root) {
        
        return preorder(root,root.val);
    }
    private int preorder(TreeNode root ,int max){
        if(root == null) return 0;
        
        int currMax = Math.max(root.val,max);
        
        int currNodeIsGood = root.val >=currMax?1:0;      // good for 1 0 for not good
        int goodNodeFromLeft = preorder(root.left,currMax);
        int goodnodeFromRight = preorder(root.right,currMax);    
        
    return  currNodeIsGood+goodNodeFromLeft+goodnodeFromRight ;
        
    }
}