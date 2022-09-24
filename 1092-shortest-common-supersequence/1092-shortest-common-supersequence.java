class Solution {
    public String shortestCommonSupersequence(String str1, String str2) {
          char [] s1 = str1.toCharArray();
          char [] s2 = str2.toCharArray();
        
        int m =s1.length; 
        int n = s2.length;
        
            char  lcs [] = findLCS(s1,s2);
        if(lcs.length == 0) return str1+str2;
        int p1=0;
        int p2=0;
        char [] ans =  new char[m+n-lcs.length];
        int index=0;
        for(char c:lcs){
            
            while(s1[p1] != c){
                ans[index++] = s1[p1];
                p1++;
            }

            while(s2[p2] != c){

                ans[index++] =s2[p2];
                p2++;
            }

            ans[index++] = c;
            p1++;
            p2++;
        }
        
        while(p1 <m){
            ans[index++] = s1[p1++];
        }
        
        while(p2 < n){
              ans[index++] = s2[p2++];
        }
        
        return new String(ans);
    }
    
    private char [] findLCS( char[] s1,char[] s2){
       
         int m = s1.length;
         int n = s2.length;
         int dp[][] = new int[m+1][n+1];

        for(int i=0;i<=m;i++){
            for(int j=0;j<=n;j++){

                if(i==0 || j==0){
                    dp[i][j] = 0;
                }
                else if(s1[i-1] == s2[j-1] )
                    dp[i][j] = 1 + dp[i-1][j-1];
                else{
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }

        int len = dp[m][n];

        char res [] = new char[len];
        Arrays.fill(res,'#');

        int index = len-1;
        
     
        int i=m;
        int j=n;

        while(i >0 && j>0){
            if(s1[i-1] == s2[j-1]){
                res [index] = s1[i-1];
                i--;
                j--;
                index--;
            }else if(dp[i-1][j] > dp[i][j-1]){
                i--;
            }else{
                j--;
            }
        }

        return res;
    }
}