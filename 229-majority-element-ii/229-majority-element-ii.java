class Solution {
    public List<Integer> majorityElement(int[] nums) {
        
        
        /**
          the intution behind approach
          we have  > n/3 as mojirty it means we may have at most 2 majority element and minimum 0      majority element
          majority and minority element cancel each other.
          
          we need to find two candidates and then check if they are majority element or not.
        */
        
        int candidate1 = 0;
            int candidate2 = 0;
            
            int count1 = 0;
            int count2=0;
        
        for(int num:nums){
            
            if(candidate1 == num){
                count1++;
            }else if(candidate2 == num){
                count2++;
            }else if(count1 == 0){
                candidate1 = num;
                count1=1;
            }
            else if(count2 == 0 ){
                candidate2 = num;
                count2=1;
            }
            else{
                count1--;
                count2--;
            }
            
            
        }
        List<Integer> res = new ArrayList<>();
         
          count1 = 0;
          count2=0;
         int n = nums.length;
        for(int num:nums){
            
            if(candidate1 == num)
                count1++;
            if(candidate2 == num)
                count2++;
        }
       
        if(count1 > n/3){
            res.add(candidate1);
        }
        if(count2 > n/3){
            res.add(candidate2);
        }
        if(candidate1 == candidate2)
            res.remove(1);
        return res;
    }
}