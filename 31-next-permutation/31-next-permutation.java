class Solution {
    public void nextPermutation(int[] nums) {
     int n = nums.length;
        if( n < 2)
          return;
        int index = n-1;
        
        while(index >0){
            if(nums[index-1] < nums[index]){
                break;
            }
            index--;
        }
        
        if(index == 0){
            reverse(nums,0,n-1);
        }else{
             int val = nums[index-1];
             int j;
             for(j=n-1; j >=0;j-- ){
               if(val < nums[j])
                break;
              }
            
            swap(nums,index-1,j);
            reverse(nums,index,n-1);
           }
            
    }
 
    public void swap(int [] nums,int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    public void reverse(int[] nums, int start,int end){
        while(start < end){
            swap(nums,start++,end--);
        }
    }
}