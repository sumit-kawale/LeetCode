/*
289. Game of Life
Here we have given a 2d matrix. We have to make in place changes in the matrix according to the given 4 rules.

For this solution we have created a seervice method to calculate all the neighbouring cell which contains living cell "1". Return the count back to the main method to contain it with the given rule.

In main method parse the whole matrix with nested for loop making it O(n) time complexity. write the if condition for different rules. and make the changes in the temp 2d matrix.

In the end move all the cells from temp 2d matrix to the given 2d board matrix.

*/

class Solution {
    public void gameOfLife(int[][] board) {
        int[][] output = new int[board.length][board[0].length];
        
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[i].length; j++){
                int neighbour = count(i, j, board);
                
                if(board[i][j]==1 && neighbour<2)
                    output[i][j]=0;
                
                else if(board[i][j]==1 && (neighbour==2 || neighbour==3))
                    output[i][j]=1;
                
                else if(board[i][j]==1 && neighbour>3)
                    output[i][j]=0;
                
                else if(board[i][j]==0 && neighbour==3)
                    output[i][j]=1;
            }
        }
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[i].length; j++){
                board[i][j]=output[i][j];
            }
        }
    }
    public int count(int i, int j, int[][] board){
        int count = 0;
        
        int[][] direction={{0,-1},{0,1},{1,0},{1,-1},{1,1},{-1,-1},{-1,1},{-1,0}};
        for(int[] dir:direction){
            int x=i+dir[0];
            int y=j+dir[1];
            if(x>=0 && y>=0 && x<board.length && y<board[0].length){
                count +=board[x][y];
            }
        }
        return count;
    }
}