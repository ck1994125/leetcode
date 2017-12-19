/*
题目：
31. Next Permutation

Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.

If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).

The replacement must be in-place, do not allocate extra memory.

Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.

分析：
    时间复杂度：O(n)
    求全排列的下一个排列
    从当前序列中从右至左找第一个左邻小于右邻的数，如果找不到，则所有排列求解完成，直接进行升序排序；
    （其实不用排序，直接反转即可，因为其已经是降序排列）
    如果找得到(索引为index)则说明排列未完成：
        1.继续从右向左寻找大于nums[index]的第一个数，交换两数的位置；
        2.将序列中（index,end）的数进行升序排序。
*/
class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int index = n-1;

        while( index > 0 ){
            if( nums[index-1] < nums[index] ){
                break;
            } //判断递增
            index--;
        }

        if( index == 0 ){
            Arrays.sort(nums,index, n);
        }
        else{
            int tmp = nums[index-1];
            int i = n-1;
            while( i >= index-1 ){
                if( nums[i] > tmp ){
                    break;
                }
                i--;
            }
            swap(nums,index-1,i);
		    Arrays.sort(nums,index, n); // 不需要重新，只需翻转即可
        }
    }
    public void swap(int[] A, int i, int j) {
        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }
}
