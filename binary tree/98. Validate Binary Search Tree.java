/*
题目：
98. Validate Binary Search Tree

Given a binary tree, determine if it is a valid binary search tree (BST).

Assume a BST is defined as follows:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.
Example 1:
    2
   / \
  1   3
Binary tree [2,1,3], return true.
Example 2:
    1
   / \
  2   3
Binary tree [1,2,3], return false.

分析：
    时间复杂度：O(n)
    空间复杂度：O(1)
    递归的解题思路是DFS，但是需要注意，左子树的所有节点在满足二叉搜索树的基础上，还要小于根节点；同理右子树的节点都要大于根节点。
    迭代的解题思路是对于二叉搜索树，中序遍历，节点应为递增序列。

*/
class Solution { // recursive
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean isValidBST(TreeNode root, long minVal, long maxVal) {
        if (root == null) return true;
        if (root.val >= maxVal || root.val <= minVal) return false;
        return isValidBST(root.left, minVal, root.val) && isValidBST(root.right, root.val, maxVal);
    }
}

class Solution { // iterative
    public boolean isValidBST(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        TreeNode pre = null;
        while (!stack.isEmpty() || cur != null) {
            if (cur == null) {
                cur = stack.pop();
                if (pre != null && cur.val <= pre.val) {
                    return false;
                }
                pre = cur;
                cur = cur.right;
            }
            else {
                stack.push(cur);
                cur = cur.left;
            }
        }
        return true;
    }


}
