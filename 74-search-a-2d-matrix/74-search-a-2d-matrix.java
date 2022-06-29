class Solution {
    
      /**
          in the given problem the first integer of each row is 
          greater than the last element of previous row.
          
          so we can treat this a single arrays 
          [row1,row2,row3... row m] we can apply binary search on this
          time complexity log(mn);
          
          but problem is to increase space complexity if store in another arr[];
          
          we can take imaginary index to iterate in same array.

          i =  mid/col  j = mid%col
          i = mid/m   j=mid % m
        */
    public boolean searchMatrix(int[][] matrix, int target) {
        
      if(matrix.length == 0) return false;
        
        int row = matrix.length;
        int col = matrix[0].length;
        int low = 0;
        int high = (row*col) -1;
            
            while(low <= high){
                
                int mid = low+ (high-low)/2;
                
                if(matrix[mid/col][mid%col] == target)
                    return true;
                else if(matrix[mid/col][mid%col] < target)
                 {
                     low = mid+1;
                 }else{
                    high = mid-1;
                }
                
            }
        return false;
        
    }
}