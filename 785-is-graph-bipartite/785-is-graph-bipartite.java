class Solution {
    
    /**
    
    A Bipartite graph can only have even length cycle.
     
     Here we chose solution of graph coloring we chose two color (red, green) if a node is red then all it's adjacent    nodes are green . if we find ambiguity in this then it means the graph have odd length cycle and hence not bipartite.
     
      state 
    */
    public boolean isBipartite(int[][] graph) {
        
        int n = graph.length;
        
        int color[] = new int[n+1];
        
        Arrays.fill(color,-1);
        
        for(int i=0 ;i < graph.length;i++){
            
            if(color[i] == -1 )
                if( !bfs(graph,color,i)) return false;
        }
        return true;
        
    }
    
    private boolean bfs(int[][] graph , int color[],int curr){
        
        Queue<Integer> q = new LinkedList<>();
        
        q.add(curr);
        color[curr] = 1 ; // color is 1 or 0
            
            while(!q.isEmpty()){
                int node = q.poll();
                
                for(int neighnour:graph[node]){
                    if(color[node] == color[neighnour])  return false;
                    
                    if(color[neighnour] == -1){
                        color[neighnour] = 1-color[node];
                        q.add(neighnour);
                    }
                }
            }
            return true;
    }
}