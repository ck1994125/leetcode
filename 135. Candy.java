/*
题目：
135. Candy

There are N children standing in a line. Each child is assigned a rating value.

You are giving candies to these children subjected to the following requirements:

Each child must have at least one candy.
Children with a higher rating get more candies than their neighbors.

分析：
    时间复杂度：O(n)
    空间复杂度：O(n)
    贪婪算法，使用need数组记录当前糖果数，初始化为1.
             从左到右，当前位比左边的大，则+1；
             再右到左，当前位比右边位的大，则+1；
             取两次遍历的最大值，即为符合条件的值。
*/
class Solution {
    public int candy(int[] ratings) {
        if (ratings == null || ratings.length == 0) {
            return 0;
        }
        int[] need = new int[ratings.length];
        Arrays.fill(need, 1);
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                need[i] = need[i - 1] + 1;
            }
        }
        int res = need[ratings.length - 1];
        for (int i = ratings.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                need[i] = Math.max(need[i],need[i + 1] + 1);
            }
            res += need[i];
        }
        return res;
    }
}
