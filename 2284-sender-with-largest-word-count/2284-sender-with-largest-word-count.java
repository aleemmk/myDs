class Solution {
    /**
     String message [] = {};
     String sender [] = {}
     
     idea behind the solution is to contract message count map .
     
     key is sender ;
     value is total word count.
     
     use max heap for store entries.
     if count is same then go for lexicographically order of name.
     
     TC
     ====
     O(n) + O(n)+ O(log n) [getting top from maxheap]
     
     O(n);
     
     approach2:
     
     we just need to find maxcount and it's corresponding key ,
     we can two vaiable in O(1) if 
     
     if max count is same for two then compare two string and pick lexicographically largest.
     
    */
    public String largestWordCount(String[] messages, String[] senders) {
        
        Map<String ,Integer> map = new HashMap<>();
        
        for(int i=0;i<senders.length;i++){
            int wordCount = messages[i].split(" ").length;
            map.put(senders[i],map.getOrDefault(senders[i],0)+wordCount);
        }
        
        String res="";
        int maxCount = Integer.MIN_VALUE;
        
        for(Map.Entry<String,Integer> entry:map.entrySet()){
             
            if(maxCount < entry.getValue() ){
                maxCount = entry.getValue();
                res = entry.getKey();
                
                
            }else if(maxCount == entry.getValue())
                 res = res.compareTo(entry.getKey()) < 0 ?entry.getKey():res;
               
        
        }
        
        return res;
    }
}