class MyHashMap {
    

    private class HMNode{
        Integer key;
        Integer val;
        HMNode(Integer key, Integer val){
            this.key = key;
            this.val = val;
        }
    }
    
    private int size;  // n
    
    
    private LinkedList<HMNode> [] buckets;  // N
    
    public MyHashMap() {
        initBucket(4);
        size=0;
    }
    
    private void initBucket(int N){
        
        buckets = new LinkedList[N];
        
        for(int i=0; i < buckets.length;i++){
            buckets[i] = new LinkedList<>();
        }
    }
    
    private int hashfn(Integer key){
        int hash = key.hashCode();
        
        return Math.abs(hash) % buckets.length;
    }
    
  private int getIndexWithInbucket(int key ,int bi){
      
      int di = 0 ;
      
      for(HMNode node:buckets[bi]){
          if(node.key.equals(key)){
              return di;
          }
          di++;
      }
      return -1;
  }
    
    public void put(Integer key, Integer val) {
        
        int bi = hashfn(key);
        
        int indexWithinbucket = getIndexWithInbucket(key,bi);
        
        if(indexWithinbucket == -1){
            HMNode node = new  HMNode(key,val);
            buckets[bi].add(node);
            size++;
        }else{
            HMNode node = buckets[bi].get(indexWithinbucket);
            node.val = val;
        }
        
        double lamda = (size * 1.0) / buckets.length;
        
        if(lamda > 2){
            rehash();
        }
        
    }
    
    private void rehash(){
        LinkedList<HMNode> [] oba = buckets;
        
        initBucket(oba.length *2);
       
        size = 0;
        
        for(int i=0;i< oba.length; i++){
            for(HMNode node:oba[i]){
                put(node.key,node.val);
            }
        }
    }
    
    public Integer get(Integer key) {
        int bi = hashfn(key);
        int indexWithinbucket = getIndexWithInbucket(key,bi);
        
        if(indexWithinbucket != -1){
           HMNode  node = buckets[bi].get(indexWithinbucket);
           return  node.val;
        }
        return -1;
    }
    
    public void remove(Integer key) {
        int bi = hashfn(key);
      int indexWithinbucket = getIndexWithInbucket(key,bi);
        if(indexWithinbucket !=-1){
            buckets[bi].remove(indexWithinbucket);
        }
        
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */