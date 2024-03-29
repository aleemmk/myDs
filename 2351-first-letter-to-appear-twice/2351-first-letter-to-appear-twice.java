class Solution {
    
    /**
    a b c c b a a c z
    0 1 2 3 4 5 6 7 8
    
    a  0 5 6
    b  1 4
    c  2 3 7
    z  8
    
    need to return chracter whose frequency first is 2 first time.
    in other word return the character as soon as u find frequency is 2 .
    
    
    */
         public char repeatedCharacter(String s) {
             int count[] =  new int[26];
             
             for(char c:s.toCharArray()){
                 
                 count[c-'a']++;
                 if(count[c-'a'] >1) return c;
             }
             return 'a';
         }
   
    
    public char repeatedCharacter1(String s) {
        Map<Character,List<Integer>> map = new HashMap<>();
        
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(map.containsKey(c)){
                List<Integer> list = map.get(c);
                list.add(i);
                map.put(c,list);
            }else{
                List<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(c,list);
            }
        }
        Integer mini =Integer.MAX_VALUE;
        for(Character key:map.keySet()){
            List<Integer> list = map.get(key);
            
            if(list.size() > 1){
                mini = Math.min(mini,list.get(1));
            }
            
        }
        
        return s.charAt(mini);
    }
}