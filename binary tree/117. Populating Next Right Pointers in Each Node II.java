/*
题目：
117. Populating Next Right Pointers in Each Node II

Follow up for problem "Populating Next Right Pointers in Each Node".

What if the given tree could be any binary tree? Would your previous solution still work?

Note:

You may only use constant extra space.
For example,
Given the following binary tree,
         1
       /  \
      2    3
     / \    \
    4   5    7
After calling your function, the tree should look like:
         1 -> NULL
       /  \
      2 -> 3 -> NULL
     / \    \
    4-> 5 -> 7 -> NULL

分析：
    时间复杂度：O(n)
    空间复杂度：O(n)
    和上题类似.
*/
public class Solution {
    public void connect(TreeLinkNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return;
        }
        TreeLinkNode pre = root;

        while (pre != null) {
            TreeLinkNode first = null;
            TreeLinkNode start = null;
            TreeLinkNode cur = pre;
            while (cur != null) {
                if (cur.left != null) {
                    if (first != null) {
                        first.next = cur.left;
                    }
                    else {
                        start = cur.left;
                    }
                    first = cur.left;
                }
                if (cur.right != null) {
                    if (first != null) {
                        first.next = cur.right;
                    }
                    else {
                        start = cur.right;
                    }
                    first = cur.right;
                }
                cur = cur.next;
            }
            pre = start;
        }
    }
}
