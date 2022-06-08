class Solution {
    public int totalHammingDistance(int[] nums) {
        
        /**
        no of position at which corresponding bits are different.
           [4,14,2] 
           hd(4,14)+hd(4,2) + hd(14,2);  
           4  = 0 1 0 0
           14 = 1 1 1 0
           ---------------------
                 2
             ============
            4  = 0 1 0 0
            2  = 0 0 1 0
           ---------------
                    2
           ============= 
           14 = 1 1 1 0
            2 = 0 0 1 0
        --------------------
                 2
         total hd  =6
         
           4  = 0 1 0 0
           14 = 1 1 1 0
            2 = 0 0 1 0
            find number of zeros and one at a bit in all number
            TC = TC + one * zero  for each bit
           
        */
        
        int count = 0;
        int n = nums.length;
       
        for(int i=0;i<32;i++){
             int one = 0;
             int zero = 0;
            for(int j=0;j<n;j++){
                
                if((nums[j] & 1) == 1)
                    one++;
                else{
                    zero++;
                }
                nums[j] = nums[j] >> 1;
            }
            count = count + (one*zero);
            
        }
        
        return count;
    }
}