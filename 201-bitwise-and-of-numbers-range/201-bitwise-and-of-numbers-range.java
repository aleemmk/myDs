class Solution {
    public int rangeBitwiseAnd(int left, int right) {
        
        //  problem is to find the common prefix of all the binary in a range of left to right
        int count = 0;
        
        while(left != right){
            
            left = left >> 1;
            right = right >> 1;
            
            count++;
            
        }
        
        return left << count;
        
    }
}