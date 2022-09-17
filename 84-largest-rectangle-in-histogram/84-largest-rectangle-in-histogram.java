class Solution {
    /**
    
    need to calculate area corresponding to each bar with next smaller inleft side and next smaller in right side.
   
    brute force slution
    
    iterte all array  for every element i and find next smaller in left and next smaller in right.
    TC : O(n^2)
    
    optimize solution.

    We can use monotonic stack and prepare leftsmller and right smaller array .
    
    leftsmler is boundry in left side .
    
    right smaller is boundry in right side.
    
    area[i] = (rightSmallere index-leftsmaller index+1)*arr[i]
    

    
    */
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