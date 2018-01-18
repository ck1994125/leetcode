/*
题目：
25. Reverse Nodes in k-Group

Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.

k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.

You may not alter the values in the nodes, only nodes itself may be changed.

Only constant memory is allowed.

For example,
Given this linked list: 1->2->3->4->5

For k = 2, you should return: 2->1->4->3->5

For k = 3, you should return: 3->2->1->4->5

分析：
    时间复杂度：O(n)
    pre和tail两个指针分别记录本组k个节点的前一个节点，当前k个节点翻转后的尾部。
    pre.next指向本组k个节点的头结点，tail.next指向下一组节点。
*/
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        int len = 0;
        ListNode start = new ListNode(-1);
        start.next = head;
        ListNode cursor = head;
        while (cursor != null) {
            len++;
            cursor = cursor.next;
        }

        for (ListNode tail = head, pre = start ; len >= k; len -= k) {
            for (int i = 1; i < k; i++) {
                ListNode next = tail.next.next;
                tail.next.next = pre.next;
                pre.next = tail.next;
                tail.next = next;
            }
            pre = tail;
            tail = tail.next;
        }

        return start.next;
    }
}
