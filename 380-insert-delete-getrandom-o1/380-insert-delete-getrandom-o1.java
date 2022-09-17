class RandomizedSet {

    /** Initialize your data structure here. */
    List<Integer> list ;
    Map<Integer,Integer> map ;
    Random ran;
    
    public RandomizedSet() {
        list = new ArrayList<>();
        map = new HashMap<>();
        ran = new Random();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
           if(map.containsKey(val))
               return false;
                 
              map.put(val,list.size());  // put size first in intilially size 0 ,put at index 0
              list.add(val);
                 
            return true;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
    
        if( !map.containsKey(val)) return false;
      
        
           int valIndexInList = map.get(val);
           int lastIndex = list.size()-1;
           
           if(valIndexInList < lastIndex){
               int lastOnde = list.get(lastIndex);
               list.set(valIndexInList ,lastOnde);  // replace last index value with curr index of val to          be removed 
               map.put(lastOnde,valIndexInList);
           }
           map.remove(val);
           list.remove(lastIndex);
          
           return true;  
       
        
    }
        
    
    /** Get a random element from the set. */
    public int getRandom() {
      
        int index = ran.nextInt(list.size()); // get random ele from (0 tolistsize-1)  listsize exclusive
        
        return list.get(index);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */