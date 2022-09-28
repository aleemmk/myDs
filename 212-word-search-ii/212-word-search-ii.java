class Solution {
    
    class Node{
     Node links [] = new Node[26];
     String word=null;
      
        void put(char c ,Node node){
            links[c-'a'] = node;
        }
        
        boolean containsKey(char ch){
            return links[ch - 'a'] != null;
        }
        
         Node get(char ch){
            return links[ch-'a'];
        }
        
        void setWord(String w){
            word = w;
        }
        
         String getWord(){
            return word;
        }
        
        
    }
    private Node root;
    
    private void insert(String word,Node root){
           Node node = root;
        
         for(int i=0;i<word.length();i++){
                 char c = word.charAt(i);
             if(!node.containsKey(c)){
                 node.put(c,new Node());
             }
             node = node.get(c);
        }
        node.setWord(word);
    }
    private Node buidTrie(String [] words){
        Node root = new Node();
        for(String word:words) insert(word,root);
        return root;
     }
    
    public List<String> findWords(char[][] board, String[] words) {
        int rows = board.length;
        int cols = board[0].length;
        
        int dirs [][] = {
            {-1,0},
            {1, 0},
            {0, 1},
            {0,-1}
        };
        
        Node trie = buidTrie(words);
        List<String> res = new ArrayList<>();
        
         for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                dfs(board,i,j,trie,res,dirs);
            }
        }
        return res;
    }
    
    private void dfs(char[][] board,int i,int j,Node trie,List<String>res,int dirs[][]){
      
     if(i < 0 || j < 0 || i > board.length-1 || j > board[0].length-1 ) return;
        
        char c = board[i][j];
        
        if(c== '#' || !trie.containsKey(c)) return;
        
        trie = trie.get(c);
        
        if(trie.getWord() != null) {
            res.add(trie.getWord() );
            trie.setWord(null);
            
        }
        
         board[i][j] ='#';   // visited this cell;
        
        for(int[] dir:dirs){
            int x = dir[0];
            int y = dir[1];
            
            dfs(board,i+x,j+y, trie,res,dirs);
            
        }
        board[i][j] =c ;   // backtrack;
        
    }
    
    
}