/*
题目：
43. Multiply Strings

Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2.

Note:

The length of both num1 and num2 is < 110.
Both num1 and num2 contains only digits 0-9.
Both num1 and num2 does not contain any leading zero.
You must not use any built-in BigInteger library or convert the inputs to integer directly.

分析：
    时间复杂度：O(n2)
    根据乘法计算方法，num1[i] * num2[j] 所得结果的索引为[i+j,i+j+1];
    则从后向前遍历，当前遍历所得的num[i+j]即为下一次遍历的进位,将乘积和进位相加，计算当前位和进位。
    由于数组tmp会存储进位，所以数组tmp的起始可能为0，在转换为字符串时需要去除前导零。
*/
class Solution {
    public String multiply(String num1, String num2) {
        StringBuilder res = new StringBuilder();
        int len1 = num1.length();
        int len2 = num2.length();
        int[] p = new int[len1+len2];
        for( int i = len1-1 ; i >= 0 ; i-- ){
            for( int j = len2-1 ; j >= 0 ; j-- ){
                int index1 = i+j;
                int index2 = i+j+1;
                int mul = (num1.charAt(i)-'0') * (num2.charAt(j)-'0');
                int sum = mul + p[index2];
                p[index1] += sum/10;
                p[index2] = sum%10;
            }
        }
        for( int tmp : p ){
            if( res.length() !=0 || tmp != 0 ){
                res.append(String.valueOf(tmp));
            }
        }
        return (res.length()==0)?"0":res.toString();
    }
}
