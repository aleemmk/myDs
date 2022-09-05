class Solution {
    
    int [] nums;
     Random rand;
    public Solution(int[] nums) {
        this.nums = nums;
        this.rand = new Random();
    }
    
    public int[] reset() {
        return nums;
    }
    
    public int[] shuffle() {
        Random rand = new Random();
        int [] cloneArr = nums.clone();   // clone original array shuffled it and return
        
        for(int j=1;j<nums.length;j++){
           
            int i= rand.nextInt(j+1);    //  produce a number between 0 to j (0 inclusive anf j exclusive)
            
            swap(cloneArr,i,j);
          
        }
          return cloneArr;
       
    }
    
    private void swap(int arr[],int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */