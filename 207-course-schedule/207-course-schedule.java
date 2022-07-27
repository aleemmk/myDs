class Solution {
    
    /**
      Input: numCourses = 2, prerequisites = [[0,1],[0,2] [1,3] [1,4] [3,4]]
      
      0----> 1
      0----> 2
      1----> 3
      1----->4
      3---- 4
     
      0----> {1 ,2}
      1---->{3,4}
      2---->{}
      3---- {4}
      4----{}
       
      
        preMap 
        key courses val pre
      |  1 ->0 |
      |  0-> 1 |
      ----------
      
    */
     Map<Integer,List<Integer>> map = new HashMap<>();
    Set<Integer> visited = new HashSet<>();
    
    public boolean canFinish(int numCourses, int[][] prerequisites) {
         
        for(int i=0 ; i< numCourses;i++)
            map.put(i,new ArrayList<>());
        
        
        for(int[] p:prerequisites){
            List<Integer> neighbours = map.get(p[0]);
            neighbours.add(p[1]);
            map.put(p[0], neighbours);
        }
        
        
        for(int i=0; i<numCourses; i++)
             if(!dfs(i,map,visited))  return false;
        
       return true;
    }
            
            private boolean dfs(int course, Map<Integer,List<Integer>> map, Set<Integer> visited) {
                if(visited.contains(course)) return false;
                
                if(map.get(course).size() == 0) return true;
                
                visited.add(course);
                
                for(int pre:map.get(course)){
                    if(!dfs(pre,map,visited)) return false ;
                }
                
                visited.remove(course);
                map.get(course).clear();
                
                return true;
                
            }
}