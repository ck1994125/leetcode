/*
题目：
222. Count Complete Tree Nodes


Given a complete binary tree, count the number of nodes.


分析：
    时间复杂度：O(n)
    空间复杂度：O(n)
    DFS。如果右子树的深度不为 h - 1,说明右子树没有第h层，则右子树节点个数必为 2^(h - 1) - 1，那计算 1（根节点） + 2^(h - 1) + 左子树节点个数即可；
    否则，左子树节点个数必定为2^h - 1，计算1 + 2^h + 右子树的节点个数。
*/
class Solution {
    public int countNodes(TreeNode root) {
        int h = height(root);
        return h < 0 ? 0 :
               height(root.right) == h-1 ? (1 << h) + countNodes(root.right)
                                         : (1 << h-1) + countNodes(root.left);
    }

    int height(TreeNode root) {
        return root == null ? -1 : 1 + height(root.left);
    }
}
