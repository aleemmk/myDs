class Solution {
    
    /**
      input : m and n and k
      
     intution:   kth smalles number must lie from 1 to m*n;
     
     we can apply binary search find mid of (low ,high) range .
     
     STEP 2 :  count all num smaller than equal to mid (<=) 
      if count >= k shift high to mid
      if count < k sift low to mid .
      
    */
    public int findKthNumber(int m, int n, int k) {
        
        int low = 1 ; 
        int high = m*n;
        
        while(low < high){
            int mid = low + (high-low)/2;
            
               int countSmallest = count(mid,m,n);
            
               if(countSmallest >=k)  high = mid;
                else{
                    low = mid+1;
                }
          }
        
         //  now high and low coincide and there is exactly k element smaller than or equal to low/high.
        
       return high;
       
    }
    
    // cleaver way of counting , observer table 
    //  2 4 6 8 10 12 14 16 18 20   no of element less than 15  , 15/2 =7 
    //  2 4 6 8 10 table is half written then it it will equal to n .
    // consider both we take min of above two cases
    
    private int count(int mid,int m,int n){
        int cunt = 0;
        
        for(int i=1;i<=m;i++){
            int temp = Math.min(mid/i,n);  // min of above cases 
            cunt += temp;
        }
        return cunt;
    }
}