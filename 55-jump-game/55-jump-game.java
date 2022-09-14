class Solution {
    
    /**
    
    
    */
    public boolean canJump(int[] nums) {
        
        int maxReachable = 0;
        
        for(int i =0;i<nums.length;i++){
            
            
            if(maxReachable < i)
                return false;
                
                if(maxReachable < i+nums[i]){
                    maxReachable = i+nums[i];
                }
            
        }
        return true;
        
    }
}