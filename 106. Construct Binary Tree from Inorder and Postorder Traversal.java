/*
题目：
106. Construct Binary Tree from Inorder and Postorder Traversal

Given inorder and postorder traversal of a tree, construct the binary tree.


分析：
    时间复杂度：O(n)
    空间复杂度：O(n)
    本题与先序和中序求二叉树类似，区别在于在后序遍历中，根节点最后遍历。
    这种类型的提比较简单，可以先画出二叉树，求出其各种顺序的遍历序列，然后根据序列特征求解即可。
*/
class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || inorder.length == 0) {
            return null;
        }
        if (postorder == null || postorder.length == 0) {
            return null;
        }
        return build(inorder, 0, inorder.length - 1, postorder, postorder.length - 1);
    }

    private TreeNode build(int[] inorder, int start, int end, int[] postorder, int index) {
        if (start > end || index < 0) {
            return null;
        }
        TreeNode root = new TreeNode(postorder[index]);
        int rootNum = 0;
        for (int i = start; i <= end; i++) {
            if (inorder[i] == root.val) {
                rootNum = i;
                break;
            }
        }
        root.left = build(inorder, start, rootNum - 1, postorder, index - (end -rootNum) - 1);
        root.right = build(inorder, rootNum + 1, end, postorder, index - 1);
        return root;
    }
}
