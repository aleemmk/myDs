class Solution {
    public int totalNQueens(int n) {
        char board [] [] = new char[n][n];
        
        
        for(char[] brd:board) Arrays.fill(brd,'.');
        
        List<List<String>> res= new ArrayList<>();
       
        solve(board,0,res,n);
        
        return res.size();
    }
    
    private List<String> construct(char [][]board){
        
        List<String> list = new ArrayList<>();
        
        for(char[] brd:board){
            
            String s = new String(brd);  // each  row of result converted to string and add to list
            list.add(s);
        }
        return list;
    }
    
    private void solve(char [][] board,int col,List<List<String>> res,int n){
       
        if(col == n){
           res.add(construct(board));
        }
        for(int i=0;i<n;i++){
            if(validate(board,i,col)){  
              
                 board[i][col] = 'Q';   // putting queen on first column of every cell;
                 solve(board,col+1,res,n);
                 board[i][col] ='.';   // backtrack
            
            }
            
        }
    }
    
    
    private boolean validate(char[][] board, int row, int col){
        int i; int j;
        
        
        // check this row on left side
        for( i=0;i<col;i++){
            if(board[row][i] == 'Q')
                return false;
        }
        
        // check upper diagonal on left side
        for(i=row,j=col; i>=0 && j>=0;i--,j--){
            if(board[i][j] == 'Q')
                return false;
        }
            
        // check lower diagonal on left side
        
        for(i=row,j=col;i<board.length && j>=0;i++,j--){
            if(board[i][j] == 'Q')
                return false;
        }
        
        return true;
    }
}