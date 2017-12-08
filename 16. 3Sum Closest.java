/*
题目：
16. 3Sum Closest

Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target.
Return the sum of the three integers. You may assume that each input would have exactly one solution.

分析：
    时间复杂度：O(n2)
    先排序，然后两层循环
    第一层循环依次遍历每个数；
    第二次循环从两侧向中间夹逼遍历。
    注意：
    1.注意越过相等数值，否则结果会有重复（第一层和第二层都是）
    总体和3 sum思路相同，但是要注意在判断最小时使用abs判断。
*/
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int min = Integer.MAX_VALUE;
        Arrays.sort(nums);
        for ( int i=0 ; i<nums.length-2 ; i++ ){
            if (  i!=0 && nums[i] == nums[i-1] ) continue;
            for ( int j=i+1, k=nums.length-1 ; j<k ;  ){
                int current;
                int sum = nums[i]+nums[j]+nums[k];
                if ( sum == target ) return target;
                else if ( sum>target ){
                    k--;
                }
                else {
                    j++;
                }
                current = sum - target;
                min = Math.abs(min)<Math.abs(current)?min:current;
            }

        }
        return target + min;
    }
}
