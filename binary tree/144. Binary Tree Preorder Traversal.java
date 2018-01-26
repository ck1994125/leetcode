/*
题目：
144. Binary Tree Preorder Traversal


Given a binary tree, return the preorder traversal of its nodes' values.

For example:
Given binary tree [1,null,2,3],
   1
    \
     2
    /
   3
return [1,2,3].


分析：
    时间复杂度：O(n)
    空间复杂度：O(n)
    使用栈。
    解法一： 使用栈存储所有元素，先压入右节点，再压入左节点。顺序处理完所有左节点，再倒序处理右节点。
    解法二： 只使用栈存储存储右节点，通过node指针来遍历。
*/
// version 1
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            if (cur != null) {
                res.add(cur.val);
                stack.push(cur.right);
                stack.push(cur.left);
            }
        }
        return res;
    }
}
// version 2
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        TreeNode node = root;
        while (!stack.isEmpty() || node != null) {
            if (node != null) {
                res.add(node.val);
                stack.push(node.right);
                node = node.left;
            }
            else {
                node = stack.pop();
            }
        }
        return res;
    }
}
