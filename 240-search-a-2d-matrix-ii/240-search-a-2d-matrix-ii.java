class Solution {
    
    /**
      row is sorted from left to right
      col is sorted from top to bottom
      
      use above property
      
      The idea behind approach we sit 15 in example 1
      target = 5
      15 > target move to 11
      11 > target move to 7
      7 > target move to 4
      4 < target move to 5
      
      after each move check with the target if equal return true;
      
      complexity  O(m+n) only one traversal is needed
      space o(1);
    */
    public boolean searchMatrix(int[][] matrix, int target) {
        
        int m = matrix.length;
        int n = matrix[0].length;
        
        int i=0 ; 
        int j = n-1;
        
        while(i< m && j >= 0){
            
            if(matrix[i][j] == target) return true;
            
            if(matrix[i][j] > target) j--;
            else{
                i++;
            }
        }
        return false;
        
    }
}