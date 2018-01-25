/*
题目：
111. Minimum Depth of Binary Tree


Given a binary tree, find its minimum depth.

The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.


分析：
    时间复杂度：O(n)
    空间复杂度：O(n)
    DFS 和 BFS都可。
*/
// DFS
class Solution {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        else if (root.left != null && root.right != null) {
            return 1 + Math.min(minDepth(root.left), minDepth(root.right));
        }
        else if (root.left != null) {
            return 1 + minDepth(root.left);
        }
        else if (root.right != null) {
            return 1 + minDepth(root.right);
        }
        return 1;
    }
}

// BFS
class Solution {
    public int minDepth(TreeNode root) {
        if (root == null)
		return 0;
	    int depth = 1;
	    Queue<TreeNode> queue = new LinkedList<>();
	    TreeNode temp,magic = new TreeNode(0);
	    queue.add(root);
	    queue.add(magic);
	    while(!queue.isEmpty()){
		    temp = queue.poll();
            if(temp.equals(magic)){
                if(!queue.isEmpty()){
                    depth++;
                    queue.add(magic);
                }
                continue;
            }
            if(temp.left == null && temp.right == null)
                return depth;
            if(temp.left != null)
                queue.add(temp.left);
            if(temp.right != null)
                queue.add(temp.right);
        }
        return depth;
    }
}
