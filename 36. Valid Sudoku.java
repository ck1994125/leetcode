/*
题目：
36. Valid Sudoku

Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules.

The Sudoku board could be partially filled, where empty cells are filled with the character '.'.


A partially filled sudoku which is valid.

Note:
A valid Sudoku board (partially filled) is not necessarily solvable. Only the filled cells need to be validated.

分析：
    时间复杂度：O(n2)
    使用HashMap。
    遍历数组，为每行，每列，和每个九宫格建立HashSet存储；
    难点在于九宫格如何映射。

    观察行号规律：
    第0个九宫格：000111222; 第1个九宫格：000111222; 第2个九宫格：000111222;
    第3个九宫格：333444555; 第4个九宫格：333444555; 第5个九宫格：333444555;
    第6个九宫格：666777888; 第7个九宫格：666777888; 第8个九宫格：666777888;

    可见对于每三个九宫格行号增3；对于单个九宫格，每三个格点行号增1。
    因此第i个九宫格的第j个格点的行号可表示为i/3*3+j/3

    观察列号规律：
    第0个九宫格：012012012; 第1个九宫格：345345345; 第2个九宫格：678678678;
    第3个九宫格：012012012; 第4个九宫格：345345345; 第5个九宫格：678678678;
    第6个九宫格：012012012; 第7个九宫格：345345345; 第8个九宫格：678678678;

    可见对于下个九宫格列号增3，循环周期为3；对于单个九宫格，每个格点行号增1，周期也为3。
    周期的数学表示就是取模运算mod。
    因此第i个九宫格的第j个格点的列号可表示为i%3*3+j%3
*/
class Solution {
    public boolean isValidSudoku(char[][] board) {
        int length = board.length;

        for( int i = 0; i<length; i++ ){
            HashSet<Character> row = new HashSet<Character>();
            HashSet<Character> column = new HashSet<Character>();
            HashSet<Character> cube = new HashSet<Character>();
            for( int j = 0 ; j<length; j++ ){
                if( board[i][j] != '.' && !row.add(board[i][j]) ){
                    return false;
                }
                if( board[j][i] != '.' && !column.add(board[j][i]) ){
                    return false;
                }
                int rowIndex = 3*(i/3);
                int columnIndex = 3*(i%3);
                if( board[rowIndex+j/3][columnIndex+j%3] != '.' && !cube.add(board[rowIndex+j/3][columnIndex+j%3]) ){
                    return false;
                }
            }

        }

        return true;
    }
}
