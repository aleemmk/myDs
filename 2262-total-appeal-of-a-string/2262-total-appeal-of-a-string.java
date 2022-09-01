class Solution {
    /**
    
    828. Count Unique Characters of All Substrings of a Given String
    above is follow up of this proble .
    
    appeal of ABA is 2
    unique character of ABA is 1  only B is quique.
    
    
    the intution behind solution is that
    
    how many point a character contribute top appeal.?
    what happend if a chracter already seen before.
    
    so at  index i if a chracter appears first time then total appeal is 
    (i+1) all the substring ending at character i
    012
    ABC   no of substring ending with c is (2+1) ABC, BC, C
    
    a  1
    ab  2
    abc  3
    b  1
    bc 2
    c  1
    =====
    tota appeal 10 
    
    1 3 6
    
    if a string come again then that aprticular character contribute to those string that start with previously     seen to curr(i)  i+1;
                  c
          b     b c
    a   a b   a b c
    1     3      6
    
    */
    public long appealSum(String s) {
        
        int seen[] = new int[26];
        long curr=0;
        long res=0;
        
        for(int i=0;i<s.length();i++){
            int c = s.charAt(i)-'a';  // current char
            
            
            if(seen[c] == 0)
              curr += (i+1);
            else
                curr += (i+1) - seen[c];    // seen character contributed in apeal already 
            
            seen [c] = i+1;
            
            res += curr;
        }
        
        return res;
    }
}