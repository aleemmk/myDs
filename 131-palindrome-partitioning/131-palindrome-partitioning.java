class Solution {
    
    /**
    
    backtracking problem
    choose   - substring if palindrome
    explore - recursively check for remanin substring 
    unchoose - reverse of what do in choose;  
    
          aab
          /|\
         / | \
        a ab aab
       / \ x   x  not palindrome
      a   ab
          /\
         a  b
       
    */
  
    
    public List<List<String>> partition(String s) {
         List<String> step = new ArrayList<>();
         List<List<String>> res  = new ArrayList<>();
        
        
        helper(s,step,res);
        return res;
    }
    
    private void helper(String s ,List<String> step,List<List<String>> res){
        
        if(s==null || s.length() == 0){
            
            res.add(new ArrayList<>(step));
            return;
        }
        
        for(int i=1;i<=s.length();i++){
            
            String temp = s.substring(0,i);
            
            if(!isPalindrome(temp)) continue;
            
            step.add(temp);
            helper(s.substring(i,s.length()),step,res);
            step.remove(step.size()-1);
        }
        
    }
    
    private boolean isPalindrome(String s){
        int start =0;
        int end = s.length()-1;
        while(start <= end){
            if(s.charAt(start) != s.charAt(end)) return false;
            start++;
            end--;
                
        }
        return true;
    }
}