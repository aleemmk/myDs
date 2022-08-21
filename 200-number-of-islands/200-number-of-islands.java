class Solution {
                    
    
    /**           (x,y-1)
                     ^ 
          (x-1,y) <- | - > (x+1,y)
                     v
                  (x,y+1)
        
        we do DFS in all direction and mark visited (2) as above
        
        boundry condition  coordinate shoud not be x < 0 ,y<0 ,x >=rows ,y >=cols
                
    */
    public int numIslands(char[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        
        int count=0;
        
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(grid[i][j] == '1')
                    count++;
                markCurrIslandVisited(i,j,rows,cols,grid);
            }
        }
        return count;
    }
    
    private void markCurrIslandVisited(int x,int y, int rows, int cols ,char [][] grid){
        
        if(x < 0 || y<0 || x>=rows || y>=cols || grid[x][y] !='1')
            return;
        
            grid[x][y] = '2';
        
        markCurrIslandVisited(x-1,y,rows,cols,grid);
        markCurrIslandVisited(x,y-1,rows,cols,grid);
        markCurrIslandVisited(x+1,y,rows,cols,grid);
        markCurrIslandVisited(x,y+1,rows,cols,grid);
    }
}