/*
题目：
28. Implement strStr()

Implement strStr().

Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

Example 1:

Input: haystack = "hello", needle = "ll"
Output: 2
Example 2:

Input: haystack = "aaaaa", needle = "bba"
Output: -1

分析：
    时间复杂度：O(n^2)  和   O(m+n)
    方法1：遍历字符串比较。
    方法2：hashfunction；
          对于字符串abcde，将其使用hashcode表示，即a * 31^4 + b * 31^3 + c * 31^2 + d * 31^1 + e * 31^0;
          对于字符串bcd,则为b * 31^2 + c * 31^1 + d * 31^0；
          则遍历字符串abcde，并对每m(目标串的长度)个连续的子串使用hashcode表示，判断当前子串的hashcode和目标串的hashcode是否相同。
          从ab -> abc, ab+c,即为 hashcode * 31 + c;
          从abc -> bcd, 分为两步，首先abc + d(同上), 然后abcd - d;即 hashcode - a * 31^3;
          注意：
          1.对运算进行取余操作，因为m可能很大；
          2.当当前子串的hashcode和目标串的hashcode相同时，由于进行过取余操作，所以其可能不同，则需要进行二次确认，使用substring判断。
*/
class Solution {
    public int strStr(String haystack, String needle) {
        if ( haystack == null || needle == null ) {
            return -1;
        }

        if ( needle.length() == 0 ) {
            return 0;
        }
        int l1 = haystack.length();
        int l2 = needle.length();
        for ( int i = 0; i < l1 - l2 + 1; i++ ) {
            int j = 0;
            for ( j = 0; j < l2; j++ ){
                if ( haystack.charAt(i+j) != needle.charAt(j) ){
                    break;
                }
            }
            if ( j == l2 ) {
                return i;
            }
        }
        return -1;
    }
}

class Solution {
    public int base = 1000000;
    public int strStr(String haystack, String needle) {
        if ( haystack == null || needle == null ) {
            return -1;
        }

        if ( needle.length() == 0 ) {
            return 0;
        }
        int n = haystack.length();
        int m = needle.length();

        // 31 ^ m
        int power = 1;
        for (int i = 0; i < m; i++) {
            power = (power * 31) % base;
        }
        // needle 的 hashcode
        int targetHashCode = 0;
        for (int i = 0; i < m; i++) {
            targetHashCode = (targetHashCode * 31 + needle.charAt(i)) % base;
        }

        // haystack 的 hashcode
        int hashCode = 0;
        for (int i = 0; i < n; i++) {
            // abc + d
            hashCode = (hashCode * 31 + haystack.charAt(i)) % base;
            if (i < m - 1) {
                continue;
            }
            // abcd - a
            if(i >= m) {
                hashCode = hashCode - (haystack.charAt(i - m) * power) % base;
                if (hashCode < 0) {
                    hashCode += base;
                }
            }
            // double check
            if (hashCode == targetHashCode) {
                if (haystack.substring(i - m + 1, i + 1).equals(needle)) {
                    return i - m + 1;
                }
            }
        }

        return -1;
    }
}
