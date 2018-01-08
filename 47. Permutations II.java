/*
题目：
47. Permutations II

Given a collection of numbers that might contain duplicates, return all possible unique permutations.

For example,
[1,1,2] have the following unique permutations:
[
  [1,1,2],
  [1,2,1],
  [2,1,1]
]

分析：
    时间复杂度：指数级
    和前一题相同，去重即可；
*/
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        permutation(res, nums, 0);
        HashSet set = new HashSet(res);
        res.clear();
        res.addAll(set);
        return res;
    }

    private void permutation( List<List<Integer>> res, int[] nums, int index ){
        if( index == nums.length ){
            List<Integer> tmp = new ArrayList<>();
            for( int i = 0; i<nums.length; i++ ){
                tmp.add(nums[i]);
            }
            res.add(tmp);
            return;
        }
        for( int i=index; i<nums.length; i++ ){
            swap(nums,i,index);
            permutation(res,nums,index+1);
            swap(nums,i,index);
        }
        return;
    }

    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
