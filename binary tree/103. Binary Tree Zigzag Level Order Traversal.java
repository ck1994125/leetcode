/*
题目：
103. Binary Tree Zigzag Level Order Traversal

Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its zigzag level order traversal as:
[
  [3],
  [20,9],
  [15,7]
]

分析：
    时间复杂度：O(n)
    空间复杂度：O(n)
    解题思路依然是BFS。
    设置标志位order表示存储顺序，true表示从左到右，false表示从右到左。
    每次遍历完当前层后对order求反。
*/
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();

        if (root == null) {
            return res;
        }

        Boolean order = true;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> tmp = new ArrayList<>();
            int levelNum = queue.size();
            for (int i = 0; i < levelNum; i++) {
                TreeNode cur = queue.poll();
                if (order == true) {
                    tmp.add(cur.val);
                }
                else {
                    tmp.add(0,cur.val);
                }

                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }

            res.add(tmp);
            order = order?false:true;
        }

        return res;
    }
}
