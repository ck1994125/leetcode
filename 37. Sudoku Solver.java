/*
题目：
37. Sudoku Solver

Write a program to solve a Sudoku puzzle by filling the empty cells.

Empty cells are indicated by the character '.'.

You may assume that there will be only one unique solution.

分析：
    时间复杂度：指数级
    递归。和n皇后问题类似。
    对于每个格子，带入不同的9个数，然后判合法，如果成立就继续递归，结束后把数字设回空。
    验证函数中，由于在检查当前位置数字所在九宫格是否满足要求之前，已经按行和列进行检查，所以不需要检查整个九宫格。
*/
class Solution {
    public void solveSudoku(char[][] board) {
        if(board == null || board.length != 9 || board[0].length !=9)  return;
        dfs(board,0,0);
    }

    private boolean dfs(char[][] board, int row, int col){

        if( col >= 9 ){
            return dfs(board,row+1,0);
        }
        if( row == 9 ){
            return true;
        }
        if( board[row][col] == '.' ){
            for( int i = 1; i < 10; i++ ){
                board[row][col] = (char)(i+'0');
                if( check(board,row,col) ){
                    if(dfs(board,row,col+1)){
                        return true;
                    }
                }
                board[row][col] = '.';
            }
        }
        else{
            return dfs(board,row,col+1);
        }
        return false;
    }

    private boolean check( char[][] board, int row, int col ){
        for ( int i = 0; i < 9; i++ ){
            if( i != col && board[row][i] == board[row][col] ){
                return false;
            }
            if( i != row && board[i][col] == board[row][col] ){
                return false;
            }
        }
        int indexRow = 3*(row/3);
        int indexCol = 3*(col/3);
        for( int i = 0; i < 3; i++ ){
            for( int j = 0; j < 3; j++ ){
                if( (row!=indexRow+i || col!=indexCol+j ) && board[indexRow+i][indexCol+j] == board[row][col] ){
                    return false;
                }
            }
        }
        return true;
    }
}
