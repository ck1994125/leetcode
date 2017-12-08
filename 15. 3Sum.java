/*
题目：
15. 3Sum

Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0?
Find all unique triplets in the array which gives the sum of zero.

分析：
    时间复杂度：O(n2)
    先排序，然后两层循环
    第一层循环依次遍历每个数；
    第二次循环从两侧向中间夹逼遍历。
    注意：
    1.注意越过相等数值，否则结果会有重复（第一层和第二层都是）
*/
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res_set = new ArrayList<>();

        Arrays.sort(nums);

        for ( int i=0 ; i<nums.length ; i++ ){
            if ( nums[i]>0 ) break;
            if ( i!=0 && nums[i] == nums[i-1]) continue;
            for ( int j=i+1 , k=nums.length-1 ; j<k ;  ){
                int obj = -nums[i];
                List<Integer> res = new ArrayList<Integer>();
                if( nums[j]+nums[k] > obj ){
                    k--;
                    while( k>j && nums[k] == nums[k+1] ) k--;
                }
                else if( nums[j]+nums[k] < obj ){
                    j++;
                    while( j<k && nums[j] == nums[j-1] ) j++;
                }
                else{
                    res.add(nums[i]);
                    res.add(nums[j]);
                    res.add(nums[k]);
                    res_set.add(res);
                    j++;k--;
                    while( j<k && nums[k] == nums[k+1] && nums[j] == nums[j-1]){
                        j++;k--;
                    }
                }
            }
        }
        return res_set;
    }
}
