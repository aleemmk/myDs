class Solution {
    /**
     s="aab"
        a b a
        0 1 2
      a is max frequency and even position for above.
      
      STEPS
      1.  count frequency of char and store in count[];
      2.  highest freq  char should put on even position.
      3.  put rest of character
    */
    public String reorganizeString(String s) {
        
        int count [] = new int [26];
        
        for(int i=0;i<s.length();i++){
            count[s.charAt(i)-'a']++;
        }
        int max = 0 ;
        int letter = 0;
        for(int i=0;i<26;i++){
           
            
            if(max < count[i] ){
                max = count[i];
                letter = i;
            }
        }
        
        if(max > (s.length()+1)/2) return "";
        
        int idx=0;
        char res[]= new char[s.length()];
        
        while(count[letter] > 0){
            
            res[idx] =  (char) (letter +'a');
            idx +=2;
            count[letter]--;
        }
        
        
        
        for(int i=0;i<count.length;i++){
            
               while(count[i] > 0){
                    
                    if(idx >= s.length()) idx=1;
                   
                    res[idx] = (char) (i+'a');
                    idx +=2;
                    count[i]--;
                    
                }
        }
        
        return String.valueOf(res);
    }
}