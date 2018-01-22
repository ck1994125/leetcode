/*
题目：
134. Gas Station


There are N gas stations along a circular route, where the amount of gas at station i is gas[i].

You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from station i to its next station (i+1). You begin the journey with an empty tank at one of the gas stations.

Return the starting gas station's index if you can travel around the circuit once, otherwise return -1.

分析：
    时间复杂度：O(n)
    使用HashMap。
    遍历数组，每次遍历先判断Map中是否存在（sum-num[i]）：
    1.存在，返回Map.get(sum-num[i])和当前索引i；
    2.不存在，将（num[i],i）存入Map中。
*/
class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int sum = 0;
        int start = -1;
        int currentSum = 0;

        for (int i = 0; i < gas.length; i++) {
            sum += gas[i] - cost[i];
            currentSum += gas[i] - cost[i];
            if (currentSum < 0) {
                start = i;
                currentSum = 0;
            }
        }

        return sum >= 0?start + 1:-1;
    }
}
