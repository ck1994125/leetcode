/*
题目：
38. Count and Say


The count-and-say sequence is the sequence of integers with the first five terms as following:

1.     1
2.     11
3.     21
4.     1211
5.     111221
1 is read off as "one 1" or 11.
11 is read off as "two 1s" or 21.
21 is read off as "one 2, then one 1" or 1211.
Given an integer n, generate the nth term of the count-and-say sequence.

Note: Each term of the sequence of integers will be represented as a string.

Example 1:

Input: 1
Output: "1"
Example 2:

Input: 4
Output: "1211"

分析：
    时间复杂度：O(n2)
    注意遍历到最后一位！
*/
class Solution {
    public String countAndSay(int n) {
        String res = new String("1");
        if( n==1 ) return res;
        for( int i=2 ; i<=n ; i++ ){
            StringBuilder tmp = new StringBuilder();
            String say = "";
            int count = 1;
            for( int j = 0; j<res.length(); j++ ){
                if( j == 0 ){
                    say += res.charAt(j);
                }
                else{
                    if( res.charAt(j) != res.charAt(j-1) ){
                        tmp.append(String.valueOf(count));
                        tmp.append(say);
                        say = "" + res.charAt(j);
                        count = 1;
                    }
                    else{
                        count++;
                    }
                }
                //到达边界
                if( j+1 == res.length() ){
                    tmp.append(String.valueOf(count));
                    tmp.append(say);
                }

            }
            res = tmp.toString();
        }
        return res;
    }
}
