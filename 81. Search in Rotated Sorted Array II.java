 /*
题目：
81. Search in Rotated Sorted Array II

Follow up for "Search in Rotated Sorted Array":
What if duplicates are allowed?

Would this affect the run-time complexity? How and why?
Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

Write a function to determine if a given target is in the array.

The array may contain duplicates.

分析：
时间复杂度：O（logn）
依然是二分查找的思想，但是这个问题是数组中存在重复的元素，所以会出现A[m]=A[r]这种情况，而这种情况是无法判断哪一边是有序递增的，所以需要将相等的情况单独列出;
即：
    A[m]<A[r]:数组在[m,r]内有序递增；
    A[m]>A[r]:数组在[l,m]内有序递增；
    A[m]=A[r]:r--;
  */   



class Solution {
    public boolean search(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        while( left<=right ){
            int mid = (left+right+1)/2;
            if( nums[mid] == target ) return true;
            if( nums[mid] < nums[right] ) {
                if( nums[mid] < target && target <= nums[right]) left=mid+1;
                else right=mid-1;
            } 
            else if( nums[mid] > nums[right] ){
                if( nums[mid] > target && target >= nums[left]) right=mid-1;
                else left=mid+1;
            }
            else{ 
                right--;
            }
        }
        return false;
    }
}