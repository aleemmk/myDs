class Solution {
    /**
     Topological sort is only possible in DAG( directed acyclic graph ) 
     
    (1,3) (1,2) (2,4)(3,4) is a DAG
    
    (1,2) (2,4)(4,3)(3,1) not a DAG .
    
    topological sort is a linear ordering of vertices in DAG such that for every directed edge uv(u->v)
    vertex u always comes before v. in the ordering.
    
    topological sort will start with the node have indegree equal to 0.
    
    APPRoach :
    
    DFS + Stack = recursion + visted array +stack
    
    start DFS when we reach a vertex when no ougoing edge is left to traverse, backtack and push into stack .
    
    when every vertex is traversed ,just pop from stack and return the result.
    
    in case of cycle return a empty array. (detech cycle by graph coloring)
    
    TC 
    O(V+E)
     
    */
    
    private boolean isCycle(List<List<Integer>> adj  ,int numCourses){
         int visited [] = new int[numCourses];
        
        Arrays.fill(visited,0);    // make 0 means unvisited
        
        for(int i=0;i<numCourses;i++){
            if(visited[i] == 0)
               if(isCycleUtil(adj,visited,i)) return true;    // if cycle is detected  false
        }
        return false;
    }
    
     private boolean isCycleUtil(List<List<Integer>>adj,int [] visited,int curr){
     
        if(visited[curr] == 2) return true;         // already processed
        
           visited[curr] = 2;   // make this node processed
        
        for(int adjEle:adj.get(curr)){
            if(visited[adjEle] != 1){
                if(isCycleUtil(adj,visited,adjEle)) return true; 
            }
        }
        visited[curr] = 1;     // make node  processing 
        
        return false;
    }
    
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        
        List<List<Integer>> adj = new ArrayList<>();
        int res []  = new int[numCourses];
        
        
        for(int i=0 ;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }
        
         for(int i=0;i<prerequisites.length;i++){
            adj.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        /*for(int[] pre:prerequisites){
            List<Integer> list = adj.get(pre[1]);
            list.add(pre[0]);
        }*/
        
        // if cycle is detect return empty array.
        int [] emptyArr = {};
        if(isCycle(adj,numCourses)) return emptyArr;
        
        // find topological sort and store it in stack;
        
        Stack<Integer> myStack = new Stack();
        
        boolean visited []  = new boolean[numCourses];
        
        // Apply topological sort with DFS
        
        for(int i=0;i<numCourses;i++){
            if(!visited[i])
               dfs(i,adj,visited,myStack);
        }
        int index =0;
        for(int i=0;i<numCourses;i++){
            res[i] = myStack.pop();
        }
       return res;
    }
    
    private void dfs(int i, List<List<Integer>> adj,boolean visited [] , Stack<Integer> myStack){
        
        visited[i] = true;
        
        for(Integer  neighbour:adj.get(i)){
            if(!visited[neighbour])
                dfs(neighbour,adj,visited,myStack);
        }
        
        myStack.push(i);
    }
}