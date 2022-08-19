class Solution {
    /**
     each number have two choices , + or - we have knapsak value is target
     
     
    */
    int count=0;
   // int dp[][];
    Map<Integer,Integer> mapArray [] ;  // currSum and way mapping
    public int findTargetSumWays(int[] nums, int target) {
        
        
        int index = nums.length-1;
        int currSum = 0;
        mapArray = new HashMap[nums.length];
        //dp = new int [nums.length+1][target+1];
         return targetSumWays1(index,nums,currSum,target);
        
         //targetSumWays2(0,nums,currSum,target);
         //return count;
    }
    
    private int targetSumWays1(int index,int[] nums, int currSum,int target){
        // base case
    
        if(index < 0 && currSum == target)
            return 1;
        if(index < 0) return 0;
        
        Map<Integer,Integer> map = mapArray[index];
        if(map !=null && map.containsKey(currSum)) return map.get(currSum);
            
        int positive = targetSumWays1(index-1,nums,currSum+nums[index],target);
        int negative = targetSumWays1(index-1,nums,currSum+(-nums[index]),target);
        
        int ways = positive+negative;
        
        if(map == null)map = new HashMap<>(); 
        
        map.put(currSum,ways);
        mapArray[index] = map;
        return ways;
    }
    
    private void targetSumWays2(int index,int[] nums, int currSum,int target){
        
        if(index == nums.length) {
           if(target==currSum) count++;
              return ;
        }
          targetSumWays2(index+1,nums,currSum+nums[index],target);
          targetSumWays2(index+1,nums,currSum-nums[index],target);
    }
}