class WordDictionary {
    
    /** This is same as normal version of tries add function have complexity O(word length) 
    
    Wild card serach : 
    a.d
    for this . we have 26 possibilities so our search function behaves in iterative way in case of character 
    
    but in case of . we have Node links[26] array so for each non null item in this array ,pick one by one ,we      need to check 
    iteratively for every charcter of give word if rach end of word then it's fine .else we back track via recursion and try with next non null value of links array.

 TC
 ====
 in worst case 
 O(n +  26 ^ n)
  insert + search 
    */
    
    class Node{
        
        Node links[] = new Node[26];
        
        boolean isEnd;
        
        private boolean containsKey(char c){
            return links[c-'a'] != null;
        }
        
        private boolean isEnd(){
            return isEnd;
        }
        
        private void setEnd(){
            isEnd = true;
        }
        
        private void put(char c ,Node node){
            links[c-'a'] = node;
        }
        
        private Node get(char c){
            return links[c-'a'];
        }
        
        public Node(){
            
        }
    }
   
     private Node  root;
    public WordDictionary() {
        root = new Node();
    }
    
    public void addWord(String word) {
        Node node = root;
        
        for(int i=0;i< word.length();i++){
            char c = word.charAt(i);
            if(!node.containsKey(c))
               node.put(c,new Node());
            
            node = node.get(c);
        }
        node.setEnd();
    }
    
    public boolean search(String word) {
        Node node = root;
        return dfs(word,root,0); 
    }
   //  .ad   26 ^ 3
    /**
    ["WordDictionary","addWord","addWord","addWord","search","search","search","search"]
      [[],["bad"],["dad"],["mad"],["pad"],["bad"],["b.s"],["b.."]]
    */
    private boolean  dfs(String word, Node root,int j){
       Node node = root;
        for( int i= j ; i < word.length();i++){
            char c = word.charAt(i);
            if(c == '.'){
               
              Node currNodeLinks [] = node.links;
               for(int k=0;k < currNodeLinks.length;k++){
                   if(currNodeLinks[k] != null)
                     if(dfs(word,currNodeLinks[k],i+1)) return true;
               } 
                return false;
             }else{
                if(!node.containsKey(c)) return false;
               
            }
             node = node.get(c);
        }
       return  node.isEnd();
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */