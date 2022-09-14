class Solution {
    public int search(int[] arr, int key) {
        int low =0; 
        int high = arr.length-1;
        
        while(low <=high){
            
           int mid = low+(high-low)/2;
            
            if(arr[mid] == key)
                return mid;
            
            if(arr[low] == key)
                return low;
            
            if(arr[high] == key)
                return high;
                
            if(arr[low] < arr[mid]){
                //left part softed
                if(key < arr[mid] && key >= arr[low]){
                    high = mid-1;
                }else{
                    low = mid+1;
                }
                
            }else{
                
                //right part sorted
                  if(key > arr[mid] && key <=arr[high]){
                      low = mid+1;
                  }else{
                      high = mid-1;
                  }
                
                
            }
        }
        return -1;
    }
}