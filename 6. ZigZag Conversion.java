/*
题目：
6. ZigZag Conversion


The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

P   A   H   N
A P L S I I G
Y   I   R
And then read line by line: "PAHNAPLSIIGYIR"
Write the code that will take a string and make this conversion given a number of rows:

string convert(string text, int nRows);
convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".

分析：
    时间复杂度：O(n)
    空间复杂度：O(n)
    理解题意的话没有难度。
    学习Stringbuffer的使用。

*/
class Solution {
    public String convert(String s, int numRows) {
        char[] c = s.toCharArray();
        int len = s.length();
        StringBuffer[] sb = new StringBuffer[numRows];
        for ( int i = 0 ; i < sb.length ; i++ ) sb[i] = new StringBuffer();

        int i = 0;

        while ( i < len ){
            for ( int index = 0 ; index < numRows && i < len ; index++ )
                sb[index].append(c[i++]);
            for ( int index = numRows-2 ; index >= 1 && i < len ; index-- )
                sb[index].append(c[i++]);
        }

        for ( int index = 1 ; index < sb.length ; index++ ){
            sb[0].append(sb[index]);
        }

        return sb[0].toString();

    }
}
