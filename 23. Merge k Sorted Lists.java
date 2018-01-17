/*
题目：
23. Merge k Sorted Lists

Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.

分析：
    时间复杂度：假设数组长度为n，每个list的平均长度为m，则时间复杂度为O(n*m*logn)
    使用分治的解题思路，将合并整个数组转换为合并前半部分数组和后半部分数组，并依此递归处理，直到数组的大小为1。
*/
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        if (lists.length == 1) return lists[0];

        return divide(lists, 0, lists.length-1);
    }

    private ListNode divide(ListNode[] lists, int start, int end) {
        if (start == end) return lists[start];
        if (start < end) {
            int mid = (start + end) / 2;
            ListNode firstList = divide(lists, start, mid);
            ListNode secondList = divide(lists, mid+1, end);
            ListNode head = new ListNode(-1);
            ListNode cursor = head;
            while (firstList != null && secondList != null) {
                if (firstList.val < secondList.val) {
                    cursor.next = firstList;
                    firstList = firstList.next;
                }
                else {
                    cursor.next = secondList;
                    secondList = secondList.next;
                }
                cursor = cursor.next;
            }
            while (firstList != null) {
                cursor.next = firstList;
                firstList = firstList.next;
                cursor = cursor.next;
            }
            while (secondList != null) {
                cursor.next = secondList;
                secondList = secondList.next;
                cursor = cursor.next;
            }
            return head.next;
        }
        else {
            return null;
        }
    }
}
