class Solution {
    
    /**
    This problem is very tricky and we can relate this we LT 84 .largest rectangle in histogram .
    each row represent a histogram  and 
    
    row[1][0] = ["1","0","1","0","0"] = heights1[];
    row[2][0] = [ "2","0","2","1","1"] = heights2[];
    
    each below row is the sum of above . 
    
    */
    public int maximalRectangle(char[][] matrix) {
        
        int rows = matrix.length; 
         int cols = matrix[0].length; 
        
        int dp [][] = new int[rows][cols];
        
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                dp [i][j] = matrix[i][j] -'0';
                if(dp[i][j] > 0 && i > 0){
                    dp[i][j]  += dp[i-1][j];
                }
            }
        }
        
        int maxArea = Integer.MIN_VALUE;
        for(int i=0;i<rows;i++){
            int heights [] = dp[i];
            
            maxArea = Math.max(maxArea,largestRectangleArea(heights));
            
        }  
        return maxArea;
    }
    
    public int largestRectangleArea(int[] heights) {
     int n = heights.length;
     int leftSmaller [] = new int[n];
     int rightSmaller [] = new int[n];
        
        Stack<Integer> st = new Stack<>();
        
    for(int i=0;i<n;i++){
        
      while(!st.isEmpty() && heights[st.peek()] >= heights[i] ) {
        st.pop();   // pop all ement which is higher than curr to make stack monotonically increasing
      }
        
        if(st.isEmpty()) leftSmaller[i] = 0;
        else leftSmaller[i] = st.peek()+1 ; // added 1 to define left boundry
        
        st.push(i);
    } 
        
        st.clear(); //  make stack emppty to reuse it for rightSmaller array.
            
     for(int i=n-1;i>=0;i--){
        
      while(!st.isEmpty() && heights[st.peek()] >= heights[i] ) {
        st.pop();   // pop all ement which is higher than curr to make stack monotonically increasing
      }
        
        if(st.isEmpty()) rightSmaller[i] = n-1;
        else rightSmaller[i] = st.peek()-1 ; // substract 1 to define right boundry
        
        st.push(i);
    }  
       
     //  calculate area .
        
        int maxArea = Integer.MIN_VALUE;
        
        for(int i=0 ;i<n;i++){
            
            maxArea = Math.max(maxArea,(rightSmaller[i]-leftSmaller[i]+1)* heights[i]);
            
        }
        
        return maxArea;
    }
}