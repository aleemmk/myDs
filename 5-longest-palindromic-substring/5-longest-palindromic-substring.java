class Solution {
    /**
      technique 1 :
      s1 input array then reverse it called s2.
      then find LCS longest common substring.
      
      Approach 2 :
      647. Palindromic Substrings

    */
    
      public String longestPalindrome(String s) {
           int n = s.length();
        //if(n==0) return 0;
       
        boolean dp[][] = new boolean [n+1][n+1];
        
       // int res = 0;
          int start=0;
          int end=0;
        
        // for diagonal when substring length is 1
        
        for(int i=0;i<n;i++){
            dp[i][i] = true;
           start =i;
            end =i;
        }
    
        // for length 2 
        
        for(int i=0;i<n-1;i++){
            if(s.charAt(i) == s.charAt(i+1)){
                dp[i][i+1] = true;
              start =i;
              end =i+1;
            }
        }
        
    // for 3 onward we need to check   s.charAt(i) == s.charAt(j)  and dp[i+1][j-1] == TRUE
        
        for(int len=2;len<n;len++){
            for(int i=0;i+len<n;i++){  // control the start index
                int j = i+len;   // control end index
                if(s.charAt(i) == s.charAt(j) && dp[i+1][j-1]){
                    dp[i][j] = true;
                    start=i;
                    end =j;
                }
            }
        }
        
          return s.substring(start,end+1);
    }
    
    
    public String longestPalindromeLCS(String s) {
        char input [] = s.toCharArray();

        char rev[] = input;
        int m = rev.length;
        int start=0;
        int end= m-1;

        while(start <end){

            char temp = rev[start];
            rev[start] = rev[end];
            rev[end] = temp;
        }

        int dp[][] = new int[m+1][m+1];

        for(int i=0;i<m;i++){
            for(int j=0;j<m;j++){

                if(i==0 || j==0){
                    dp[i][j] = 0;
                }
                if(input[i-1] == rev[j-1] )
                    dp[i][j] = 1 + dp[i-1][j-1];
                else{
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }

        int len = dp[m][m];

        Character res [] = new Character[len];
        Arrays.fill(res,'#');

        int index = len-1;

        int i=m;
        int j=m;

        while(i >0 && j>0){
            if(input[i-1] == rev[j-1]){
                res [index] = input[i-1];
                i--;
                j--;
                index--;
            }else if(dp[i-1][j] > dp[i][j-1]){
                i--;
            }else{
                j--;
            }
        }

        return Arrays.toString(res);
}
}