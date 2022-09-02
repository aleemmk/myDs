class Solution {
    
    
    /**
     
     [3,]
    */
     public int totalFruit(int[] fruits) {
         
         int maxsize = Integer.MIN_VALUE;
         Map<Integer,Integer> map = new HashMap<>();
         
         int j=0;
         int n = fruits.length;
          
         for(int i=0;i<n;i++){
             
             map.put(fruits[i],map.getOrDefault(fruits[i],0) +1);
             
             while(map.size() > 2){
                  map.put(fruits[j],map.get(fruits[j])-1);
                 if(map.get(fruits[j]) == 0)
                     map.remove(fruits[j]);
                 
                 j++;
            }
             
             maxsize = Math.max(maxsize,i-j+1);
            
         }
         
         return maxsize;
         
     }
    public int totalFruit_depricated(int[] fruits) {
        
    
        
       // basket 1     A   picked, picked
            
         //   basket 2    B picked  picked
        
        // c Type in between came    stop
        
        // Input: fruits = [1,2,3,2,2] 
        
        int lastFruit = -1;
        int secondLastFruit = -1;
        
       int max = Integer.MIN_VALUE;
        
        int basketFruitCount=0;
        
        int lastFruitCount=0;
        
        
        for(Integer currFruit:fruits){
            
            if(currFruit == lastFruit || currFruit == secondLastFruit )
                basketFruitCount++;
            else
                basketFruitCount = lastFruitCount+1;
            
            if(currFruit == lastFruit){
                lastFruitCount = lastFruitCount+1;
            }else{
                lastFruitCount=1;
            }
            
            
            if(currFruit != lastFruit){
                secondLastFruit = lastFruit;
                lastFruit =currFruit;
            }
                
           
            max = Math.max(basketFruitCount,max);
            
        }
        
        return max;
    }
}