/*
题目：
46. Permutations

Given a collection of distinct numbers, return all possible permutations.

For example,
[1,2,3] have the following permutations:
[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]

分析：
    时间复杂度：指数级
    题意为求全排列，使用递归。
    根据索引index来判断当前的遍历位置，index前为当前排列的前缀，依次交换index和当前位置i的元素，形成新排列。
*/
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        permutation(res, nums, 0);
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
