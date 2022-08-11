class Solution {
    
    /**
     {1,3,4,5}   n=7 rod length;
     
     we can start cutting rod from any point either 1 or 3 or 4 or 5
     
     1| 2|3| 4| 5| 6| 7| 
     cost =7
     rod 1      rod 2
     |1|    |2|3| 4| 5| 6| 7| 
     
     
     cost 6
     rod1      rod 2        rod 3
     |1|       |2 |3|    | 4| 5| 6| 7| 
     
     cost 4
     rod1      rod 2      rod 3     rod 4
     |1|       |2 |3|    | 4|      |5| 6| 7|
     cost 3
     rod1      rod 2     rod 3      rod5      rod 4
     |1|       |2 |3|    | 4|       | 5|     | 6| 7|
     
     problem is divided into sub problem which can be solved independently .
     TC =7+6+4+3 20
     
     if we have {1,3,4,5,2} 
      problem is divided into sub problem which can not be solved independently .
      
      so it is mandatory to sort this array.
      
      how to find length ?
      0 {1,3,4,5} 7    insert 0 and lenght of rod at start and end .
         i     j  
      
      cuts[j+1]-cuts[i-1]
     
     TC :   for changing i and j  c^2 * c   c^3
     space : O(C2) +stack space
     
    */
    
    
    
    int dp[][];
    int len , c ;
    public int minCost(int n, int[] cuts) {
        c = cuts.length;
        dp = new int [c+1][c+1];
        
        for(int[] arr:dp) Arrays.fill(arr,-1);
        
        int newCuts [] = new int[c+2];
        newCuts[0] = 0;
       
        for(int i=0;i<cuts.length;i++)
            newCuts[i+1] = cuts[i];
        
        newCuts[newCuts.length-1] = n;
        
        Arrays.sort(newCuts);
        
       return  minTc(1,c,newCuts,dp);
    }
    
    private int minTc(int i,int j, int[] newCuts,int dp[][]){
        
        if(i > j) return 0;
        
        if(dp[i][j] != -1) return dp[i][j];
        
        int mini =Integer.MAX_VALUE;
        
        for(int index = i ; index <=j; index++){
            
            int cost = newCuts[j+1]-newCuts[i-1] + minTc(i,index-1,newCuts,dp) + minTc(index+1,j,newCuts,dp);
            
            mini = Math.min(mini,cost);
        }
        return dp[i][j]= mini;
    }
}