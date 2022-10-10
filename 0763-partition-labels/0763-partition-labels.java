class Solution {
    
    /**
    we are givng a string s
    
    Goal : partition s 
    
    jump a on a   max we go index 8
    jump b on b   max we go index 5
    jump c on c   max we go index 7
    
    i == 8  
    take parton length  8-(-1)   =9
    
    */
    public List<Integer> partitionLabels(String s) {
        
        HashMap<Character,Integer> map = new HashMap<>();
        
        for(int i=0;i<s.length();i++){
            char c  =s.charAt(i);    
             map.put(c,i);  // max reach of each chracter 
        }
      
        int max =0;
        int prev =-1;
        List<Integer> res = new ArrayList<>();
        
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            
            max = Math.max(max,map.get(c));
            if(i==max){
                // length of partion
                
                res.add(max-prev);
                prev = max;
            }
            
        }
        return res;
    }
}