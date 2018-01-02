/*
题目：
51. N-Queens

The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.

Given an integer n, return all distinct solutions to the n-queens puzzle.

Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space respectively.

For example,
There exist two distinct solutions to the 4-queens puzzle:

[
 [".Q..",  // Solution 1
  "...Q",
  "Q...",
  "..Q."],

 ["..Q.",  // Solution 2
  "Q...",
  "...Q",
  ".Q.."]
]

分析：
    时间复杂度：np问题
    经典的n皇后问题。
    使用递归。在每一次递归中，使用一个循环把一个皇后填入一行之中，如果当前结果合法，则开始递归处理下一行。
    代码中使用一维数组columnForRow记录皇后的位置，并在得到一个可行解后才开始构造字符串链表。
    和另一种使用二维数组直接在递归的过程中构造结果不同，不需要在每次递归返回后将当前行皇后的位置清除。
    判断结果合法：1.当前行的皇后位置和之前行的皇后位置所在列不同
                2.前行的皇后位置和之前行的皇后位置不在斜线上。 （两者行和列位置对应相减的绝对值不等）
*/
class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<List<String>>();
        dfs(n,0,new int[n],res);
        return res;
    }

    private void dfs(int n, int row, int[] columnForRow,List<List<String>> res ){
        if( row == n ){
            List<String> solution = new ArrayList<String>();
            for( int i = 0; i < n; i++ ){
                StringBuilder s = new StringBuilder();
                for( int j = 0; j < n; j++ ){
                    if( columnForRow[i] == j ){
                        s.append(new String("Q"));
                    }
                    else{
                        s.append(new String("."));
                    }
                }
                solution.add(s.toString());
            }
            res.add(solution);
            return;
        }
        for( int i = 0; i < n; i++ ){
            columnForRow[row] = i;
            if( check(columnForRow,row) ){
                dfs(n,row+1,columnForRow,res);
            }
        }
    }

    private boolean check( int[] columnForRow, int row ){
        for( int i = 0; i < row; i++ ){
            if( columnForRow[i] == columnForRow[row] || Math.abs(columnForRow[row]-columnForRow[i]) == Math.abs(row-i) ){
                return false;
            }
        }
        return true;
    }
}
