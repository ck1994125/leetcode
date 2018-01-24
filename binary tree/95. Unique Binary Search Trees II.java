/*
题目：
95. Unique Binary Search Trees II

Given an integer n, generate all structurally unique BST's (binary search trees) that store values 1...n.

For example,
Given n = 3, your program should return all 5 unique BST's shown below.

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3

分析：
    时间复杂度：O(n^3)
    空间复杂度：O(n)
    1. 每一次都在一个范围内随机选取一个结点作为根。
    2. 每选取一个结点作为根，就把树切分成左右两个子树，直至该结点左右子树为空。

    大致思路如上，可以看出这也是一个可以划分成子问题求解的题目，所以考点是动态规划。
    但具体对于本题来说，采取的是自底向上的求解过程。
    1. 选出根结点后应该先分别求解该根的左右子树集合，也就是根的左子树有若干种，它们组成左子树集合，根的右子树有若干种，它们组成右子树集合。 
    1. 选出根结点后应该先分别求解该根的左右子树集合，也就是根的左子树有若干种，它们组成左子树集合，根的右子树有若干种，它们组成右子树集合。
    2. 然后将左右子树相互配对，每一个左子树都与所有右子树匹配，每一个右子树都与所有的左子树匹配。然后将两个子树插在根结点上。
    3. 最后，把根结点放入链表中。
*/
class Solution {
    public List<TreeNode> generateTrees(int n) {
        if ( n == 0) {
            return new ArrayList<TreeNode>();
        }
        return generate(1,n);
    }

    private List<TreeNode> generate(int start, int end) {
        List<TreeNode> res = new ArrayList<>();
        if (start > end) {
            res.add(null);
            return res;
        }
        if (start == end) {
            TreeNode node = new TreeNode(start);
            res.add(node);
            return res;
        }
        for (int i = start; i <= end; i++) {
            List<TreeNode> leftTree = generate(start, i - 1);
            List<TreeNode> rightTree = generate(i + 1, end);
            for (TreeNode left : leftTree) {
                for (TreeNode right : rightTree) {
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    res.add(root);
                }
            }
        }
        return res;
    }
}
