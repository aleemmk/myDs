class Solution {
    
    /**
      we can use min heap of size k 
      
      if size > k  remove top element of heap 
      atlast we have only k element in heap return top element 
     TC
     
     n logk
    */
     public int findKthLargest(int[] nums, int k) {
         
         PriorityQueue<Integer> minheap = new PriorityQueue<>();  // minheap
         
         for(int num:nums){
             
             minheap.offer(num);
             if(minheap.size() > k) minheap.poll();
             
             
         }
         return minheap.poll();
     }
    
    
    public int findKthLargest1(int[] nums, int k) {
        /**
         Kth largest means  n-k+1 smallest .
         
         n= 6
         
         arr [1,2,3,4,5,6]    k = 3 largest.  // 4
         
         6-3+1 = 4 th smalest 
         
         intution is to to select pivot and find the index of pivot element as per partition of
         quick sort , if the index < k recuer same  for right side of array.
         else  for left side . and if index+1 == k return arr[index];
         
        */
        int n = nums.length;
        int k1 = (n-k);
        int left = 0 ;
        int right = n-1;
        
       return  findKthSmallest(nums,left,right,k1);
        
    }
    
    private int findKthSmallest(int nums[],int left, int right,int k){
     if (left > right) return Integer.MAX_VALUE;
        
        int index = partition(nums,left,right);
        
        if(index+1 == k)  return nums[index];
        
        if(index+1 < k) {
            return findKthSmallest(nums,index+1,right,k);
        }else{
           return findKthSmallest(nums,left,index-1,k);
        }
    }
    
    private int partition(int nums[],int left, int right){
        
        int pivot = nums[left+(right-left)/2];
        
        while(left <= right){
              
            while(nums[left] < pivot)left++;
               
         
            while(nums[right] > pivot) right--;
           
            if(left<=right){
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                  left++;
                  right--;
              }
          }
                 
        return left;
    }
}