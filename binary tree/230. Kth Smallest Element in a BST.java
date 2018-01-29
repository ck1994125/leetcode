/*
题目：
230. Kth Smallest Element in a BST

Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.

分析：
    时间复杂度：O(n)
    空间复杂度：O(n)
    解法一： 根据二叉搜索树的特征。计算其左子树的节点个数count:
            1.如果 k < count + 1,则节点在左子树中;(第k个)
            2.如果 k > count + 1,则节点在右子树中;(第k-count-1个)
            3.如果 k = count + 1,则节点为当前节点。

    解法二：中序遍历二叉树，找到第k个节点。

    解法三：中序遍历的迭代解法。
*/
// DFS by Binary Search
class Solution {
    public int kthSmallest(TreeNode root, int k) {
        int count = countNodes(root.left);
        if (k < count + 1) {
            return kthSmallest(root.left, k);
        }
        else if (k > count + 1) {
            return kthSmallest(root.right, k - count - 1);
        }
        return root.val;
    }
    private int countNodes (TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + countNodes(root.left) + countNodes(root.right);
    }
}
// DFS by in-order
class Solution {
    public int count = 0;
    public int number = 0;
    public int kthSmallest(TreeNode root, int k) {
        count = k;
        dfs(root);
        return number;
    }
    private void dfs (TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.left);
        count--;
        if (count == 0) {
            number = root.val;
            return;
        }
        dfs(root.right);
        return;
    }
}
// iterative by in-order
class Solution {

    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            k--;
            if (k == 0) {
                return cur.val;
            }
            TreeNode right = cur.right;
            while(right != null) {
                stack.push(right);
                right = right.left;
            }
        }
        return -1;
    }
    // another
    public int kthSmallest(TreeNode root, int k) {
    Stack<TreeNode> stack = new Stack<>();
    TreeNode cur = root;
    while (cur != null || !stack.isEmpty()) {
        while(cur != null) {
            stack.push(cur);
            cur = cur.left;
        }

        cur = stack.pop();
        k--;
        if (k == 0) {
            return cur.val;
        }
        cur = cur.right;
    }
    return -1;
}
