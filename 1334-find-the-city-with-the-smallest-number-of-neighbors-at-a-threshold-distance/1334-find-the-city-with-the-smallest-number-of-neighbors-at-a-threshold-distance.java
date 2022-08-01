class Solution {
    
    /**
    from the decpription 
     0 = all the cicties which is <= threshold
     1 = all the cicties which is <= threshold
     2 = all the cicties which is <= threshold
     3 = all the cicties which is <= threshold
     4 = all the cicties which is <= threshold
     
      if 4 have some value return else chek for 3 ,2, 1
      this is all pair shortest path problem
      
      dp[i][j] = Math.min(dp[i][j],dp[i][k]+dp[k][j]);

    */
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        
        int dp[][] = new int[n][n];
        
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],Integer.MAX_VALUE/2);  // used to fill every row with max value.
            dp[i][i] = 0; // used to declare diagonal 0;  distance is zero from u to u or v to v.
        }
        
        for(int[] e:edges){
            
            dp[e[0]] [e[1]] =  e[2];
            dp[e[1]] [e[0]] = e[2];
        }
        
        
        for(int k=0;k<n;k++){
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                     dp[i][j] = Math.min(dp[i][j] ,dp[i][k] + dp[k][j]);
                }
            }
        }
        
    
      
        int min = Integer.MAX_VALUE;;
        int ans = -1;
        for(int i=0;i<n;i++){
             int count =0;
            for(int j=0;j<n;j++){
                
                if(i!= j && dp[i][j] <= distanceThreshold)
                    count++;
                
            }
            
            if(count <= min){
                min = count;
                ans=i;
            }
        }
        return ans;
    }
}