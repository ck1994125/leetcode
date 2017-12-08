/*
题目：
1. Two Sum

Given an array of integers, return indices of the two numbers such that they add up to a specific target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

分析：
    时间复杂度：O(n)
    使用HashMap。
    遍历数组，每次遍历先判断Map中是否存在（sum-num[i]）：
    1.存在，返回Map.get(sum-num[i])和当前索引i；
    2.不存在，将（num[i],i）存入Map中。
*/
public class Solution {
    public int[] twoSum(int[] nums, int target) {
    int[] result = new int[2];
    Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    for (int i = 0; i < nums.length; i++) {
        if (map.containsKey(target - nums[i])) {
            result[1] = i ;
            result[0] = map.get(target - nums[i]);
            return result;
        }
        map.put(nums[i], i );
    }
    return result;
    }
}
