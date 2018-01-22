/*
题目：
86. Partition List

Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.

You should preserve the original relative order of the nodes in each of the two partitions.

For example,
Given 1->4->3->2->5->2 and x = 3,
return 1->2->2->4->3->5.

分析：
    时间复杂度：O(n)
    空间复杂度：O(n)
    使用两个节点分别指向小于x的节点和大于等于x的节点，形成两个链表，然后将两个链表相连。
*/
class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode cursor = head;
        ListNode lowHead = new ListNode(-1);
        ListNode highHead = new ListNode(-1);
        ListNode low = lowHead;
        ListNode high = highHead;

        while (cursor != null) {
            if (cursor.val >= x) {
                high.next = cursor;
                high = cursor;
            }
            else {
                low.next = cursor;
                low = cursor;
            }
            cursor = cursor.next;
        }
        low.next = highHead.next;
        high.next = null;
        return lowHead.next;

    }
}
