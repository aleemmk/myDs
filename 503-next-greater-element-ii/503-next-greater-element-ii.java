class Solution {
    /**
    496. Next Greater Element I
    approach is same as 496 , here array is circular

    [1,3, 4, 2]  [1,3, 4, 2]
     3 4 -1  3
     
     [1,2, 1] [1,2,1]
      2 -1 2
      
      iterrate the arry (right to left) in 2*n-1 to 0 and use i%n to keep the circular access.
      
      pop all element from statck untill 
         we got an element less the the current arr[i] .
         
         curretn peek is the next grater element if stack is not empty else put -1 in result;
    */
    public int[] nextGreaterElements(int[] nums) {
        
        int n = nums.length;
        int [] nge = new int[n];
        
        Stack<Integer> stack = new Stack<>();
        
        for(int i=2*n-1; i>=0; i--){
            
            while(!stack.isEmpty() && stack.peek() <= nums[i%n]){
                stack.pop();
            }
            int nxtgtr = 0;
            
            if(!stack.isEmpty())
                nxtgtr = stack.peek();
            else
                nxtgtr = -1;
            
            nge[i%n] =  nxtgtr;
            
            stack.push(nums[i%n]);
        }
        
        return nge;
    }
}