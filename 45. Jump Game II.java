/*
题目：
45. Jump Game II

Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Your goal is to reach the last index in the minimum number of jumps.

For example:
Given array A = [2,3,1,1,4]

The minimum number of jumps to reach the last index is 2. (Jump 1 step from index 0 to 1, then 3 steps to the last index.)

分析：
    时间复杂度：O(n)
    贪婪算法
*/
class Solution {
    public int jump(int[] nums) {
        int target = nums.length-1;
        int max_pos = 0;
        int current_pos = 0;
        int res = 0;
        for( int i=0 ; i<nums.length-1; i++ ){
            max_pos = Math.max(max_pos, nums[i]+i);
            if( i == current_pos ){
                res++;
                current_pos = max_pos;
            }
        }
        return res;
    }
}
