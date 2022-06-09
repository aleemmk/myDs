class Solution {
    public int[] singleNumber(int[] nums) {
        
        int res [] = new int [2];
        
        /**
        two odd occuring number 
         arr [] ={ 3,4,3,4,8,4,4,32,7,8}
         
         XOR all element   32 ^ 8 = XOR of all element
         job is to find two element from given XOR (a ^ b = XOR) find a and b
         
         right most set bit can be find with
        bit =  XOR & ~(XOR-1)
        
        8 =  0...0 0 1 0 0 0
        32 = 0...1 0 0 0 0 0
        =====================
     XOR         1 0 1 0 0 0
                  =============
    XOR-1 =       1 0  0 1 1 1
    ~(XOR-1) =    0 1  1 0 0 0
    ===========================
XOR & ~(XOR-1)      0  0  1  0 0 0

        */ 
    
      int XOR = nums[0];
        for(int i=1 ;i<nums.length;i++){
            XOR = XOR ^ nums[i];
        }
    
        int bit = XOR & (~(XOR-1));
        
        int num1 = 0;
            int num2 =0;
        
        for(int num:nums){
            
            if((bit & num) != 0){
                num1 = num1 ^ num;
            }else{
                num2 = num2 ^ num;
            }
            
        }
        
        res [0] = num1;
            res [1] =num2;
        
        return res;
    }
}