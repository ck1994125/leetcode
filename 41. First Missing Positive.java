/*
题目：
41. First Missing Positive

Given an unsorted integer array, find the first missing positive integer.

For example,
Given [1,2,0] return 3,
and [3,4,-1,1] return 2.

Your algorithm should run in O(n) time and uses constant space.

分析：
    时间复杂度：O(n)
    题意是寻找数组nums中缺少的第一个整数，那么这个整数的取值肯定是在[1,nums.length+1]；
    1.则可以交换数组中元素的位置，使得元素i位于nums[i-1]；
    2.在元素交换完成后，遍历数组，寻找第一个 nums[i]！=i+1 ，i+1即为所求整数。
    对于数组中的重复元素和小于1的元素，直接跳过，进行下一次遍历。
*/
class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        for( int i = 0; i < n ; ){
            if ( nums[i] != i+1 && nums[i]>0 && nums[i]<n+1 && nums[nums[i]-1] != nums[i] ){
                swap(nums,nums[i]-1,i);
            }
            else{
                i++;
            }
        }
        int i = 0;
        for( ; i < n; i++ ){
            if( nums[i] != i+1 )
                return i+1;
        }
        return i+1;
    }

    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
