class Solution {
    
    
    /**
    j=0 
     [3,3,3,1,2,1,1,2,3,3, 4 ]
  i=  0 1 2 3 4 5 6 7 8 9 10
  
  putting into map keep track of window i-j+1 ,
  3-> 1+1+1
  1-> 1
  2->1
  as soon as map size is > 2 we decrese count of fruit at j index and move j
  keep doing this until size is greater than 2 
  we keep on moving j and decrease 3 key count as soon as it reach zero remove the key and size of map is 2
  
  
    */
     public int totalFruit(int[] fruits) {
         
         int maxsize = Integer.MIN_VALUE;
         Map<Integer,Integer> map = new HashMap<>();
         
         int j=0;
         int n = fruits.length;
          
         for(int i=0;i<n;i++){
             
             map.put(fruits[i],map.getOrDefault(fruits[i],0) +1);
             
             while(map.size() > 2){   // keep on doing untill size is 2
                  map.put(fruits[j],map.get(fruits[j])-1);   // reduce fruits[j] count and move j
                
                 if(map.get(fruits[j]) == 0)  // as soon as fruits againg key is zero remove key to make size 2
                     map.remove(fruits[j]);  
                 
                 j++;   // incrase j to shrink window
            }
             
             maxsize = Math.max(maxsize,i-j+1);   // keep track of max window size 
            
         }
         
         return maxsize;  // return maxwindow till now
         
     }
}