/*
题目：
4. Median of Two Sorted Arrays

There are two sorted arrays nums1 and nums2 of size m and n respectively.

Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).

分析：
    我们比较A[k/2-1]和B[k/2-1]两个元素，这两个元素分别表示A的第k/2小的元素和B的第k/2小的元素。
    这两个元素比较共有三种情况：>、<和=:
    如果A[k/2-1]<B[k/2-1]，这表示A[0]到A[k/2-1]的元素都在A和B合并之后的前k小的元素中。换句话说，A[k/2-1]不可能大于两数组合并之后的第k小值，所以我们可以将其抛弃。
*/
class Solution {
   public double findMedianSortedArrays(int[] nums1, int[] nums2) {
       int m = nums1.length;
       int n = nums2.length;
       int total = m+n;
       if( total % 2 == 1 ) return findKth(nums1 , 0 , nums2 , 0 , total/2+1);
       else return (findKth(nums1 , 0 , nums2 , 0 , total/2)+findKth(nums1 , 0 , nums2 , 0 , total/2+1))/2.0;
   }

   public double findKth(int[] nums1, int aStart , int[] nums2 , int bStart , int k){
       if( aStart > nums1.length-1 ) return nums2[bStart+k-1];
       if( bStart > nums2.length-1 ) return nums1[aStart+k-1];
       if( k == 1 ) return Math.min(nums1[aStart],nums2[bStart]);

       int aMid=Integer.MAX_VALUE,bMid=Integer.MAX_VALUE;
       if( aStart+k/2-1 < nums1.length ) aMid=nums1[aStart+k/2-1];
       if( bStart+k/2-1 < nums2.length ) bMid=nums2[bStart+k/2-1];

       if( aMid<bMid ) return findKth( nums1 , aStart+k/2 , nums2 , bStart , k-k/2 );
       else return findKth( nums1 , aStart , nums2 , bStart+k/2 , k-k/2 );

   }
}
