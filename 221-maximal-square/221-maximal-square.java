class Solution {
    /**
    
    intution :
    [1], [        
         1,1
         1,1
        ]      
        
        [
         1,1,1
         1,1,1
         1,1,1
        ]  

   above is 3X3 matrix of 1 it , contains 2X2 matrix ,
   these are over lapping subproblem and we need to calculate only once and use the result of previous calculation.
   
   TC  O(m*n)
   
   space O(m*n)
   
   we can further optimize the space because we just need two rows to fill dp table 
   how ??
   
  
    */
    public int maximalSquare(char[][] matrix) {
        
        int rows = matrix.length;
       int cols = matrix[0].length;
        
        int dp [][] = new int [rows+1][cols+1];
        
        for(int[] arr:dp) Arrays.fill(arr,0);
        
        int largest = 0;
        
        for(int i=1;i<=rows;i++){
            for(int j=1;j<=cols;j++){
                
                if(matrix[i-1][j-1] == '1'){   // check element is 1 only 
                    dp[i][j] = 1+Math.min(dp[i-1][j-1],Math.min(dp[i-1][j],dp[i][j-1]));   // take min of  _\|
                    largest = Math.max(largest,dp[i][j]);
                }
            }
        }
        
        return largest*largest;
    }
}