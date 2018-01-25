/*
题目：
105. Construct Binary Tree from Preorder and Inorder Traversal

Given preorder and inorder traversal of a tree, construct the binary tree.


分析：
    时间复杂度：O(n)
    在中序数组中找出当前根节点的索引rootNum，其左侧都为左子树，右侧都为右子树。
    在先序数组中，index = 0即为根节点，左子树的根节点索引为index+1，右子树的根节点索引为 index+左子树的节点个数+1；
    依次递归求解左子树和右子树。
*/
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder, 0, inorder, 0, preorder.length - 1);
    }

    private TreeNode build(int[] preorder, int index, int[] inorder, int start, int end) {
        if (index > preorder.length - 1 || start > end) {
            return null;
        }
        int len = preorder.length;
        TreeNode root = new TreeNode(preorder[index]);
        int rootNum = 0;
        for (int i = start; i <= end; i++) {
            if (root.val == inorder[i]) {
                rootNum = i;
                break;
            }
        }
        root.left = build(preorder, index + 1, inorder, start, rootNum - 1);
        root.right = build(preorder, index + rootNum - start + 1, inorder, rootNum + 1, end);

        return root;
    }
}
