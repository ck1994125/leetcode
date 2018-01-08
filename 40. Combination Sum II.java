/*
题目：
40. Combination Sum II

Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

Each number in C may only be used once in the combination.

Note:
All numbers (including target) will be positive integers.
The solution set must not contain duplicate combinations.
For example, given candidate set [10, 1, 2, 7, 6, 1, 5] and target 8,
A solution set is:
[
  [1, 7],
  [1, 2, 5],
  [2, 6],
  [1, 1, 6]
]

分析：
    时间复杂度：指数级
    递归。
    和39题类似，需要注意的是，每个数字只能出现一次。
    所以，对数组进行排序后，在每一个递归的循环遍历中，遇到连续相同的数字，要跳过。
*/
class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        Arrays.sort(candidates);
        solve(res,new ArrayList<Integer>(),candidates,target,0);
        return res;
    }

    private void solve( List<List<Integer>> res, List<Integer> tmp, int[] nums, int target, int start ){
        if( target == 0 ){
            res.add(new ArrayList<>(tmp));
            return;
        }
        else if( target < 0 ){
            return;
        }
        else{
            for( int i = start; i < nums.length; i++ ){
                if( i!=start && nums[i] == nums[i-1]) continue;
                if(target-nums[i] < 0) return;
                tmp.add(nums[i]);
                solve(res,tmp,nums,target-nums[i],i+1);
                tmp.remove(tmp.size()-1);
            }
        }
        return;
    }
}
