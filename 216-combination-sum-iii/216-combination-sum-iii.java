class Solution {
    
    /**
      arr[] = [1,2,3,4,5,6,7,8,9]
      
      k numbers and target 
      
      same as combination sum 2
      addition as size of output and target
    */
    List<List<Integer>> res ;
    public List<List<Integer>> combinationSum3(int k, int n) {
        res = new ArrayList<>();
        
        List<Integer> ds = new ArrayList<>(); 
        combinationSum3(1,k,n,ds);
        
        return res;
    }
    
    private void combinationSum3(int start,int k, int target,List<Integer> ds){
        
        if(ds.size() > k) return ;
        
        if(ds.size() == k && target == 0) {
            res.add(new ArrayList<>(ds));
            return;
        }
            
        for(int i=start;i<=9;i++){
            
            if(i <= target){
            ds.add(i);
            combinationSum3(i+1,k,target-i,ds);
            ds.remove(ds.size()-1);
            }    
       }
    }
}