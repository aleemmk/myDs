class Solution {
    /**
    Goal : length of longest subarray contains equal number of 0 and 1.  like [0 0 1 1]
    
    observation : binary array only 0 and 1
    
    think of 0 as -1 (suppose if we replaced 0 with -1) then it become longest subarray whose sum is zero .
    
    use above property and calulate sum
    
    1. if sum is already seen it means in b/w current index and and already seen index all element cancelled each  other (sum 0 ).
    
    2.  if not seen store sum and index 
    
    3. if sum 0 means all element from start cancelled each other and sum 0 so length is  (curr index+1)
    
    
    TC 
    O(n)  
    space
    
    O(n)  need to store sum and index
    
    */
    
    public int findMaxLength(int[] nums) {
        
        
        Map<Integer,Integer> map = new HashMap<>();
        int longestArray = 0;
        int sum = 0;
        
        for(int i=0;i<nums.length;i++){
            
            int curr = nums[i]==0 ? -1:1;
            
            sum += curr;
            
            if(map.containsKey(sum)){
                longestArray = Math.max(longestArray, i-map.get(sum));
                
            }else if(sum == 0){
                longestArray = i+1;
                
            }else {
                map.put(sum,i);
            }
            
        }
        return longestArray;
    }
}