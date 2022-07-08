class Solution {
    
    /**
      idea behind the solution is to make a frequency map 
      
      then put all entries in max heap , pq is by default min heap so in comparator of pq 
      we write if frequcny is same then sort on basis of key;
    */
    public List<String> topKFrequent(String[] words, int k) {
        
        Map<String , Integer> map = new HashMap<>();
        
        for(String word:words){
            map.put(word,map.getOrDefault(word,0)+1);
        }
        
        PriorityQueue<Map.Entry<String,Integer>> pq = new PriorityQueue<>( (a,b) -> {
           
           if(a.getValue()== b.getValue()) return  a.getKey().compareTo(b.getKey()) ;
            
           return  b.getValue()-a.getValue();
       } );
      
        for(Map.Entry<String,Integer> entry:map.entrySet()){
            pq.offer(entry);
            
        }
        
        List<String>res = new ArrayList<>();
        int i=0;
        while(i < k){
           Map.Entry<String,Integer> entry = pq.poll();
            
            res.add(entry.getKey());
            i++;
        }
        
        return res;
        
    }
}