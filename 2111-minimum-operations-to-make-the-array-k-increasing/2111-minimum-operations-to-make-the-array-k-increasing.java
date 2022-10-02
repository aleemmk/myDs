class Solution {
    
    /**
    300. Longest Increasing Subsequence
    use the concept of LIS
    
    here we divide the the list into groups forming with gap k
    in each group find the LIS(longest increasing subsequence) 
    
   min operation in first group = size(group) - longest incresing subsequence
    
    do this with all group and sum it and retrn the sum.
    
    
    
    
    */
    public int kIncreasing(int[] arr, int k) {
        int ans =0 ;
        
        for(int i=0;i<k;i++){
            List<Integer> list = new ArrayList<>();
            
            for(int j=i;j<arr.length;j=j+k){
                list.add(arr[j]);    // group of gap k
            }
            ans += list.size() - lengthOfLIS(list);     // each group size- LIS
        }
        return ans;
    }
    private int lengthOfLIS(List<Integer> list){
        
        List<Integer> iList = new ArrayList<>();
        
        iList.add(list.get(0));
        
        for(int i=1;i<list.size();i++){
            
            int lastItem = iList.get(iList.size()-1);
            if(list.get(i) >= lastItem){
                iList.add(list.get(i));   // add element if it is increasing
            }else{
                // find the index by binary search at which it need to be inserted to make increasing
                int idx = nextGreaterElement(iList,list.get(i));  
                iList.set(idx,list.get(i));     // inset at particular index.
            }
        }
        return iList.size();
        
    }
    
    private int nextGreaterElement(List<Integer> iList,int item){
        int low = 0;
        int high = iList.size()-1;
        
        while(low < high){
            int mid = low+(high-low)/2;
            
            if(iList.get(mid) <= item){
                low = mid+1;
            }else{
                high = mid;
            }
        }
        return low;
    }
    
}