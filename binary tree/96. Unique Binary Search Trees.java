/*
题目：
96. Unique Binary Search Trees

Given n, how many structurally unique BST's (binary search trees) that store values 1...n?

For example,
Given n = 3, there are a total of 5 unique BST's.

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3

分析：
    时间复杂度：O(n)
    空间复杂度：O(n)
    动态规划。
    对于1-n组成的二叉搜索树，用F(i,n)表示以i为根节点形成的二叉搜索树，G(n)表示树的个数，
    则G(n) = F(1,n) + F(2,n) + ... + F(n,n)
    对于F(i,n)，以i为根节点，则根节点左侧的数为 1 ~ i-1，形成的子树个数为G(i-1)，根节点右侧的数为i+1 ~ n，形成的子树个数为G(n-i)
    则F(i,n) = G(i-1) * G(n-i)
    综上，G(n) = G(0) * G(n-1) + G(1) * G(n-1) + G(n-1) * G(0)
*/
class Solution {
    public int numTrees(int n) {
        int[] res = new int[n+1];
        res[0] = 1;
        res[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++){
                res[i] += res[j - 1] * res[i - j];
            }
        }
        return res[n];
    }
}
