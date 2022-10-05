class Solution {
    
    /**
    color a  a  a  b  a  c  a  d  d  d
          2  3  5  6  3  8  9  8  2  9
          
          we need to delete a a with minimum cost when same type of char is comes 
          
          2+3+5   = 10 gsum
          gmax = 5
          
          cost = gsum-gmax
          
    
    
    */
    public int minCost(String colors, int[] neededTime) {
        
        int gsum=0;    // group sum
        int gmax =0;   // groupMax
        
        int minTime=0;
        
        for(int i=0;i<colors.length();i++){
            
            if(i > 0 && colors.charAt(i) != colors.charAt(i-1)){
                minTime += gsum-gmax;
                gmax=0;
                gsum=0;
                
            }
                gsum += neededTime[i];
                gmax = Math.max(gmax,neededTime[i]);
        }
        
        minTime += gsum-gmax;    // boundry case at end of array last group remains;
        
        return minTime;
        
    }
}