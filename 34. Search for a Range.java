/*
题目：
34. Search for a Range

Given an array of integers sorted in ascending order, find the starting and ending position of a given target value.

Your algorithm's runtime complexity must be in the order of O(log n).

If the target is not found in the array, return [-1, -1].

For example,
Given [5, 7, 7, 8, 8, 10] and target value 8,
return [3, 4].

分析：
    时间复杂度：O(logn)
    使用两次二分搜索，分别查找起点和终点，主要思想是当nums[mid] == target时，起点肯定在mid(包括mid)左侧，终点肯定在mid(包括mid)右侧。
    需要注意的是，当查找终点时，会出现left == mid,程序会陷入死循环；
    这时需要将 mid = (left + right) / 2 修改为mid = (left + right + 1) / 2;因为mid == right不会导致死循环。
*/
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int [] res = new int[2];
        int left = 0, right = nums.length-1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            }
            else {
                right = mid;
            }

        }
        if (left == nums.length || nums[left] != target) return new int[]{-1, -1};
        res[0] = left;
        left = 0;
        right = nums.length-1;
        while (left < right) {
            int mid = (left + right ) / 2;
            if (nums[mid] > target) {
                right = mid - 1;
            }
            else {
                left = mid;
            }
        }
        res[1] = left;

        return res;
    }
}
