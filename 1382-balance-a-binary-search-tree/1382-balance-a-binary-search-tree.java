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
 Intution:
  build inorder array
  
  simalar to binary search find the middle made it root and recusively call build function left and right subtree. 
*/

class Solution {
    List<TreeNode> list; 
    public TreeNode balanceBST(TreeNode root) {
        list = new ArrayList<>();
        inorder(root);
        int left=0;
        int right= list.size()-1;
      return   build(left,right);
        
    }
    
    private TreeNode build(int left,int right){
        if(right < left) return null;
        
        int mid = left+(right-left)/2;
        
        TreeNode root = list.get(mid);
        
        root.left  = build(left,mid-1);
        root.right =build(mid+1,right);
        
        return root;
        
    }
    
    private void  inorder(TreeNode root){
        if(null == root) return ;
        
         inorder(root.left);
         list.add(root);
         inorder(root.right);
        
    }
}