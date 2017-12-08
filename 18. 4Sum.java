/*
题目：
18. 4Sum

Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target?
Find all unique quadruplets in the array which gives the sum of target.

分析：
    时间复杂度：O(n3)
    和3 sum思路相同，三层循环。
    注意：每层的相同数值判断，尤其第二层。
*/
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        ArrayList<List<Integer>> res = new ArrayList<List<Integer>>();
        int len = nums.length;
        Arrays.sort(nums);

        for( int i = 0 ; i < len-3 ; i++ ){
            if( i!=0 && nums[i-1] == nums[i] ) continue;
            for( int j = i+1 ; j<len-2 ; j++) {
                if( i!=j-1 && nums[j-1] == nums[j] ) continue;
                int sum = target - nums[i] - nums[j];
                for( int k = j+1 , l = len -1 ; k<l  ;){
                    if( nums[k]+nums[l] == sum ){
                        res.add(Arrays.asList(nums[i],nums[j],nums[k],nums[l]));
                        k++;l--;
                        while( k<l && nums[k] == nums[k-1] ) k++;
                        while( k<l && nums[l] == nums[l+1] ) l--;
                    }
                    else if ( nums[k]+nums[l] < sum ){
                         k++;
                         while( k<l && nums[k] == nums[k-1] ) k++;
                    }
                    else {
                        l--;
                        while( k<l && nums[l] == nums[l+1] ) l--;
                    }
                }
            }
        }
        return res;
    }
}
