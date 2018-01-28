/*
题目：
199. Binary Tree Right Side View


Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.

For example:
Given the following binary tree,
   1            <---
 /   \
2     3         <---
 \     \
  5     4       <---
You should return [1, 3, 4].

分析：
    时间复杂度：O(n)
    空间复杂度：O(n)
    BFS.
*/
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        queue.offer(root);
        res.add(root.val);
        while (!queue.isEmpty()) {
            int levelNum = queue.size();
            boolean isFind = false;
            for (int i = levelNum; i > 0; i--) {
                TreeNode cur = queue.poll();
                if (cur.right != null) {
                    queue.offer(cur.right);
                    if (isFind == false) {
                        res.add(cur.right.val);
                        isFind = true;
                    }
                }
                if (cur.left != null) {
                    queue.offer(cur.left);
                    if (isFind == false) {
                        res.add(cur.left.val);
                        isFind = true;
                    }
                }
            }
        }

        return res;
    }
}
