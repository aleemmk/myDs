class Solution {
    
    /**                 invert 
      [5 -3 -2 6 -1 4 ] =>  [-5 3 2 -6 1 -4 ]  
      
      we need to figure out minimum sum subarray   minSumSubArr 
      maxSumSubArray  = totalsumArr - minSumSubArr;
      
      after invert find max sum sub array by kadanes algo and do below in inverted array
        -(totalsumArr - maxSumSubArray);
        
        2 . find maxSumArray and minSumArray and totalSumArray
        
        totalSumArray-minSumArray  is the max sum in circular array if maxSumArray > 0 a and it is greater than total
        
        else in case of negative maxSumArray return this as a answer
      
    */
    public int maxSubarraySumCircular(int[] nums) {
       
        int currMaxSum = 0;
        int globalMaxSum = Integer.MIN_VALUE;
        int currMinSum = 0;
        int globalMinSum = Integer.MAX_VALUE;
        int total =0;
        
        for(int i=0;i<nums.length;i++){
        
              currMaxSum = Math.max(currMaxSum+nums[i],nums[i]);
              globalMaxSum = Math.max(currMaxSum,globalMaxSum);
            
              currMinSum = Math.min(currMinSum+nums[i],nums[i]);
              globalMinSum = Math.min(currMinSum,globalMinSum);
            
            total += nums[i];
        
        }
        
        if(globalMaxSum > 0) return Math.max(globalMaxSum ,total-globalMinSum);
        
        return globalMaxSum;
     }
}