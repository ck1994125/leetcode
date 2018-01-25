/*
题目：
113. Path Sum II


Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.

For example:
Given the below binary tree and sum = 22,
              5
             / \
            4   8
           /   / \
          11  13  4
         /  \    / \
        7    2  5   1
return
[
   [5,4,11,2],
   [5,8,4,5]
]


分析：
    时间复杂度：O(n)
    空间复杂度：O(n)
    DFS。
*/
class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        find(root, res, new ArrayList<Integer>(), sum);
        return res;
    }

    private void find(TreeNode root, List<List<Integer>> res, List<Integer> tmp, int sum) {
        if (root == null) {
            return;
        }
        tmp.add(root.val);
        if (root.val == sum && root.left == null && root.right == null) {
            res.add(new ArrayList<Integer>(tmp));
            tmp.remove(tmp.size() - 1); // 注意这里也要删除最后一个节点
            return;
        }
        find(root.left, res, tmp, sum - root.val);
        find(root.right, res, tmp, sum - root.val);
        tmp.remove(tmp.size() - 1);
        return;
    }
}
