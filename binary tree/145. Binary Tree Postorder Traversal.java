/*
题目：
145. Binary Tree Postorder Traversal


Given a binary tree, return the postorder traversal of its nodes' values.

For example:
Given binary tree [1,null,2,3],

   1
    \
     2
    /
   3


return [3,2,1].

分析：
    时间复杂度：O(n)
    空间复杂度：O(n)
    解法一： 先序输出的时候是【根左右】，后序输出是【左右根】，按照先序遍历非递归的方法，输出的时候改改顺序即可。
    解法二： 先从根节点往左，把最左侧的一条分支入栈。 最左侧走到叶子结点之后，去添加它的右子数。并判断右节点是否访问过。
*/
// version 1
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        LinkedList<Integer> res = new LinkedList<>();
        if (root == null) {
            return res;
        }
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            if (cur != null) {
                res.addFirst(cur.val);
                stack.push(cur.left);
                stack.push(cur.right);
            }
        }
        return res;
    }
}
// version 2
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        TreeNode cur = root;
        TreeNode lastNode = null;
        while (!stack.isEmpty() || cur != null) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            else{
                TreeNode top = stack.peek();
                if (top.right != null && top.right != lastNode) {
                    cur = top.right;
                }
                else {
                    res.add(top.val);
                    lastNode = stack.pop();
                }
            }
        }
        return res;
    }
}
