class Solution {
    public int trap(int[] height) {
       
        int n= height.length;
        
        int [] tallestleft = new int[n];
        int [] tallestRight = new int[n];
        
        int lattestFromleft =-1;
        tallestleft[0] = lattestFromleft;
        for(int i=1;i<n;i++){
            lattestFromleft = Math.max(lattestFromleft,height[i-1]);
            tallestleft[i] = lattestFromleft;
        }
        
        int tallestFromRight =-1;
        tallestRight[n-1] =  tallestFromRight;
        for(int i=n-2;i>=0;i--){
            tallestFromRight = Math.max(tallestFromRight,height[i+1]);
            tallestRight[i]= tallestFromRight;
        
        }
        int val=0;
        
        for(int i=0;i<n;i++){
    
            int currGridVal = Math.min(tallestleft[i],tallestRight[i])-height[i];
            if(currGridVal > 0)
                val += currGridVal;
        }
    
        return val;
    }
}