/*
题目：
73. Set Matrix Zeroes'

Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in place.

分析：
    时间复杂度：O(n)
    空间复杂度：O(n)
    使用row 和 col 两个bool数组来记录存在数值为0的元素所在行和列。
    对于空间复杂度为O(1)的做法，首先遍历首行和首列是否存在为0元素，存在则在程序最后将首行和首列赋值为0，否则不进行任何操作；
    然后，使用首行和首列来记录。若存在为0元素，竟matrix[i][0]和matrix[0][j]置为0，然后遍历首行和首列进行操作。
*/
class Solution {
    public void setZeroes(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return;
        }
        if (matrix[0] == null || matrix[0].length == 0) {
            return;
        }

        boolean[] row = new boolean[matrix.length];
        boolean[] col = new boolean[matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if ( matrix[i][j] == 0) {
                    row[i] = true;
                    col[j] = true;
                }
            }
        }

        for (int i = 0; i < row.length; i++) {
            if (row[i] == true) {
                for (int j = 0; j < matrix[0].length; j++) {
                    matrix[i][j] = 0;
                }
            }
        }

        for (int i = 0; i < col.length; i++) {
            if (col[i] == true) {
                for (int j = 0; j < matrix.length; j++) {
                    matrix[j][i] = 0;
                }
            }
        }
        return;
    }
}
