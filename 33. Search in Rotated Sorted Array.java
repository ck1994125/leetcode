/*
 时间复杂度：O（logn）
 二分查找，因为数组是有序的，所以在二分查找时。左右必有一边是递增的，即
 若A[l]<A[m]; 数组在[l,m]内是有序递增的;
 否则，数组在[m,r]内有序递增；
 再判断目标值是否在此范围内，划分新的查找范围。
 */
 */ 
public int search(int[] nums, int target) {
        int left=0,right=nums.length-1;
        while( left<=right ){
            int mid = (left+right+1)/2;
            if( nums[mid] == target ) return mid;
            if( nums[left] < nums[mid] ){
                if( nums[left] <= target && nums[mid] > target ){
                    right=mid-1;
                }
                else{
                    left=mid+1;
                }
            }
            else{
                if( nums[mid] < target && nums[right] >= target ){
                    left = mid+1;
                }
                else{
                    right = mid-1;
                }
            }
        }
        return -1;
    }