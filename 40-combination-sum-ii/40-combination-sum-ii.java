class Solution {
    /**
    in 39. Combination Sum ,we may picked picked each element as much I want.
    
     Each number in candidates may only be used once in the combination.
     
     for soultion must not contains duplicates we need to SORT the array.
     candidates : [2,1,2,1]   target = 4
                
               [1 1 2 2]
     
    
    */
    List<List<Integer>> res;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
         res = new ArrayList<>();
        
        List<Integer> list = new ArrayList<>();
        Arrays.sort(candidates);
         findCombination(0,candidates,target,list);
        
        return res;
    }
    
     private void findCombination(int start,int [] candidates,int target,List<Integer> list){
        
         if(target == 0){
                 res.add(new ArrayList<>(list));
                return;
            }
      
         for(int i=start;i<candidates.length;i++){
             
             if(i > start && candidates[i]== candidates[i-1]) continue;
             
             if(candidates[i] <= target){
              
                list.add(candidates[i]);
                findCombination(i+1,candidates,target-candidates[i],list);
                list.remove(list.size()-1);
             }
         }
           
        
    }
}