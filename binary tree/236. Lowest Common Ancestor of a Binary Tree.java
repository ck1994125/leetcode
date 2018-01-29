/*
题目：
236. Lowest Common Ancestor of a Binary Tree


Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.

According to the definition of LCA on Wikipedia:
“The lowest common ancestor is defined between two nodes v and w as the lowest node in T that has both v and w as descendants
(where we allow a node to be a descendant of itself).”

        _______3______
       /              \
    ___5__          ___1__
   /      \        /      \
   6      _2       0       8
         /  \
         7   4
For example, the lowest common ancestor (LCA) of nodes 5 and 1 is 3.
Another example is LCA of nodes 5 and 4 is 5, since a node can be a descendant of itself according to the LCA definition.


分析：
    时间复杂度：O(n)
    空间复杂度：O(n)
    DFS。在左右子树中遍历p或q是否存在。
    1.若左子树中不存在，则在右子树中遍历；
    2.若右子树不存在，则在左子树中遍历；
    3.左右子树都存在，则返回根节点。

    迭代方法。
    1.初始化Map变量parent，存储所有节点的父节点；
    2.找出节点p的所有父亲节点，并存储在集合ancestors中；
    3.依次遍历节点q的父亲节点，第一个存在于ancestors中的节点即为最小公共祖先，返回该节点。
*/
//recursive
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if ( left == null) {
            return right;
        }
        else if (right == null) {
            return left;
        }
        return root;
    }
}
//iterative
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Map<TreeNode, TreeNode> parent = new HashMap<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        parent.put(root, null);
        stack.push(root);

        while (!parent.containsKey(p) || !parent.containsKey(q)) {
            TreeNode node = stack.pop();
            if (node.left != null) {
                parent.put(node.left, node);
                stack.push(node.left);
            }
            if (node.right != null) {
                parent.put(node.right, node);
                stack.push(node.right);
            }
        }
        Set<TreeNode> ancestors = new HashSet<>();
        while (p != null) {
            ancestors.add(p);
            p = parent.get(p);
        }
        while (!ancestors.contains(q))
            q = parent.get(q);
        return q;
    }
}
