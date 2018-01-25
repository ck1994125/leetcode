/*
题目：
116. Populating Next Right Pointers in Each Node

Given a binary tree

    struct TreeLinkNode {
      TreeLinkNode *left;
      TreeLinkNode *right;
      TreeLinkNode *next;
    }
Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.

Initially, all next pointers are set to NULL.

Note:

You may only use constant extra space.
You may assume that it is a perfect binary tree (ie, all leaves are at the same level, and every parent has two children).
For example,
Given the following perfect binary tree,
         1
       /  \
      2    3
     / \  / \
    4  5  6  7
After calling your function, the tree should look like:
         1 -> NULL
       /  \
      2 -> 3 -> NULL
     / \  / \
    4->5->6->7 -> NULL

分析：
    时间复杂度：O(n)
    空间复杂度：O(n)
    DFS 和 BFS.
*/
//DFS
public class Solution {
    public void connect(TreeLinkNode root) {
        if (root == null || root.left == null) {
            return;
        }
        connected(root.left, root.right);
    }
    private void connected(TreeLinkNode first, TreeLinkNode second) {
        first.next = second;
        if (first.left != null) {
            connected(first.left, first.right);
            connected(first.right, second.left);
            connected(second.left, second.right);
        }
    }
}

//迭代，广度优先
public class Solution {
    public void connect(TreeLinkNode root) {
        if (root == null) {
            return;
        }
        TreeLinkNode pre = root;
        TreeLinkNode cur = null;
        while(pre.left != null) {
            cur = pre;
            while (cur != null) {
                cur.left.next = cur.right;
                cur.right.next = (cur.next == null)?null:cur.next.left;
                cur = cur.next;
            }
            pre = pre.left;
        }
    }
}
