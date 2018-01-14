/*
题目：
14. Longest Common Prefix

Write a function to find the longest common prefix string amongst an array of strings.

Seen this question in a real interview before?  YesNo


分析：
    时间复杂度：O(n)
    使用HashMap。
    遍历数组，每次遍历先判断Map中是否存在（sum-num[i]）：
    1.存在，返回Map.get(sum-num[i])和当前索引i；
    2.不存在，将（num[i],i）存入Map中。
*/
class Solution {
    public String longestCommonPrefix(String[] strs) {
        if( strs == null || strs.length == 0) return "";
        String res = strs[0];
        for( int i = 1 ; i < strs.length ; i++ ){
            while( strs[i].indexOf(res) != 0 ){
                res = res.substring(0,res.length()-1);
            }
        }

        return res;
    }
}
