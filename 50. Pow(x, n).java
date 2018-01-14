/*
题目：
50. Pow(x, n)

Implement pow(x, n).


Example 1:

Input: 2.00000, 10
Output: 1024.00000
Example 2:

Input: 2.10000, 3
Output: 9.26100

[
  ["ate", "eat","tea"],
  ["nat","tan"],
  ["bat"]
]

分析：
    时间复杂度：O(logn)
    使用暴力解法的时间复杂度为O(n)，但是会TLE；
    对于求X的n次方，如果n为偶数，则可化简为x的n/22次方 * x的n/22次方；
                   n为奇数，课化简为x * x的n/22次方 * x的n/2次方。
    需要注意n为负数！
*/
class Solution { //递归解法
    private double fastPow(double x, long n) {
        if (n == 0) {
            return 1.0;
        }
        double half = fastPow(x, n / 2);
        if (n % 2 == 0) {
            return half * half;
        } else {
            return half * half * x;
        }
    }
    public double myPow(double x, int n) {
        long N = n;
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }

        return fastPow(x, N);
    }
};

class Solution { // 迭代解法
    public double myPow(double x, int n) {
        long N = n;
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }
        double ans = 1;
        double current_product = x;
        for (long i = N; i > 0; i /= 2) {
            if ((i % 2) == 1) {
                ans = ans * current_product;
            }
            current_product = current_product * current_product;
        }
        return ans;
    }
};
