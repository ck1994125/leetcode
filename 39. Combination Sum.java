/*
题目：
39. Combination Sum

Given a set of candidate numbers (C) (without duplicates) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

The same repeated number may be chosen from C unlimited number of times.

Note:
All numbers (including target) will be positive integers.
The solution set must not contain duplicate combinations.
For example, given candidate set [2, 3, 6, 7] and target 7,
A solution set is:
[
  [7],
  [2, 2, 3]
]

分析：
    时间复杂度：指数级
    递归。
    该问题需要注意代码中 tmp的初始化操作 。
*/
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> tmp = new ArrayList<Integer>();
        Arrays.sort(candidates);
        solve(tmp,res,candidates,target,0);
        return res;
    }

    private void solve(List<Integer> tmp, List<List<Integer>> res, int[] candidates, int target, int start ){
        if( target == 0 ){
            res.add(new ArrayList<>(tmp)); // 注意初始化
            return;
        }
        else if( target < 0 ){
            return;
        }
        else{
            for( int i = start; i<candidates.length; i++ ){
                tmp.add(candidates[i]);
                solve(tmp,res,candidates,target-candidates[i],i);
                tmp.remove(tmp.size() - 1);
            }
        }
        return;
    }
}
