/*
题目：
42. Trapping Rain Water

Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.

For example,
Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.

分析：
    时间复杂度：O(n)
    使用两个指针，从两端向中间移动；
    当左边指针所指的值较大时，如果当前值小于当前左侧最大值，其差值即为该位置水量；否则，更新左侧最大值；左侧指针前移；
    右侧指针同理。
*/
class Solution {
    public int trap(int[] height) {
        int left = 0,right = height.length-1;
        int res = 0;
        int left_max = 0, right_max = 0;
        while( left<right ){
            if( height[left] < height[right] ){
                if( height[left] >= left_max ){
                    left_max = height[left];
                }
                else{
                    res += left_max - height[left];
                }
                left++;
            }
            else{
                if( height[right] >= right_max ){
                    right_max = height[right];
                }
                else{
                    res += right_max - height[right];
                }
                right--;
            }
        }
        return res;
    }
}
