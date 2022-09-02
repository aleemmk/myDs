class Solution {
    
    /**
      we can use min heap of size k 
      
      if size > k  remove top element of heap 
      atlast we have only k element in heap return top element 
     TC
     
     n logk
    */
     public int findKthLargest1(int[] nums, int k) {
         
         PriorityQueue<Integer> minheap = new PriorityQueue<>();  // minheap
         
         for(int num:nums){
             
             minheap.offer(num);
             if(minheap.size() > k) minheap.poll();
             
             
         }
         return minheap.poll();
     }
    
    
    public int findKthLargest(int[] nums, int k) {
        /**
         Kth largest means  n-k+1 smallest .
         
         n= 6
         
         arr [1,2,3,4,5,6]    k = 3 largest.  // 4
         

         intution is to to select pivot and find the index of pivot element as per partition of
         quick sort , 
         
        */
        int n = nums.length;
        int left = 0 ;
        int right = n-1;
        //  here we need to pass k-1 for k th smallest so (n-k+1)-1 = n-k 
       return  quickSelect(nums,n-k,0,right);
        
    }
    
    private int quickSelect(int [] nums ,int k ,int left,int right){

         int pivot = nums[right];
         int pi = partition(nums,left,right,pivot);

         if(k > pi ){
            return  quickSelect(nums,k,pi+1,right);
         }else if(k < pi){
             return quickSelect(nums,k,left,pi-1);
         }else{
             return nums[pi];
         }
    }
    
    private int partition(int [] nums ,int left,int right, int pivot){
        int i=left;
        int j=left;

        while(i <= right){
            if(nums[i] <= pivot){
                swap(i,j,nums);
                i++;
                j++;
            }else{
                i++;
            }
        }
        return j-1;
  }
    
    public void swap(int i, int j, int[] array) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
    
}